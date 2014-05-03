package org.wechatapps.factory;

import org.wechatapps.annotation.EventComponent;
import org.wechatapps.executors.EventExecutor;

import java.util.*;

/*
 * @Description Client Event Executor Factory
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public class ExecutorFactory {
    private Map<String, EventEntity> entities;  // Event entities map

    /**
     * Constructor
     */
    public ExecutorFactory(String targetPackageName) {
        entities = new HashMap<String, EventEntity>();
        getAllEventExecutors(targetPackageName);
    }

    /**
     * Get all event executors and add into entities map
     */
    private void getAllEventExecutors(String targetPackageName) {
        Set<Class<?>> executorClassSet = ClassUtil.getClasses(targetPackageName);
        for (Class c : executorClassSet) {
            EventComponent ann = (EventComponent) c.getAnnotation(EventComponent.class); // Get event component annotation
            if (ann == null) {
                // If annotation is not found, ignore this class
                continue;
            }
            // If annotation is found, build an event entity and add into entities map
            String key = ann.key();
            int type = ann.type();
            try {
                EventEntity entity = new EventEntity(key, type, (EventExecutor) c.newInstance());
                entities.put(key, entity);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Find event entity by the event key
     *
     * @param key
     * @return
     */
    public EventEntity findByKey(String key) {
        return entities.get(key);
    }


    /**
     * Check if the text is a event key
     *
     * @param text
     * @return
     */
    public boolean isEventKey(String text) {
        return entities.containsKey(text);
    }

}
