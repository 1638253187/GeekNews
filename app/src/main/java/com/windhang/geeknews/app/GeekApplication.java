package com.windhang.geeknews.app;

import android.app.Application;

public class GeekApplication extends Application {
    public static GeekApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static GeekApplication getApp() {
        return app;
    }
}
