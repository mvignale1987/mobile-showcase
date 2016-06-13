package com.example.mauri.mobileshowcase.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mauri.retrofitexample.R;

/**
 * Created by mauriciovignale on 10/06/16.
 */

public class EventBusFragment extends Fragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.eventbus_fragment, container, false);
        return mRootView;
    }

}
