package org.wechatapps.po.menu;

/*
 * @Description Wechat Customized Menu Button with Type "view"
 * @author Charles Chen
 * @date 14-4-14
 * @version 1.0
 */
public class ViewButton extends Button {
    private String type = "view";
    private String url;

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
