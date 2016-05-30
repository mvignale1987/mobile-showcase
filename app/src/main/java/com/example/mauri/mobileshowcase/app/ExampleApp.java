package com.example.mauri.mobileshowcase.app;

import android.app.Application;

import com.example.mauri.mobileshowcase.managers.ScreenManager;
import com.example.mauri.mobileshowcase.managers.RetrofitManager;

/**
 * Created by mauri on 29/05/16.
 */

public class ExampleApp extends Application {
    public static RetrofitManager retrofitManager;
    public static final ScreenManager screenManager = new ScreenManager();


    @Override
    public void onCreate() {
        super.onCreate();
        retrofitManager = RetrofitManager.getInstance();
    }
}
