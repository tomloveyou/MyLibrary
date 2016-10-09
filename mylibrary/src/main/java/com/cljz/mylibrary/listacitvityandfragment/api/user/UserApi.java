package com.cljz.mylibrary.listacitvityandfragment.api.user;


import com.cljz.mylibrary.listacitvityandfragment.api.BaseAPI;

/**
 * Created by CLJZ on 2016/9/27.
 * 此类放用户相关地址
 */
public class UserApi {

    //注册
    public static String REGISTER = BaseAPI.BASEURL+"index.php/Api/Index/memberRegister";

    //登录
    public static String LOGIN = BaseAPI.BASEURL+"index.php/Api/Index/memberLogin";

    //验证码
    public static String VERIFYCODE = BaseAPI.BASEURL+"index.php/Api/Index/sendVerifyCode";
}
