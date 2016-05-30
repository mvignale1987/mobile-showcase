package com.example.mauri.mobileshowcase.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mauri.retrofitexample.R;
import com.example.mauri.mobileshowcase.adapters.AndroidVersionListAdapter;
import com.example.mauri.mobileshowcase.models.AndroidVersion;
import com.example.mauri.mobileshowcase.requests.GetAndroidVersionsRequest;

import java.util.List;

public class AndroidVersionFragment extends Fragment implements GetAndroidVersionsRequest.GetAndroidVersionsListener {
    private RecyclerView recyclerView;
    private List<AndroidVersion> data;
    private AndroidVersionListAdapter adapter;
    private View mRootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.android_version_fragment,container,false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        new GetAndroidVersionsRequest(this);
        return mRootView;
    }



    @Override
    public void onAndroidVersionsResponse(List<AndroidVersion> androidVersions) {
        data = androidVersions;
        adapter = new AndroidVersionListAdapter(androidVersions);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onErrorResponse(String errorMessage) {
        Log.d("Error", errorMessage);

    }
}

