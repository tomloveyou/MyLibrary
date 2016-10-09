package com.cljz.mylibrary.listacitvityandfragment.dbmanager;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class UnCaughtCrashExceptionHandler implements UncaughtExceptionHandler {
	public static final String TAG = "CrashHandler";
	public static final boolean DEBUG = true;
	private UncaughtExceptionHandler mDefaultHandler;
	private static UnCaughtCrashExceptionHandler INSTANCE;
	private Context mContext;

	private UnCaughtCrashExceptionHandler() {

	}

	/** 获取CrashHandler实例 ,单例模式 */
	public static UnCaughtCrashExceptionHandler getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UnCaughtCrashExceptionHandler();
		}
		return INSTANCE;
	}

	/**
	 * 初始化,注册Context对象, 获取系统默认的UncaughtException处理器, 设置该CrashHandler为程序的默认处理器
	 * @param ctx
	 */
	public void init(Context ctx) {
		mContext = ctx;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}
	
	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */

	public void uncaughtException(Thread thread, Throwable ex) {
		if (!handleException(ex) && mDefaultHandler != null) {
			mDefaultHandler.uncaughtException(thread, ex);
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Log.e(TAG, "Error : ", e);
			}
		}
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(10);
	}

	/**
	 * @return true:如果处理了该异常信息;否则返回false
	 */
	private boolean handleException(Throwable ex) {
		if (ex == null) {
			return true;
		}
		final String msg = ex.getLocalizedMessage();
		new Thread() {
			public void run() {
				Looper.prepare();
				Log.e(TAG,"程序出错啦:" + msg);
				Looper.loop();
			}
		}.start();
		return true;
	}
}
