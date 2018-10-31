package com.pda.pda_android.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pda.pda_android.db.Entry.UserBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_BEAN".
*/
public class UserBeanDao extends AbstractDao<UserBean, Long> {

    public static final String TABLENAME = "USER_BEAN";

    /**
     * Properties of entity UserBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Record_no = new Property(1, String.class, "record_no", false, "RECORD_NO");
        public final static Property Patient_no = new Property(2, String.class, "patient_no", false, "PATIENT_NO");
        public final static Property Patient_name = new Property(3, String.class, "patient_name", false, "PATIENT_NAME");
        public final static Property Bed_no = new Property(4, String.class, "bed_no", false, "BED_NO");
        public final static Property Sex = new Property(5, String.class, "sex", false, "SEX");
        public final static Property Tend = new Property(6, String.class, "tend", false, "TEND");
        public final static Property Age = new Property(7, String.class, "age", false, "AGE");
    }


    public UserBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UserBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"RECORD_NO\" TEXT," + // 1: record_no
                "\"PATIENT_NO\" TEXT," + // 2: patient_no
                "\"PATIENT_NAME\" TEXT," + // 3: patient_name
                "\"BED_NO\" TEXT," + // 4: bed_no
                "\"SEX\" TEXT," + // 5: sex
                "\"TEND\" TEXT," + // 6: tend
                "\"AGE\" TEXT);"); // 7: age
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String record_no = entity.getRecord_no();
        if (record_no != null) {
            stmt.bindString(2, record_no);
        }
 
        String patient_no = entity.getPatient_no();
        if (patient_no != null) {
            stmt.bindString(3, patient_no);
        }
 
        String patient_name = entity.getPatient_name();
        if (patient_name != null) {
            stmt.bindString(4, patient_name);
        }
 
        String bed_no = entity.getBed_no();
        if (bed_no != null) {
            stmt.bindString(5, bed_no);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(6, sex);
        }
 
        String tend = entity.getTend();
        if (tend != null) {
            stmt.bindString(7, tend);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(8, age);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String record_no = entity.getRecord_no();
        if (record_no != null) {
            stmt.bindString(2, record_no);
        }
 
        String patient_no = entity.getPatient_no();
        if (patient_no != null) {
            stmt.bindString(3, patient_no);
        }
 
        String patient_name = entity.getPatient_name();
        if (patient_name != null) {
            stmt.bindString(4, patient_name);
        }
 
        String bed_no = entity.getBed_no();
        if (bed_no != null) {
            stmt.bindString(5, bed_no);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(6, sex);
        }
 
        String tend = entity.getTend();
        if (tend != null) {
            stmt.bindString(7, tend);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(8, age);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UserBean readEntity(Cursor cursor, int offset) {
        UserBean entity = new UserBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // record_no
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // patient_no
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // patient_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // bed_no
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // sex
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // tend
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // age
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setRecord_no(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPatient_no(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPatient_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBed_no(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSex(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTend(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setAge(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}