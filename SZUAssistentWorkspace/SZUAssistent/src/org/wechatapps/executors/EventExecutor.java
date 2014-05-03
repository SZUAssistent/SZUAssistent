package org.wechatapps.executors;

import org.wechatapps.po.BaseMessage;

/**
 * Created by chaoch on 14-5-2.
 */

/*
 * @Description Client Event Executor Interface
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public interface EventExecutor {
    String execute(BaseMessage message);

    String desc(BaseMessage message);
}
