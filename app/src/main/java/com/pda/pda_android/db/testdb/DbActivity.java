package com.pda.pda_android.db.testdb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.db.SQLiteDao;
import com.pda.pda_android.db.MyCallBack;
import com.pda.pda_android.db.bean.Phrase;
import com.pda.pda_android.db.bean.User;
import com.pda.pda_android.db.bean.Users;
import com.pda.pda_android.db.entry.UserEntry;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/24 10:13
 * 功能：测试数据库工具类型
 */
public class DbActivity extends Activity {

    private ListView listview;
    private List<User>users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        listview = findViewById(R.id.listview);
    }

    public static void getDbInstance(Context context){
        Intent intent = new Intent(context,DbActivity.class);
        context.startActivity(intent);
    }

    private void initData() {
        SQLiteDao.init(DbActivity.this,new MyCallBack());//首先初始化数据库
        SQLiteDao.deleteFrom(MyCallBack.TABLE_USER);//然后清空之前的数据
        testInsert();
        users = (List<User>) query(MyCallBack.TABLE_USER);
        testUpdate();
//        // 更新一组数据
//        LouSQLite.execSQL("update " + MyCallBack.TABLE_NAME_PHRASE
//                + " set " + PhraseEntry.COLEUM_NAME_FAVORITE + "=1 "
//                + "where " + PhraseEntry.COLEUM_NAME_FAVORITE + "=0");
//        query();
//
//        // 删除一个数据
//        LouSQLite.delete(MyCallBack.TABLE_NAME_PHRASE
//                , PhraseEntry.COLEUM_NAME_ID + "=?"
//                , new String[]{phrase.getId()});
//        query();

    }

    /**
     * 测试更新单个数据方法
     */
    private void testUpdate() {
        for (int a=0 ;a<users.size();a++){
            if(users.get(a).getUsername().equals("黄家驹")){
                User u = users.get(a);
                u.setPassword("你好");
                SQLiteDao.update(MyCallBack.TABLE_USER,u,UserEntry.USER_ID+"=?",new String[]{u.getId()});
            }
        }
        query(MyCallBack.TABLE_USER);
    }

    /**
     * 测试插入方法
     */
    private void testInsert() {
        User user = new User("1","黄家驹","123456"); //新建一个对象
        User user2 = new User("2","陈奕迅","123456"); //新建一个对象
        User user3 = new User("3","水电","123456"); //新建一个对象
        User user4 = new User("4","地方","123456"); //新建一个对象
        User user5 = new User("5","奥迪","123456"); //新建一个对象
        User user6 = new User("6","罚的","123456"); //新建一个对象
        List<User>users = Arrays.asList(user,user2,user3,user4,user5,user6);
        SQLiteDao.insert(MyCallBack.TABLE_USER,users);

    }

    private Object query(String tableName) {
        List<Object> lists = SQLiteDao.query(tableName
                , "select id,username,password from " + tableName
                , null);
        LogUtils.showLog("查询结果",lists.toString());
        return lists;
    }
}
