package org.wechatapps.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wechatapps.po.db.History;

import java.util.List;

/*
 * @Description User Event History DAO Implements
 * @author Charles Chen
 * @date 14-5-2
 * @version 1.0
 */
public class HistoryDaoImpl extends HibernateDaoSupport implements HistoryDao {
    /**
     * Save history entity into db
     *
     * @param history
     * @return
     */
    @Override
    public Integer save(History history) {
        return (Integer) getHibernateTemplate().save(history);
    }

    /**
     * Delete history entity from db
     *
     * @param history
     */
    @Override
    public void delete(History history) {
        getHibernateTemplate().delete(history);
    }

    /**
     * Update history record
     *
     * @param history
     */
    @Override
    public void update(History history) {
        getHibernateTemplate().update(history);
    }

    /**
     * Get all history records
     *
     * @return
     */
    @Override
    public List<History> findAll() {
        return getHibernateTemplate().find("from History order by history_time desc");
    }

    /**
     * Get history record by ID
     *
     * @param id
     * @return
     */
    @Override
    public History findById(Integer id) {
        return getHibernateTemplate().get(History.class, id);
    }

    /**
     * Get history records by event key
     *
     * @param key
     * @return
     */
    @Override
    public List<History> findByKey(String key) {
        return getHibernateTemplate().find("from History where history_event_key = '" + key + "' order by history_time desc");
    }

    /**
     * Get all history records by user ID
     *
     * @param userId
     * @return
     */
    @Override
    public List<History> findByUserId(String userId) {
        return getHibernateTemplate().find("from History where history_user_id = '" + userId + "' order by history_time desc");
    }

    /**
     * Find non-timeout history records by user id
     *
     * @param userId  User ID
     * @param seconds Timeout seconds
     * @return
     */
    @Override
    public List<History> findNonTimeoutByUserId(String userId, long seconds) {
        return getHibernateTemplate().find("from History where history_user_id = '" + userId + "' and (UNIX_TIMESTAMP(NOW())-UNIX_TIMESTAMP(history_time)) <= 300 order by history_time desc");
    }
}
