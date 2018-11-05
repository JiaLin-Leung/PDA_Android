package com.pda.pda_android.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pda.pda_android.db.Entry.AssayDetailBeanBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ASSAY_DETAIL_BEAN_BEAN".
*/
public class AssayDetailBeanBeanDao extends AbstractDao<AssayDetailBeanBean, Long> {

    public static final String TABLENAME = "ASSAY_DETAIL_BEAN_BEAN";

    /**
     * Properties of entity AssayDetailBeanBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Patient_no = new Property(1, String.class, "patient_no", false, "PATIENT_NO");
        public final static Property Xmmc = new Property(2, String.class, "xmmc", false, "XMMC");
        public final static Property Itemno = new Property(3, String.class, "itemno", false, "ITEMNO");
        public final static Property Itemname = new Property(4, String.class, "itemname", false, "ITEMNAME");
        public final static Property Jg = new Property(5, String.class, "jg", false, "JG");
        public final static Property Jg1 = new Property(6, String.class, "jg1", false, "JG1");
        public final static Property Jg2 = new Property(7, String.class, "jg2", false, "JG2");
        public final static Property Jgflag = new Property(8, String.class, "jgflag", false, "JGFLAG");
        public final static Property Unit = new Property(9, String.class, "unit", false, "UNIT");
        public final static Property Ranges = new Property(10, String.class, "ranges", false, "RANGES");
        public final static Property Sqdate = new Property(11, String.class, "sqdate", false, "SQDATE");
        public final static Property Jydate = new Property(12, String.class, "jydate", false, "JYDATE");
        public final static Property Bgdate = new Property(13, String.class, "bgdate", false, "BGDATE");
        public final static Property Jcys_name = new Property(14, String.class, "jcys_name", false, "JCYS_NAME");
        public final static Property Jcys_code = new Property(15, String.class, "jcys_code", false, "JCYS_CODE");
        public final static Property Bgys_code = new Property(16, String.class, "bgys_code", false, "BGYS_CODE");
        public final static Property Bgys_name = new Property(17, String.class, "bgys_name", false, "BGYS_NAME");
        public final static Property Sqxh = new Property(18, String.class, "sqxh", false, "SQXH");
    }


    public AssayDetailBeanBeanDao(DaoConfig config) {
        super(config);
    }
    
    public AssayDetailBeanBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ASSAY_DETAIL_BEAN_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PATIENT_NO\" TEXT," + // 1: patient_no
                "\"XMMC\" TEXT," + // 2: xmmc
                "\"ITEMNO\" TEXT," + // 3: itemno
                "\"ITEMNAME\" TEXT," + // 4: itemname
                "\"JG\" TEXT," + // 5: jg
                "\"JG1\" TEXT," + // 6: jg1
                "\"JG2\" TEXT," + // 7: jg2
                "\"JGFLAG\" TEXT," + // 8: jgflag
                "\"UNIT\" TEXT," + // 9: unit
                "\"RANGES\" TEXT," + // 10: ranges
                "\"SQDATE\" TEXT," + // 11: sqdate
                "\"JYDATE\" TEXT," + // 12: jydate
                "\"BGDATE\" TEXT," + // 13: bgdate
                "\"JCYS_NAME\" TEXT," + // 14: jcys_name
                "\"JCYS_CODE\" TEXT," + // 15: jcys_code
                "\"BGYS_CODE\" TEXT," + // 16: bgys_code
                "\"BGYS_NAME\" TEXT," + // 17: bgys_name
                "\"SQXH\" TEXT);"); // 18: sqxh
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ASSAY_DETAIL_BEAN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AssayDetailBeanBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String patient_no = entity.getPatient_no();
        if (patient_no != null) {
            stmt.bindString(2, patient_no);
        }
 
        String xmmc = entity.getXmmc();
        if (xmmc != null) {
            stmt.bindString(3, xmmc);
        }
 
        String itemno = entity.getItemno();
        if (itemno != null) {
            stmt.bindString(4, itemno);
        }
 
        String itemname = entity.getItemname();
        if (itemname != null) {
            stmt.bindString(5, itemname);
        }
 
        String jg = entity.getJg();
        if (jg != null) {
            stmt.bindString(6, jg);
        }
 
        String jg1 = entity.getJg1();
        if (jg1 != null) {
            stmt.bindString(7, jg1);
        }
 
        String jg2 = entity.getJg2();
        if (jg2 != null) {
            stmt.bindString(8, jg2);
        }
 
        String jgflag = entity.getJgflag();
        if (jgflag != null) {
            stmt.bindString(9, jgflag);
        }
 
        String unit = entity.getUnit();
        if (unit != null) {
            stmt.bindString(10, unit);
        }
 
        String ranges = entity.getRanges();
        if (ranges != null) {
            stmt.bindString(11, ranges);
        }
 
        String sqdate = entity.getSqdate();
        if (sqdate != null) {
            stmt.bindString(12, sqdate);
        }
 
        String jydate = entity.getJydate();
        if (jydate != null) {
            stmt.bindString(13, jydate);
        }
 
        String bgdate = entity.getBgdate();
        if (bgdate != null) {
            stmt.bindString(14, bgdate);
        }
 
        String jcys_name = entity.getJcys_name();
        if (jcys_name != null) {
            stmt.bindString(15, jcys_name);
        }
 
        String jcys_code = entity.getJcys_code();
        if (jcys_code != null) {
            stmt.bindString(16, jcys_code);
        }
 
        String bgys_code = entity.getBgys_code();
        if (bgys_code != null) {
            stmt.bindString(17, bgys_code);
        }
 
        String bgys_name = entity.getBgys_name();
        if (bgys_name != null) {
            stmt.bindString(18, bgys_name);
        }
 
        String sqxh = entity.getSqxh();
        if (sqxh != null) {
            stmt.bindString(19, sqxh);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AssayDetailBeanBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String patient_no = entity.getPatient_no();
        if (patient_no != null) {
            stmt.bindString(2, patient_no);
        }
 
        String xmmc = entity.getXmmc();
        if (xmmc != null) {
            stmt.bindString(3, xmmc);
        }
 
        String itemno = entity.getItemno();
        if (itemno != null) {
            stmt.bindString(4, itemno);
        }
 
        String itemname = entity.getItemname();
        if (itemname != null) {
            stmt.bindString(5, itemname);
        }
 
        String jg = entity.getJg();
        if (jg != null) {
            stmt.bindString(6, jg);
        }
 
        String jg1 = entity.getJg1();
        if (jg1 != null) {
            stmt.bindString(7, jg1);
        }
 
        String jg2 = entity.getJg2();
        if (jg2 != null) {
            stmt.bindString(8, jg2);
        }
 
        String jgflag = entity.getJgflag();
        if (jgflag != null) {
            stmt.bindString(9, jgflag);
        }
 
        String unit = entity.getUnit();
        if (unit != null) {
            stmt.bindString(10, unit);
        }
 
        String ranges = entity.getRanges();
        if (ranges != null) {
            stmt.bindString(11, ranges);
        }
 
        String sqdate = entity.getSqdate();
        if (sqdate != null) {
            stmt.bindString(12, sqdate);
        }
 
        String jydate = entity.getJydate();
        if (jydate != null) {
            stmt.bindString(13, jydate);
        }
 
        String bgdate = entity.getBgdate();
        if (bgdate != null) {
            stmt.bindString(14, bgdate);
        }
 
        String jcys_name = entity.getJcys_name();
        if (jcys_name != null) {
            stmt.bindString(15, jcys_name);
        }
 
        String jcys_code = entity.getJcys_code();
        if (jcys_code != null) {
            stmt.bindString(16, jcys_code);
        }
 
        String bgys_code = entity.getBgys_code();
        if (bgys_code != null) {
            stmt.bindString(17, bgys_code);
        }
 
        String bgys_name = entity.getBgys_name();
        if (bgys_name != null) {
            stmt.bindString(18, bgys_name);
        }
 
        String sqxh = entity.getSqxh();
        if (sqxh != null) {
            stmt.bindString(19, sqxh);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AssayDetailBeanBean readEntity(Cursor cursor, int offset) {
        AssayDetailBeanBean entity = new AssayDetailBeanBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // patient_no
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // xmmc
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // itemno
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // itemname
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // jg
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // jg1
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // jg2
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // jgflag
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // unit
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // ranges
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // sqdate
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // jydate
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // bgdate
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // jcys_name
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // jcys_code
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // bgys_code
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // bgys_name
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18) // sqxh
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AssayDetailBeanBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPatient_no(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setXmmc(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setItemno(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setItemname(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setJg(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setJg1(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setJg2(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setJgflag(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setUnit(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRanges(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setSqdate(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setJydate(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setBgdate(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setJcys_name(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setJcys_code(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setBgys_code(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setBgys_name(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setSqxh(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AssayDetailBeanBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AssayDetailBeanBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AssayDetailBeanBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
