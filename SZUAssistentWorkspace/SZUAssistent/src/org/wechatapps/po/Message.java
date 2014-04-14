package org.wechatapps.po;

/*
 * @Description Wechat Message
 * @author Charles Chen
 * @date 14-2-19
 * @version 1.0
 */
public class Message {
    private String type;
    private Object mess;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getMess() {
        return mess;
    }

    public void setMess(Object mess) {
        this.mess = mess;
    }
}
