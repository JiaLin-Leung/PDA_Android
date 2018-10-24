package com.pda.pda_android.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pda.pda_android.db.bean.Phrase;
import com.pda.pda_android.db.bean.User;
import com.pda.pda_android.db.entry.PhraseEntry;
import com.pda.pda_android.db.entry.UserEntry;

import java.util.Arrays;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/24 09:43
 * 功能：回调函数
 */
public class MyCallBack implements SQLiteDao.ICallBack {

    public static final String TABLE_NAME_PHRASE = "phrase";
    public static final String TABLE_NAME_FAVORITE = "favorite";
    public static final String TABLE_USER = "user";

    private static final String DATABASE_NAME = "ceshi.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TYPE_TEXT = " TEXT";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String SEP_COMMA = ",";

    /**
     * 创建数据表
     */
    private static final String TABLE_SCHEMA_PHRASE =
            "CREATE TABLE " + TABLE_NAME_PHRASE + " (" +
                    PhraseEntry._ID + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                    PhraseEntry.COLEUM_NAME_ID + TYPE_TEXT + SEP_COMMA +
                    PhraseEntry.COLEUM_NAME_CONTENT + TYPE_TEXT + SEP_COMMA +
                    PhraseEntry.COLEUM_NAME_FAVORITE + TYPE_INTEGER +
                    ")";
    private static final String TABLE_SCHEMA_FAVORITE =
            "CREATE TABLE " + TABLE_NAME_FAVORITE + " (" +
                    PhraseEntry._ID + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                    PhraseEntry.COLEUM_NAME_ID + TYPE_TEXT + SEP_COMMA +
                    PhraseEntry.COLEUM_NAME_CONTENT + TYPE_TEXT + SEP_COMMA +
                    PhraseEntry.COLEUM_NAME_FAVORITE + TYPE_INTEGER +
                    ")";

    private static final String TABLE_USER_INIT =
            "CREATE TABLE " + TABLE_USER + " (" +
                    UserEntry._ID + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " +
                    UserEntry.USER_NAME + TYPE_TEXT + SEP_COMMA +
                    UserEntry.USER_PASSWORD + TYPE_TEXT +
                    ")";

    public MyCallBack() {
    }

    @Override
    public List<String> createTablesSQL() {
        return Arrays.asList(
                TABLE_SCHEMA_PHRASE,
                TABLE_SCHEMA_FAVORITE,
                TABLE_USER_INIT
            );
    }

    @Override
    /**
     * 获取数据库名称
     */
    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    /**
     * 获取版本号
     */
    public int getVersion() {
        return DATABASE_VERSION;
    }

    @Override
    /**
     * 升级数据库操作
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        switch (oldVersion) {
            case 0:
                db.execSQL(TABLE_SCHEMA_FAVORITE); // 升级操作；
                break;
            case 1:
                break;
            default:
                break;
        }
    }


    @Override
    /**
     * 统一操作添加参数，记得新建表之后需要在这里增加一条记录
     * 不然插入数据无效！
     */
    public <T> void assignValuesByEntity(String tableName, T t, ContentValues values) {

        switch (tableName) {
            case TABLE_NAME_PHRASE:
                if (t instanceof Phrase) {
                    Phrase phrase = (Phrase) t;
                    values.put(PhraseEntry.COLEUM_NAME_ID, phrase.getId());
                    values.put(PhraseEntry.COLEUM_NAME_CONTENT, phrase.getContent());
                    values.put(PhraseEntry.COLEUM_NAME_FAVORITE, phrase.getFavorite());
                }
                break;
            case TABLE_NAME_FAVORITE:
                if (t instanceof Phrase) {
                    Phrase phrase = (Phrase) t;
                    values.put(PhraseEntry.COLEUM_NAME_ID, phrase.getId());
                    values.put(PhraseEntry.COLEUM_NAME_CONTENT, phrase.getContent());
                    values.put(PhraseEntry.COLEUM_NAME_FAVORITE, phrase.getFavorite());
                }
                break;
            case TABLE_USER:
                if(t instanceof User){
                    User user = (User) t;
                    values.put(UserEntry.USER_NAME,user.getUsername());
                    values.put(UserEntry.USER_PASSWORD,user.getPassword());
                }
                break;
        }
    }

    @Override
    public Object newEntityByCursor(String tableName, Cursor cursor) {
        switch (tableName) {
            case TABLE_NAME_PHRASE:
                return new Phrase(
                        cursor.getString(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_ID)),
                        cursor.getString(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_CONTENT)),
                        cursor.getInt(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_FAVORITE))
                );
            case TABLE_NAME_FAVORITE:
                return new Phrase(
                        cursor.getString(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_ID)),
                        cursor.getString(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_CONTENT)),
                        cursor.getInt(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_FAVORITE))
                );
            case TABLE_USER:
                return new User(
                        cursor.getString(cursor.getColumnIndex(UserEntry.USER_PASSWORD)),
                        cursor.getString(cursor.getColumnIndex(UserEntry.USER_NAME))
                );
        }

        return null;
    }


}
