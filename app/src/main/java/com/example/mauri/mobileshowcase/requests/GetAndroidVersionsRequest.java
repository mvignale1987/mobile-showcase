package com.example.mauri.mobileshowcase.requests;

import com.example.mauri.mobileshowcase.requests.interfaces.AndroidVersionApi;
import com.example.mauri.mobileshowcase.responses.AndroidVersionResponse;
import com.example.mauri.mobileshowcase.models.AndroidVersion;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mauri on 29/05/16.
 */

public class GetAndroidVersionsRequest extends BaseRequest implements Callback<AndroidVersionResponse>{

    private static final String API_CALL = "getJSON" ;
    private static final Class API_CLASS = AndroidVersionApi.class;

    public interface GetAndroidVersionsListener{
        void onAndroidVersionsResponse(List<AndroidVersion> androidVersions);

        void onErrorResponse(String errorMessage);
    }

    private GetAndroidVersionsListener mContext;

    public GetAndroidVersionsRequest(GetAndroidVersionsListener context){
        this.mContext = context;
        dispatch(API_CLASS,API_CALL,this);
    }

    @Override
    public void onResponse(Call<AndroidVersionResponse> call, Response<AndroidVersionResponse> response) {
        mContext.onAndroidVersionsResponse(Arrays.asList(response.body().getAndroid()));
    }

    @Override
    public void onFailure(Call<AndroidVersionResponse> call, Throwable t) {
        mContext.onErrorResponse(t.getMessage());
    }


}
