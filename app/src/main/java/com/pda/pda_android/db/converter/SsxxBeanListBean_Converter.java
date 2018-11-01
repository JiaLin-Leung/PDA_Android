package com.pda.pda_android.db.converter;

import com.google.gson.Gson;
import com.pda.pda_android.db.Entry.SsxxBeanListBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:14
 * 功能：
 */
public class SsxxBeanListBean_Converter implements PropertyConverter<List<SsxxBeanListBean>, String> {
    @Override
    public List<SsxxBeanListBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        List<String> list_str = Arrays.asList(databaseValue.split(","));
        List<SsxxBeanListBean> list_transport = new ArrayList<>();
        for (String s : list_str) {
            list_transport.add(new Gson().fromJson(s, SsxxBeanListBean.class));
        }
        return list_transport;
    }

    @Override
    public String convertToDatabaseValue(List<SsxxBeanListBean> arrays) {
        if (arrays == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (SsxxBeanListBean array : arrays) {
                String str = new Gson().toJson(array);
                sb.append(str);
                sb.append(",");
            }
            return sb.toString();

        }
    }
}
