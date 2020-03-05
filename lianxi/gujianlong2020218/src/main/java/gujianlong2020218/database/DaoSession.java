package gujianlong2020218.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bawei.gujianlong2020218.bean.JsonSqlite;

import gujianlong2020218.database.JsonSqliteDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig jsonSqliteDaoConfig;

    private final JsonSqliteDao jsonSqliteDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        jsonSqliteDaoConfig = daoConfigMap.get(JsonSqliteDao.class).clone();
        jsonSqliteDaoConfig.initIdentityScope(type);

        jsonSqliteDao = new JsonSqliteDao(jsonSqliteDaoConfig, this);

        registerDao(JsonSqlite.class, jsonSqliteDao);
    }
    
    public void clear() {
        jsonSqliteDaoConfig.clearIdentityScope();
    }

    public JsonSqliteDao getJsonSqliteDao() {
        return jsonSqliteDao;
    }

}
