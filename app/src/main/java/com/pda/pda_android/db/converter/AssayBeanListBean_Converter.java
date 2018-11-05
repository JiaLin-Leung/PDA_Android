package com.pda.pda_android.db.converter;

import com.alibaba.fastjson.JSON;
import com.pda.pda_android.db.Entry.AssayBean;
import com.pda.pda_android.db.Entry.AssayBeanListBean;
import com.pda.pda_android.db.Entry.CheckBeanListBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:14
 * 功能：
 */
public class AssayBeanListBean_Converter implements PropertyConverter<List<AssayBeanListBean>, String> {
    @Override
    public List<AssayBeanListBean> convertToEntityProperty(String databaseValue) {
        return JSON.parseArray(databaseValue, AssayBeanListBean.class);
    }

    @Override
    public String convertToDatabaseValue(List<AssayBeanListBean> arrays) {
        return JSON.toJSONString(arrays);
    }
}
