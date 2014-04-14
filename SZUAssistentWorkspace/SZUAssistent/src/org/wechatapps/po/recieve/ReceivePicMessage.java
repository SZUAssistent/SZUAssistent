package org.wechatapps.po.recieve;

import org.wechatapps.po.BaseMessage;

/*
 * @Description Received picture message POJO
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class ReceivePicMessage extends BaseMessage {
    private String PicUrl;
    private String MediaId;
    private String MsgId;

    public enum AttributeEnum {
        ToUserName, FromUserName, CreateTime, MsgType, PicUrl, MediaId, MsgId;
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
            case PicUrl:
                setPicUrl(String.valueOf(attributeValue));
                break;
            case MediaId:
                setMediaId(String.valueOf(attributeValue));
                break;
            case MsgId:
                setMsgId(String.valueOf(attributeValue));
                break;
            default:
                break;
        }
        return;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
