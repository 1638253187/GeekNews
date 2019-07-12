package com.windhang.geeknews.util;

import android.widget.Toast;

import com.windhang.geeknews.app.GeekApplication;

/**
 * @author anfly
 * @date 2019/7/8.
 * description：toast工具类
 */
public class ToastUtil {
    public static void showShort(String msg) {
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(GeekApplication.getApp(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(GeekApplication.getApp(), msg, Toast.LENGTH_LONG).show();
    }
}
