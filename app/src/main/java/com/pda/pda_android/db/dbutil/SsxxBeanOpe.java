package com.pda.pda_android.db.dbutil;

import android.content.Context;

import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.dao.SsxxBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 梁佳霖创建于：2018/10/30 10:20
 * 功能：操作用户的工具
 */
public class SsxxBeanOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, SsxxBean stu) {
        DbManager.getDaoSession(context).getSsxxBeanDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<SsxxBean> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getSsxxBeanDao().insertInTx(list);
    }
    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, SsxxBean student) {
        DbManager.getDaoSession(context).getSsxxBeanDao().save(student);
    }
    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, SsxxBean student) {
        DbManager.getDaoSession(context).getSsxxBeanDao().delete(student);
    }
    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, Long id) {
        DbManager.getDaoSession(context).getSsxxBeanDao().deleteByKey(id);
    }
    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getSsxxBeanDao().deleteAll();
    }
    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, SsxxBean student) {
        DbManager.getDaoSession(context).getSsxxBeanDao().update(student);
    }
    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<SsxxBean> queryAll(Context context) {
        QueryBuilder<SsxxBean> builder = DbManager.getDaoSession(context).getSsxxBeanDao().queryBuilder();

        return builder.build().list();
    }



    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<SsxxBean> queryPaging( int pageSize, int pageNum,Context context){
        SsxxBeanDao studentDao = DbManager.getDaoSession(context).getSsxxBeanDao();
        List<SsxxBean> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }
}
