package org.wechatapps.bean;

import org.wechatapps.dao.HistoryDao;
import org.wechatapps.factory.EventEntity;
import org.wechatapps.factory.ExecutorFactory;
import org.wechatapps.po.Message;
import org.wechatapps.po.db.History;
import org.wechatapps.po.event.ClickEvent;
import org.wechatapps.po.recieve.*;
import org.wechatapps.utils.WechatUtils;

import java.util.List;

/*
 * @Description Wechar Message Proccessor
 * @author Charles Chen
 * @date 14-2-19
 * @version 1.0
 */
public class WechatProcessorImpl implements WechatProcessor {
    private HistoryDao historyDao;
    private ExecutorFactory executorFactory;

    public void setHistoryDao(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    public void setFactory(ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
    }

    /**
     * Process message according to the type
     *
     * @param message
     * @return
     */
    public String process(Message message) {
        String type = message.getType();
        if (type == null) {
            return null;
        }
        if (message.getMess() == null) {
            return null;
        }
        String processedResult;
        switch (WechatUtils.MESS_TYPE.valueOf(type.toUpperCase())) {
            case TEXT:
                processedResult = processText((ReceiveTextMessage) message.getMess());
                break;
            case IMAGE:
                processedResult = processPic((ReceivePicMessage) message.getMess());
                break;
            case VOICE:
                processedResult = processVoice((ReceiveVoiceMessage) message.getMess());
                break;
            case VIDEO:
                processedResult = processVideo((ReceiveVideoMessage) message.getMess());
                break;
            case LOCATION:
                processedResult = processLocation((ReceiveLocationMessage) message.getMess());
                break;
            case LINK:
                processedResult = processLink((ReceiveLinkMessage) message.getMess());
                break;
            case EVENT:
                processedResult = processClickEvent((ClickEvent) message.getMess());
                break;
            default:
                processedResult = null;
                break;
        }
        return processedResult;
    }

    /**
     * Process text message
     *
     * @param text
     * @return
     */
    @Override
    public String processText(ReceiveTextMessage text) {
        /* Start: Check if the text content is a command */
        EventEntity entity = executorFactory.findByKey(text.getContent());
        // If the message is a event command
        if (entity != null) {
            if (entity.getType() == 1) {
                // If type is 1, execute the event action immediately
                return entity.getExecutor().execute(text);
            }
            if (entity.getType() == 2) {
                // If type is 2, save the event as history
                History history = new History();
                history.setHistoryUserId(text.getFromUserName());
                history.setHistoryEventKey(text.getContent());
                historyDao.save(history);

                // Respond the description of the event to client
                return entity.getExecutor().desc(text);
            }
        }
        /* End: Check if the text content is a command */

        /* Start: If text content is not a command, check if current user has a previous history command */
        List<History> nonTimeoutHistories = historyDao.findNonTimeoutByUserId(text.getFromUserName(), 300); // Get user event histories in 300 seconds
        if (nonTimeoutHistories != null && nonTimeoutHistories.size() > 0) {
            // Get the event entity by event key
            entity = executorFactory.findByKey(nonTimeoutHistories.get(0).getHistoryEventKey());
            if (entity == null) return null;
            return entity.getExecutor().execute(text);
        }
        /* End: If text content is not a command, check if current user has a previous history command */

        return null;
    }

    /**
     * Process click event
     *
     * @param event
     * @return
     */
    @Override
    public String processClickEvent(ClickEvent event) {
        EventEntity entity = executorFactory.findByKey(event.getEventKey());
        // If event key is found
        if (entity != null) {
            if (entity.getType() == 1) {
                // If type is 1, execute the event action immediately
                return entity.getExecutor().execute(event);
            }
            if (entity.getType() == 2) {
                // If type is 2, save the event as history
                History history = new History();
                history.setHistoryUserId(event.getFromUserName());
                history.setHistoryEventKey(event.getEventKey());
                historyDao.save(history);

                // Respond the description of the event to client
                return entity.getExecutor().desc(event);
            }
        }
        return null;
    }


    @Override
    public String processVoice(ReceiveVoiceMessage voice) {
        return null;
    }

    @Override
    public String processVideo(ReceiveVideoMessage video) {
        return null;
    }

    @Override
    public String processPic(ReceivePicMessage picture) {
        return null;
    }

    @Override
    public String processLink(ReceiveLinkMessage link) {
        return null;
    }

    @Override
    public String processLocation(ReceiveLocationMessage location) {
        return null;
    }
}
