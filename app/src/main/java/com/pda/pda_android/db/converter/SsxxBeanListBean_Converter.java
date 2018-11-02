package com.pda.pda_android.db.converter;

import com.alibaba.fastjson.JSON;
import com.pda.pda_android.db.Entry.CheckBeanListBean;
import com.pda.pda_android.db.Entry.SsxxBeanListBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:14
 * 功能：
 */
public class SsxxBeanListBean_Converter implements PropertyConverter<List<SsxxBeanListBean>, String> {
    @Override
    public List<SsxxBeanListBean> convertToEntityProperty(String databaseValue) {
        return JSON.parseArray(databaseValue, SsxxBeanListBean.class);
    }

    @Override
    public String convertToDatabaseValue(List<SsxxBeanListBean> arrays) {
        return JSON.toJSONString(arrays);
    }
}
