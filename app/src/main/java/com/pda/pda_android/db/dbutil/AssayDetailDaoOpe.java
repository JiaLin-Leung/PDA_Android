package com.pda.pda_android.db.dbutil;

import android.content.Context;

import com.pda.pda_android.db.Entry.AssayDetailBean;
import com.pda.pda_android.db.dao.AssayDetailBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * 梁佳霖创建于：2018/10/30 10:20
 * 功能：操作用户的工具
 */
public class AssayDetailDaoOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, AssayDetailBean stu) {
        DbManager.getDaoSession(context).getAssayDetailBeanDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<AssayDetailBean> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getAssayDetailBeanDao().insertInTx(list);
    }
    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, AssayDetailBean student) {
        DbManager.getDaoSession(context).getAssayDetailBeanDao().save(student);
    }
    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, AssayDetailBean student) {
        DbManager.getDaoSession(context).getAssayDetailBeanDao().delete(student);
    }
    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, Long id) {
        DbManager.getDaoSession(context).getAssayDetailBeanDao().deleteByKey(id);
    }
    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getAssayDetailBeanDao().deleteAll();
    }
    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, AssayDetailBean student) {
        DbManager.getDaoSession(context).getAssayDetailBeanDao().update(student);
    }
    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<AssayDetailBean> queryAll(Context context) {
        QueryBuilder<AssayDetailBean> builder = DbManager.getDaoSession(context).getAssayDetailBeanDao().queryBuilder();

        return builder.build().list();
    }

    /**
     * 根据patient_no查询某一条信息的详情
     *
     * @param context
     * @return
     */
    public static List<AssayDetailBean> queryAllByPatient_no(Context context,String patient_no) {
        List<AssayDetailBean> checkBean= DbManager.getDaoSession(context).getAssayDetailBeanDao().queryBuilder().
                where(AssayDetailBeanDao.Properties.Patient_no.eq(patient_no)).list();
        return checkBean;
    }
    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<AssayDetailBean> queryPaging( int pageSize, int pageNum,Context context){
        AssayDetailBeanDao studentDao = DbManager.getDaoSession(context).getAssayDetailBeanDao();
        List<AssayDetailBean> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }
}
