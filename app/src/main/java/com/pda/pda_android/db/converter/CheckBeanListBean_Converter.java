package com.pda.pda_android.db.converter;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.pda.pda_android.db.Entry.CheckBeanListBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:14
 * 功能：
 */
public class CheckBeanListBean_Converter implements PropertyConverter<List<CheckBeanListBean>, String> {
    @Override
    public List<CheckBeanListBean> convertToEntityProperty(String databaseValue) {
        return JSON.parseArray(databaseValue, CheckBeanListBean.class);
    }

    @Override
    public String convertToDatabaseValue(List<CheckBeanListBean> arrays) {
        return JSON.toJSONString(arrays);
    }
}
