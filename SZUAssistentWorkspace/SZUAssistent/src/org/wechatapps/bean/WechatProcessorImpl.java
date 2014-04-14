package org.wechatapps.bean;

import org.wechatapps.po.Message;
import org.wechatapps.po.recieve.*;
import org.wechatapps.utils.WechatUtils;

/*
 * @Description Wechar Message Proccessor
 * @author Charles Chen
 * @date 14-2-19
 * @version 1.0
 */
public class WechatProcessorImpl implements WechatProcessor {

    /**
     * Process message according to the type
     *
     * @param message
     * @return
     */
    public String process(Message message) {
        String type = message.getType();
        if (type == null) {
            return null;
        }
        if (message.getMess() == null) {
            return null;
        }
        String processedResult;
        switch (WechatUtils.MESS_TYPE.valueOf(type.toUpperCase())) {
            case TEXT:
                processedResult = processText((ReceiveTextMessage) message.getMess());
                break;
            case IMAGE:
                processedResult = processPic((ReceivePicMessage) message.getMess());
                break;
            case VOICE:
                processedResult = processVoice((ReceiveVoiceMessage) message.getMess());
                break;
            case VIDEO:
                processedResult = processVideo((ReceiveVideoMessage) message.getMess());
                break;
            case LOCATION:
                processedResult = processLocation((ReceiveLocationMessage) message.getMess());
                break;
            case LINK:
                processedResult = processLink((ReceiveLinkMessage) message.getMess());
                break;
            default:
                processedResult = null;
                break;
        }
        return processedResult;
    }

    @Override
    public String processText(ReceiveTextMessage text) {
        // 1. Check if the content is an instruction(Query db records, if the user id has a instruction record and the duration is less than 5min, the message is not an instruction)
        // 2. If it is an instruction, save into db, and build a text message to ask user to do the next step
        // 3. If it is not an instruction, process it according to the instruction
        return null;
    }

    @Override
    public String processVoice(ReceiveVoiceMessage voice) {
        return null;
    }

    @Override
    public String processVideo(ReceiveVideoMessage video) {
        return null;
    }

    @Override
    public String processPic(ReceivePicMessage picture) {
        return null;
    }

    @Override
    public String processLink(ReceiveLinkMessage link) {
        return null;
    }

    @Override
    public String processLocation(ReceiveLocationMessage location) {
        return null;
    }
}
