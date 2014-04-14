package org.wechatapps.po.menu;

/*
 * @Description Wechat Customized Menu Button with Type "click"
 * @author Charles Chen
 * @date 14-4-14
 * @version 1.0
 */
public class ActionButton extends Button {
    private String type = "click";
    private String key;

    public ActionButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
