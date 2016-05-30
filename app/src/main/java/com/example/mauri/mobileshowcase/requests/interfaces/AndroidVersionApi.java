package com.example.mauri.mobileshowcase.requests.interfaces;

import com.example.mauri.mobileshowcase.responses.AndroidVersionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mauri on 26/05/16.
 */

public interface AndroidVersionApi {

    @GET("android/jsonandroid")
    Call<AndroidVersionResponse> getJSON();
}

