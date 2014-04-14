package org.wechatapps.po.menu;

/*
 * @Description Wechat Customized Menu
 * @author Charles Chen
 * @date 14-4-14
 * @version 1.0
 */
public class Menu {
    Button[] button;

    public Menu(Button[] button) {
        this.button = button;
    }

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }
}
