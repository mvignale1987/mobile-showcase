package com.example.mauri.mobileshowcase.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.mauri.retrofitexample.R;
import com.example.mauri.mobileshowcase.app.ExampleApp;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private String[] mDrawerGroups;
    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerList;
    private Map<String, List<String>> mExpandableListMap ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerGroups = getResources().getStringArray(R.array.drawer_groups);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ExpandableListView) findViewById(R.id.left_drawer);

        mExpandableListMap = new LinkedHashMap<>();

        mExpandableListMap.put(mDrawerGroups[0],Arrays.asList(getResources().getStringArray(R.array.networking_items)));
        mExpandableListMap.put(mDrawerGroups[1],Arrays.asList(getResources().getStringArray(R.array.google_items)));
        mExpandableListMap.put(mDrawerGroups[3],Arrays.asList(getResources().getStringArray(R.array.mvp_items)));


        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            final ExpandableListAdapter expandableListAdapter = new com.example.mauri.mobileshowcase.adapters.ExpandableListAdapter(this, mExpandableListMap, Arrays.asList(mDrawerGroups));
            mDrawerList.setAdapter(expandableListAdapter);
            ExampleApp.screenManager.showAndroidVersions(this, "test");
        }
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setElevation(getResources().getDimension(R.dimen.toolbar_elevation));
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}

