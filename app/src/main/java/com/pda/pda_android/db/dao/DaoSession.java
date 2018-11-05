package com.pda.pda_android.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.Entry.AssayBean;
import com.pda.pda_android.db.Entry.AssayDetailBeanBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.CheckBean;

import com.pda.pda_android.db.dao.UserBeanDao;
import com.pda.pda_android.db.dao.AssayBeanDao;
import com.pda.pda_android.db.dao.AssayDetailBeanBeanDao;
import com.pda.pda_android.db.dao.SsxxBeanDao;
import com.pda.pda_android.db.dao.CheckBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userBeanDaoConfig;
    private final DaoConfig assayBeanDaoConfig;
    private final DaoConfig assayDetailBeanBeanDaoConfig;
    private final DaoConfig ssxxBeanDaoConfig;
    private final DaoConfig checkBeanDaoConfig;

    private final UserBeanDao userBeanDao;
    private final AssayBeanDao assayBeanDao;
    private final AssayDetailBeanBeanDao assayDetailBeanBeanDao;
    private final SsxxBeanDao ssxxBeanDao;
    private final CheckBeanDao checkBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        assayBeanDaoConfig = daoConfigMap.get(AssayBeanDao.class).clone();
        assayBeanDaoConfig.initIdentityScope(type);

        assayDetailBeanBeanDaoConfig = daoConfigMap.get(AssayDetailBeanBeanDao.class).clone();
        assayDetailBeanBeanDaoConfig.initIdentityScope(type);

        ssxxBeanDaoConfig = daoConfigMap.get(SsxxBeanDao.class).clone();
        ssxxBeanDaoConfig.initIdentityScope(type);

        checkBeanDaoConfig = daoConfigMap.get(CheckBeanDao.class).clone();
        checkBeanDaoConfig.initIdentityScope(type);

        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);
        assayBeanDao = new AssayBeanDao(assayBeanDaoConfig, this);
        assayDetailBeanBeanDao = new AssayDetailBeanBeanDao(assayDetailBeanBeanDaoConfig, this);
        ssxxBeanDao = new SsxxBeanDao(ssxxBeanDaoConfig, this);
        checkBeanDao = new CheckBeanDao(checkBeanDaoConfig, this);

        registerDao(UserBean.class, userBeanDao);
        registerDao(AssayBean.class, assayBeanDao);
        registerDao(AssayDetailBeanBean.class, assayDetailBeanBeanDao);
        registerDao(SsxxBean.class, ssxxBeanDao);
        registerDao(CheckBean.class, checkBeanDao);
    }
    
    public void clear() {
        userBeanDaoConfig.clearIdentityScope();
        assayBeanDaoConfig.clearIdentityScope();
        assayDetailBeanBeanDaoConfig.clearIdentityScope();
        ssxxBeanDaoConfig.clearIdentityScope();
        checkBeanDaoConfig.clearIdentityScope();
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public AssayBeanDao getAssayBeanDao() {
        return assayBeanDao;
    }

    public AssayDetailBeanBeanDao getAssayDetailBeanBeanDao() {
        return assayDetailBeanBeanDao;
    }

    public SsxxBeanDao getSsxxBeanDao() {
        return ssxxBeanDao;
    }

    public CheckBeanDao getCheckBeanDao() {
        return checkBeanDao;
    }

}
