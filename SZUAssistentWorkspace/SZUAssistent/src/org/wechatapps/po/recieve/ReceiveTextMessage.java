package org.wechatapps.po.recieve;

import org.wechatapps.po.BaseMessage;

/*
 * @Description Received text message POJO
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class ReceiveTextMessage extends BaseMessage {
    private String Content;
    private String MsgId;


    public enum AttributeEnum {
        ToUserName, FromUserName, CreateTime, MsgType, Content, MsgId;
        public int firstIndex = 0;

        public int index() {
            return firstIndex + ordinal();
        }
    }

    /**
     * Attribute setter
     *
     * @param attributeName
     * @param attributeValue
     */
    public void setAttribute(String attributeName, Object attributeValue) {
        AttributeEnum attribute = AttributeEnum.valueOf(attributeName);
        switch (attribute) {
            case ToUserName:
                setToUserName(String.valueOf(attributeValue));
                break;
            case FromUserName:
                setFromUserName(String.valueOf(attributeValue));
                break;
            case CreateTime:
                setCreateTime(String.valueOf(attributeValue));
                break;
            case MsgType:
                setMsgType(String.valueOf(attributeValue));
                break;
            case Content:
                setContent(String.valueOf(attributeValue));
                break;
            case MsgId:
                setMsgId(String.valueOf(attributeValue));
                break;
            default:
                break;
        }
        return;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
