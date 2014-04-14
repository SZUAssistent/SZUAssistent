package org.wechatapps.po.send;

import org.wechatapps.po.BaseMessage;

/*
 * @Description Picture Message for Sending
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class SendPicMessage extends BaseMessage {
    private Image Image;

    public enum AttributeEnum {
        ToUserName, FromUserName, CreateTime, MsgType, Image;
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
            case Image:
                setImage((Image) attributeValue);
                break;
            default:
                break;
        }
        return;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }
}
