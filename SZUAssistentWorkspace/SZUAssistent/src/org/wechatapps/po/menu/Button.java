package org.wechatapps.po.menu;

/*
 * @Description Wehcat Customized Menu Button
 * @author Charles Chen
 * @date 14-4-14
 * @version 1.0
 */
public class Button {
    private String name;    // Button displayed name

    public Button(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
