package org.wechatapps.executors;

import org.wechatapps.annotation.EventComponent;
import org.wechatapps.po.BaseMessage;
import org.wechatapps.po.recieve.ReceiveTextMessage;
import org.wechatapps.utils.WechatUtils;

/*
 * @Description Test Event Executor
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
@EventComponent(key = "大写转换", type = 2)
public class TestEventExecutor implements EventExecutor {
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
        String content = "转换结果：" + textMessage.getContent().toUpperCase();
        return WechatUtils.buildTextMessageForResp(textMessage.getToUserName(), textMessage.getFromUserName(), content);
    }

    @Override
    public String desc(BaseMessage message) {
        String content = "请输入你要转换的小写字母";
        return WechatUtils.buildTextMessageForResp(message.getToUserName(), message.getFromUserName(), content);
    }
}
