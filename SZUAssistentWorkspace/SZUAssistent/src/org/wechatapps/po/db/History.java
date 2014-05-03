package org.wechatapps.po.db;

/*
 * @Description User Event History
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public class History {
    private Integer historyId;
    private String historyUserId;
    private String historyEventKey;
    private String historyTime;

    public String getHistoryTime() {
        return historyTime;
    }

    public void setHistoryTime(String historyTime) {
        this.historyTime = historyTime;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getHistoryUserId() {
        return historyUserId;
    }

    public void setHistoryUserId(String historyUserId) {
        this.historyUserId = historyUserId;
    }

    public String getHistoryEventKey() {
        return historyEventKey;
    }

    public void setHistoryEventKey(String historyEventKey) {
        this.historyEventKey = historyEventKey;
    }
}
