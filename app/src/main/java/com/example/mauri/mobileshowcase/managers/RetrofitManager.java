package com.example.mauri.mobileshowcase.managers;

import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mauri on 29/05/16.
 */

public class RetrofitManager {
    private static RetrofitManager INSTANCE;

    private static Retrofit mRetrofit;

    public static RetrofitManager getInstance() {
        if (INSTANCE == null)

            INSTANCE = new RetrofitManager();
        return INSTANCE;
    }

    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static void dispatchRequest(Class apiClass, String method, Callback request) {
        Method apiCall = null;
        try {
            apiCall = apiClass.getMethod(method);
            ((Call) apiCall.invoke(mRetrofit.create(apiClass))).enqueue(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
