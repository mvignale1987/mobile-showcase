package com.example.mauri.mobileshowcase.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mauri.mobileshowcase.fragments.interfaces.DataInputView;
import com.example.mauri.mobileshowcase.presenters.interfaces.EventBusPresenter;
import com.example.mauri.mobileshowcase.presenters.EventBusPresenterImpl;
import com.example.mauri.retrofitexample.R;


/**
 * Created by mauriciovignale on 10/06/16.
 */

public class EventBusFragment extends Fragment implements DataInputView, View.OnClickListener {

    private View mRootView;
    private EditText eventbusTxt;
    private EventBusPresenter eventBusPresenter;
    private  ProgressDialog progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.eventbus_fragment, container, false);
        eventbusTxt = (EditText) mRootView.findViewById(R.id.eventbus_et);
        (mRootView.findViewById(R.id.eventbus_button)).setOnClickListener(this);
        progressBar = new ProgressDialog(getActivity());
        eventBusPresenter = new EventBusPresenterImpl(this);
        return mRootView;
    }

    @Override
    public void showSpinner() {
        progressBar.show();
    }

    @Override
    public void hideSpinner() {
        progressBar.dismiss();
    }

    @Override
    public void successMessage() {
        Toast.makeText(getActivity(), getString(R.string.eventbus_ok_text), Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorMessage() {
        Toast.makeText(getActivity(), getString(R.string.eventbus_error_text), Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.eventbus_button:
                
                eventBusPresenter.postData(eventbusTxt.getText().toString());
                break;
        }
    }
}
