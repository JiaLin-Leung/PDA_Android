package com.pda.pda_android.base.others;

/**
 * 梁佳霖创建于：2018/10/8 14:26
 * 功能：存放服务器和接口地址
 */
public class ContentUrl {

    public static String ACTION = "com.scanner.broadcast";//PDA广播标记

    public static final String ARGS = "args";
//    public static final String TestUrl_local = "http://114.116.19.253:8001";//线上接口地址
    public static final String TestUrl_local = "http://192.168.7.136:8999";//本地接口地址
    public static final String login = "/apps/login";//登录接口地址
    public static final String getUsersList = "/sync/patient/list"; //获取患者列表
    public static final String getUsersCheckList = "/sync/patient/checking/list"; //获取患者检查列表
    public static final String getUsersAssayList = "/apps/patient/assay/list"; //获取患者检验列表
    public static final String getUsersSsxx = "/apps/patient/operation/list"; //获取患者手术列表
    public static final String getUsersSsxxDetail = "/apps/patient/operation/detail"; //获取患者手术详情
    public static final String getUsersAssayListDetail = "/apps/patient/assay/detail"; //获取患者检验详情

    public static final String getNotSignedList = "/apps/module/sterile/not_signed/list"; //获取未签收的无菌包列表

    public static final String sign = "/apps/module/sterile/manual/sign"; //手动签收无菌包

    public static final String sign_list = "/apps/module/sterile/signed/list"; //已经签收无菌包

    public static final String getNurseProfile = "/apps/profile"; //护士个人信息接口

    public static final String postScanWjbqs = "/apps/module/sterile/scan"; //扫描签收


    public static final String setPass = "/apps/set/pwd"; //设置密码


}
