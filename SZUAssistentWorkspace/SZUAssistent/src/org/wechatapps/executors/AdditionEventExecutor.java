package org.wechatapps.executors;

import org.wechatapps.annotation.EventComponent;
import org.wechatapps.po.BaseMessage;
import org.wechatapps.po.recieve.ReceiveTextMessage;
import org.wechatapps.utils.WechatUtils;

/*
 * @Description 
 * @author Charles Chen
 * @date 14-5-3
 * @version 1.0
 */
@EventComponent(key = "ADD", type = 2)
public class AdditionEventExecutor implements EventExecutor {
    @Override
    public String execute(BaseMessage message) {
        if (message == null) return null;
        ReceiveTextMessage textMessage;
        try {
            textMessage = (ReceiveTextMessage) message;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
        String[] nums = textMessage.getContent().split(" ");
        if (nums.length != 2) {
            String warning = "请输入两个加数";
            return WechatUtils.buildTextMessageForResp(textMessage.getToUserName(), textMessage.getFromUserName(), warning);
        }
        try {
            double sum = 0;
            for (String num : nums) {
                sum += Double.parseDouble(num);
            }
            String content = "加法结果是：" + sum;
            return WechatUtils.buildTextMessageForResp(textMessage.getToUserName(), textMessage.getFromUserName(), content);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String warning = "输入的加数必须为数字";
            return WechatUtils.buildTextMessageForResp(textMessage.getToUserName(), textMessage.getFromUserName(), warning);
        }
    }

    @Override
    public String desc(BaseMessage message) {
        String content = "请输入两个加数，以空格分隔";
        return WechatUtils.buildTextMessageForResp(message.getToUserName(), message.getFromUserName(), content);
    }
}
