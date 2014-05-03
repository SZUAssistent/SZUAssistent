package org.wechatapps.dao;

import org.wechatapps.po.db.History;

import java.util.List;

/*
 * @Description User Event History DAO
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public interface HistoryDao {
    Integer save(History history);

    void delete(History history);

    void update(History history);

    List<History> findAll();

    History findById(Integer id);

    List<History> findByKey(String key);

    List<History> findByUserId(String userId);

    List<History> findNonTimeoutByUserId(String userId, long seconds);
}
