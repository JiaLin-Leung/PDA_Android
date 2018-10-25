package com.pda.pda_android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pda.pda_android.base.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 梁佳霖创建于：2018/10/24 09:40
 * 功能：数据库工具类
 */
public final class SQLiteDao extends SQLiteOpenHelper {

    private static final String TAG = "LouSQLite";
    private static SQLiteDao INSTANCE;
    private final ICallBack callBack;

    /**
     * 构造函数
     * @param context 上下文
     * @param callBack 回调函数
     */
    private SQLiteDao(Context context, ICallBack callBack) {
        super(context, callBack.getDatabaseName(), null, callBack.getVersion());
        this.callBack = callBack;
    }

    public static void init(@NonNull Context context, @NonNull ICallBack callBack) {
        INSTANCE = new SQLiteDao(context, callBack);
    }


    /**
     * 插入单个数据方法
     * @param tableName 表明
     * @param entity 插入参数
     * @param <T> 插入参数类型（泛型）
     */
    public static <T> void insert(String tableName, T entity) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            INSTANCE.callBack.assignValuesByEntity(tableName, entity, values);
            db.insert(tableName, null, values);
            values.clear();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    /**
     * 插入一组数据
     * @param tableName 表明
     * @param entities 参数（list类型）
     * @param <T> 参数类型（泛型）
     */
    public static <T> void insert(String tableName, List<T> entities) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (T entity : entities) {
                INSTANCE.callBack.assignValuesByEntity(tableName, entity, values);
                db.insert(tableName, null, values);
                values.clear();
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    /**
     * 更新数据
     * @param tableName 表明
     * @param entity 即将更新的参数
     * @param whereClause 字段名
     * @param whereArgs 字段对应的参数值
     * @param <T> 返回数据泛型
     */
    public static <T> void update(String tableName, T entity, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            INSTANCE.callBack.assignValuesByEntity(tableName, entity, values);
            db.update(tableName, values, whereClause, whereArgs);
            values.clear();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    /**
     * 查询一组数据
     * @param tableName 表名
     * @param queryStr 查找的字段
     * @param whereArgs 查询条件
     * @param <T> 返回数据泛型
     * @return
     */
    public static <T> List<T> query(String tableName, @NonNull String queryStr, @Nullable String[] whereArgs) {
        SQLiteDatabase db = INSTANCE.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryStr, whereArgs);
        try {
            List<T> lists = new ArrayList<>(cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    T entity = INSTANCE.callBack.newEntityByCursor(tableName, cursor);
                    if (entity != null) {
                        lists.add(entity);
                    }
                } while (cursor.moveToNext());
            }
            return lists;
        } finally {
            cursor.close();
            db.close();
        }

    }

    /**
     * 清空表中数据
     * @param tableName 表名
     */
    public static void deleteFrom(String tableName) {

        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            String sql = "DELETE FROM " + tableName;
            db.execSQL(sql);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    // delete的适用场合是涉及到删除的对象数量较少时。
    // 当删除多条数据时（例如：500条），通过循环的方式来一个一个的删除需要12s，而使用execSQL语句结合(delete from table id in("1", "2", "3"))的方式只需要50ms
    /**
     * 按条件删除数据
     * @param tableName 表名
     * @param whereClause  条件
     * @param whereArgs 条件
     */
    public static void delete(String tableName, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(tableName, whereClause, whereArgs);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    /*
     * 当操作数据较多时，直接使用sql语句或许效率更高
     *
     * 执行sql语句（例如: String sql = "delete from tableName where mac in ('24:71:89:0A:DD:82', '24:71:89:0A:DD:83','24:71:89:0A:DD:84')"）
     * 注意：db.execSQL文档中有说明"the SQL statement to be executed. Multiple statements separated by semicolons are not supported."，
     * 也就是说通过分号分割的多个statement操作是不支持的。
     *
     */

    /**
     * 执行SQL语句
     * @param sql SQL语句
     */
    public static void execSQL(String sql) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            db.execSQL(sql);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        List<String> tablesSQL = callBack.createTablesSQL();
        for (String create_table : tablesSQL) {
            db.execSQL(create_table);
            LogUtils.showLog(TAG, "create table " + "[ \n" + create_table + "\n ]" + " successful! ");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        callBack.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    /**
     * 抽象方法，用于实现对象自己实现，创建表等等操作
     */
    public interface ICallBack {
        String getDatabaseName();

        int getVersion();

        void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

        List<String> createTablesSQL();

        <T> void assignValuesByEntity(String tableName, T entity, ContentValues values);

        <T> T newEntityByCursor(String tableName, Cursor cursor);
    }
}