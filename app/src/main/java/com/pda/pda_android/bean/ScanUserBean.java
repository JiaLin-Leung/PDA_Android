package com.pda.pda_android.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/10 10:54
 * 功能：PDA扫描的用户信息，测试期间暂时只写上床位，后期可能会修改字段或增加字段
 */
public class ScanUserBean implements Serializable {

    private String record_no;

    public String getRecord_no() {
        return record_no;
    }

    public void setRecord_no(String record_no) {
        this.record_no = record_no;
    }

    @Override
    public String toString() {
        return "ScanUserBean{" +
                "record_no='" + record_no + '\'' +
                '}';
    }
}
