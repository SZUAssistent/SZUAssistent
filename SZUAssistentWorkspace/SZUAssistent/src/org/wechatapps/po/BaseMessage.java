package org.wechatapps.po;

/*
 * @Description The wechat message base template
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class BaseMessage {
    protected String ToUserName;
    protected String FromUserName;
    protected String CreateTime;
    protected String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
