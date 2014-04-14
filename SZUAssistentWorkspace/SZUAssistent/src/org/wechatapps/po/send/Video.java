package org.wechatapps.po.send;

/*
 * @Description Wechat Video Object
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class Video {
    private String MediaId;
    private String Title;
    private String Desciption;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesciption() {
        return Desciption;
    }

    public void setDesciption(String desciption) {
        Desciption = desciption;
    }
}
