package com.example.mauri.mobileshowcase.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.example.mauri.retrofitexample.R;
import com.example.mauri.mobileshowcase.app.ExampleApp;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ExpandableListView) findViewById(R.id.left_drawer);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            ExampleApp.screenManager.showAndroidVersions(this, "test");
        }
    }
}

