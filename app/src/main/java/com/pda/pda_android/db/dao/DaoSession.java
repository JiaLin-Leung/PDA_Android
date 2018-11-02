package com.pda.pda_android.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.SsxxUserInfoBean;
import com.pda.pda_android.db.Entry.CheckBean;

import com.pda.pda_android.db.dao.UserBeanDao;
import com.pda.pda_android.db.dao.SsxxBeanDao;
import com.pda.pda_android.db.dao.SsxxUserInfoBeanDao;
import com.pda.pda_android.db.dao.CheckBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userBeanDaoConfig;
    private final DaoConfig ssxxBeanDaoConfig;
    private final DaoConfig ssxxUserInfoBeanDaoConfig;
    private final DaoConfig checkBeanDaoConfig;

    private final UserBeanDao userBeanDao;
    private final SsxxBeanDao ssxxBeanDao;
    private final SsxxUserInfoBeanDao ssxxUserInfoBeanDao;
    private final CheckBeanDao checkBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        ssxxBeanDaoConfig = daoConfigMap.get(SsxxBeanDao.class).clone();
        ssxxBeanDaoConfig.initIdentityScope(type);

        ssxxUserInfoBeanDaoConfig = daoConfigMap.get(SsxxUserInfoBeanDao.class).clone();
        ssxxUserInfoBeanDaoConfig.initIdentityScope(type);

        checkBeanDaoConfig = daoConfigMap.get(CheckBeanDao.class).clone();
        checkBeanDaoConfig.initIdentityScope(type);

        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);
        ssxxBeanDao = new SsxxBeanDao(ssxxBeanDaoConfig, this);
        ssxxUserInfoBeanDao = new SsxxUserInfoBeanDao(ssxxUserInfoBeanDaoConfig, this);
        checkBeanDao = new CheckBeanDao(checkBeanDaoConfig, this);

        registerDao(UserBean.class, userBeanDao);
        registerDao(SsxxBean.class, ssxxBeanDao);
        registerDao(SsxxUserInfoBean.class, ssxxUserInfoBeanDao);
        registerDao(CheckBean.class, checkBeanDao);
    }
    
    public void clear() {
        userBeanDaoConfig.clearIdentityScope();
        ssxxBeanDaoConfig.clearIdentityScope();
        ssxxUserInfoBeanDaoConfig.clearIdentityScope();
        checkBeanDaoConfig.clearIdentityScope();
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public SsxxBeanDao getSsxxBeanDao() {
        return ssxxBeanDao;
    }

    public SsxxUserInfoBeanDao getSsxxUserInfoBeanDao() {
        return ssxxUserInfoBeanDao;
    }

    public CheckBeanDao getCheckBeanDao() {
        return checkBeanDao;
    }

}
