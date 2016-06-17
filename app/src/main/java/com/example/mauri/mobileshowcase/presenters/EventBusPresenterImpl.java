package com.example.mauri.mobileshowcase.presenters;

import com.example.mauri.mobileshowcase.fragments.interfaces.DataInputView;
import com.example.mauri.mobileshowcase.presenters.interfaces.EventBusPresenter;

/**
 * Created by mauriciovignale on 17/06/16.
 */
public class EventBusPresenterImpl implements EventBusPresenter {

    private DataInputView dataView;
    public EventBusPresenterImpl(DataInputView dataView) {
        this.dataView = dataView;
    }

    @Override
    public void postData(String input) {
        if (dataView != null){
            dataView.showSpinner();
            if ("EventBus".equals(input)) {
                dataView.successMessage();
            } else {
                dataView.errorMessage();
            }
            dataView.hideSpinner();
        }
    }
}
