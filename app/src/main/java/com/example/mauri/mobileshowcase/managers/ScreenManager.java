package com.example.mauri.mobileshowcase.managers;

import android.support.v4.app.FragmentActivity;
import android.widget.ExpandableListView;

import com.example.mauri.mobileshowcase.activities.MainActivity;
import com.example.mauri.mobileshowcase.fragments.ComingSoonFragment;
import com.example.mauri.mobileshowcase.fragments.EventBusFragment;
import com.example.mauri.retrofitexample.R;
import com.example.mauri.mobileshowcase.fragments.AndroidVersionFragment;

/**
 * Created by mauri on 29/05/16.
 */

public class ScreenManager {


    public void showAndroidVersions(FragmentActivity origin, String actionbarTitle) {
        AndroidVersionFragment fragment = new AndroidVersionFragment();
        origin.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    public void showComingSoon(FragmentActivity origin, String select) {
        ComingSoonFragment fragment = new ComingSoonFragment();
        origin.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    public void showEventBus(FragmentActivity origin, String select) {
        EventBusFragment fragment = new EventBusFragment();
        origin.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
