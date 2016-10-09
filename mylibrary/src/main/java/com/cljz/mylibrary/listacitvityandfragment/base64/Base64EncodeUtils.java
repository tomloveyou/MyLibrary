package com.cljz.mylibrary.listacitvityandfragment.base64;


import com.cljz.mylibrary.listacitvityandfragment.util.Utils;

/**
 * Created by CLJZ on 2016/9/28.
 * 参数加密
 */
public class Base64EncodeUtils {

    /**
     * 参数加密
     */
    public static String enCode(String json){
        String param =  Base64.encode(Base64.decode(Base64.encode(json.toString())));
        String reverse = Base64.encode(Utils.getReverse(param));
        return  reverse;
    }
}
