package org.wechatapps.factory;

import org.wechatapps.executors.EventExecutor;

/*
 * @Description Client Event Entity
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public class EventEntity {
    private String key; // Event key
    private int type;   // Event type. 1: Respond immediately, 2: History event
    private EventExecutor executor;

    /**
     * Constructor
     *
     * @param key
     * @param type
     * @param executor
     */
    public EventEntity(String key, int type, EventExecutor executor) {
        this.key = key;
        this.type = type;
        this.executor = executor;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public EventExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(EventExecutor executor) {
        this.executor = executor;
    }
}
