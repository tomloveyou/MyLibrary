package com.cljz.mylibrary.listacitvityandfragment.base64;



import com.cljz.mylibrary.listacitvityandfragment.util.Utils;

import org.json.JSONObject;

/**
 * Created by CLJZ on 2016/9/28.
 * 解密结果
 */
public class Base64DecodeUtils {

    /**
     * 解密结果
     */
     public static JSONObject deCode(String string){
         JSONObject js = null;
         try {
             JSONObject jsonObject = new JSONObject(string);
             String a = Utils.getReverse(Base64.decode(jsonObject.optString("code")));
             js = new JSONObject(Base64.decode(a));
         }catch (Exception e){

         }
         return js;
     }

    public static String deCodeString(String string){
        String js = null;
        try {
            JSONObject jsonObject = new JSONObject(string);
            String a = Utils.getReverse(Base64.decode(jsonObject.optString("code")));
            js = Base64.decode(a);
        }catch (Exception e){

        }
        return js;
    }
}
