package com.example.mauri.mobileshowcase.requests;

import com.example.mauri.mobileshowcase.app.ExampleApp;

import retrofit2.Callback;

/**
 * Created by mauri on 29/05/16.
 */

public class BaseRequest {



    protected void dispatch(Class api_clazz, String api_call, Callback callback){
        ExampleApp.retrofitManager.dispatchRequest(api_clazz , api_call , callback);
    }
}
