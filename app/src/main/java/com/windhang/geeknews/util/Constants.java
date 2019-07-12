package com.windhang.geeknews.util;

import android.os.Environment;

import com.windhang.geeknews.app.GeekApplication;

import java.io.File;

public interface Constants {
    boolean isDebug = true;

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY = "com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = GeekApplication.getApp().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
}
