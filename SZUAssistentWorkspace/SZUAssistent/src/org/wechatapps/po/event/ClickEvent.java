package org.wechatapps.po.event;

import org.wechatapps.po.BaseMessage;

/*
 * @Description Customized Menu Click Event
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public class ClickEvent extends BaseMessage {
    private String EventKey;    // The button event key

    public enum AttributeEnum {
        ToUserName, FromUserName, CreateTime, MsgType, EventKey;
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
            case EventKey:
                setEventKey(String.valueOf(attributeValue));
                break;
            default:
                break;
        }
        return;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
