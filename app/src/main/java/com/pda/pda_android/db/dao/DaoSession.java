package com.pda.pda_android.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.pda.pda_android.bean.UserBean;

import com.pda.pda_android.db.dao.UserBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userBeanDaoConfig;

    private final UserBeanDao userBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);

        registerDao(UserBean.class, userBeanDao);
    }
    
    public void clear() {
        userBeanDaoConfig.clearIdentityScope();
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

}
