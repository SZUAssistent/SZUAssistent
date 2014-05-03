package org.wechatapps.bean;


import org.wechatapps.po.Message;
import org.wechatapps.po.event.ClickEvent;
import org.wechatapps.po.recieve.*;

/**
 * Created by chaoch on 14-2-19.
 */

/*
 * @Description Wechat Message Proccessor Interface
 * @author Charles Chen
 * @date 14-2-19
 * @version 1.0
 */
public interface WechatProcessor {
    String process(Message message);

    String processText(ReceiveTextMessage text);

    String processClickEvent(ClickEvent event);

    String processVoice(ReceiveVoiceMessage voice);

    String processVideo(ReceiveVideoMessage video);

    String processPic(ReceivePicMessage picture);

    String processLink(ReceiveLinkMessage link);

    String processLocation(ReceiveLocationMessage location);
}
