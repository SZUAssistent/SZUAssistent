package org.wechatapps.po.recieve;

import org.wechatapps.po.BaseMessage;

/*
 * @Description Received Location Message POJO
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class ReceiveLocationMessage extends BaseMessage {
    private String Location_X;
    private String Location_Y;
    private String Scale;
    private String Label;
    private String MsgId;

    public enum AttributeEnum {
        ToUserName, FromUserName, CreateTime, MsgType, Location_X, Location_Y, Scale, Label, MsgId;
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
            case Location_X:
                setLocation_X(String.valueOf(attributeValue));
                break;
            case Location_Y:
                setLocation_Y(String.valueOf(attributeValue));
                break;
            case Scale:
                setScale(String.valueOf(attributeValue));
            case Label:
                setLabel(String.valueOf(attributeValue));
            case MsgId:
                setMsgId(String.valueOf(attributeValue));
                break;
            default:
                break;
        }
        return;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
