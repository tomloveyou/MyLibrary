package com.cljz.mylibrary.listacitvityandfragment.util;

import android.annotation.SuppressLint;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类
 */
public class GetSystemTimeUitl {

	/**
	 * 包含年月日时分
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getInDetailgetTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		return time;
	}

	/**
	 * 只包含时分秒
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String time = df.format(new Date());
		return time;
	}

	/**
	 * 生日
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getTime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = df.format(date);
		return time;
	}

	/**
	 * 系统单年月日
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getPresentSystime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String a = df.format(new Date());
		return a;
	}

	/**
	 * dp转像素
	 * 
	 * @param context
	 * @param dp
	 * @return
	 */
	public static int dp2Px(Context context, float dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		int i = (int) (dp * scale + 0.5f);
		return i;

	}

	/**
	 * 像素转dp
	 * 
	 * @param context
	 * @param px
	 * @return
	 */
	public static int px2Dp(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	/**
	 * 时间戳转换
	 */
	@SuppressLint("SimpleDateFormat")
	public static String timeConvert(long mill) {
		Date date = new Date(mill * 1000L);
		String strs = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			strs = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strs;
	}
}
