package com.pda.pda_android.db.converter;

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
        if (databaseValue == null) {
            return null;
        }
        List<String> list_str = Arrays.asList(databaseValue.split(","));
        List<CheckBeanListBean> list_transport = new ArrayList<>();
        for (String s : list_str) {
            list_transport.add(new Gson().fromJson(s, CheckBeanListBean.class));
        }
        return list_transport;
    }

    @Override
    public String convertToDatabaseValue(List<CheckBeanListBean> arrays) {
        if (arrays == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (CheckBeanListBean array : arrays) {
                String str = new Gson().toJson(array);
                sb.append(str);
                sb.append(",");
            }
            return sb.toString();

        }
    }
}
