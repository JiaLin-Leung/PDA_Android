package com.pda.pda_android.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/10 13:58
 * 功能：
 */
public class ScanWjbqsBean implements Serializable {

    private String barcode;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "ScanWjbqsBean{" +
                "barcode='" + barcode + '\'' +
                '}';
    }
}
