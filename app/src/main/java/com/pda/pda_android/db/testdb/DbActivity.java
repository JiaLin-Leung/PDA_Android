package com.pda.pda_android.db.testdb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pda.pda_android.R;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.db.SQLiteDao;
import com.pda.pda_android.db.MyCallBack;
import com.pda.pda_android.db.bean.Phrase;
import com.pda.pda_android.db.bean.User;

import java.util.Arrays;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/24 10:13
 * 功能：测试数据库工具类型
 */
public class DbActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    public static void getDbInstance(Context context){
        Intent intent = new Intent(context,DbActivity.class);
        context.startActivity(intent);
    }

    private void initData() {

        SQLiteDao.init(DbActivity.this,new MyCallBack());//首先初始化数据库
        SQLiteDao.deleteFrom(MyCallBack.TABLE_USER);//然后清空之前的数据

        User user = new User("黄家驹","123456");
        LogUtils.showLog("2222222",user.toString());
        SQLiteDao.insert(MyCallBack.TABLE_USER,user);

//        // 初始化
//        LouSQLite.init(this.getApplicationContext(), new MyCallBack());
//
//        // 清空之前的数据
//        LouSQLite.deleteFrom(MyCallBack.TABLE_NAME_PHRASE);
//        query();
//
        // 插入一个数据到数据库
//        Phrase phrase = new Phrase("青青子衿，悠悠我心");
//        Phrase phrase = new Phrase();
//        phrase.setId("444");
//        phrase.setContent("44555");
//        phrase.setFavorite(6666);
//        LouSQLite.insert(MyCallBack.TABLE_NAME_PHRASE, phrase);
//        query();
//
//        // 插入一组数据
//        Phrase phrase1 = new Phrase("窈窕淑女，君子好逑");
//        Phrase phrase2 = new Phrase("海上生明月，天涯共此时");
//        Phrase phrase3 = new Phrase("青青子衿，悠悠我心");
//        Phrase phrase4 = new Phrase("人生若只如初见");
//        List<Phrase> lists = Arrays.asList(
//                phrase1
//                , phrase2
//                , phrase3
//                , phrase4
//        );
//        LouSQLite.insert(MyCallBack.TABLE_NAME_PHRASE, lists);
//        query();
//
//        // 更新一个数据
//        phrase.setContent(phrase.getContent() + " 嘿嘿嘿");
//        LouSQLite.update(MyCallBack.TABLE_NAME_PHRASE
//                , phrase
//                , PhraseEntry.COLEUM_NAME_ID + "=?"
//                , new String[]{phrase.getId()});
//        query();
//
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

    private void query() {
        List<Phrase> lists = SQLiteDao.query(MyCallBack.TABLE_NAME_PHRASE
                , "select * from " + MyCallBack.TABLE_NAME_PHRASE
                , null);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
