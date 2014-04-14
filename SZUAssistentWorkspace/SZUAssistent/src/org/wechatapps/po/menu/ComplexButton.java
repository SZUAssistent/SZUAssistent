package org.wechatapps.po.menu;

/*
 * @Description Wechat Cutomized Menu Button with Sub-button List
 * @author Charles Chen
 * @date 14-4-14
 * @version 1.0
 */
public class ComplexButton extends Button {
    private Button[] sub_button;

    public ComplexButton(String name, Button[] sub_button) {
        super(name);
        this.sub_button = sub_button;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
