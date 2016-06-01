package com.example.mauri.mobileshowcase.activities;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mauri.mobileshowcase.adapters.ExpandableListAdapter;
import com.example.mauri.mobileshowcase.app.ExampleApp;
import com.example.mauri.retrofitexample.R;

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

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mDrawerGroups = getResources().getStringArray(R.array.drawer_groups);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerList = (ExpandableListView) findViewById(R.id.left_drawer);
        final RelativeLayout headerView = (RelativeLayout) View.inflate(this, R.layout.drawer_header, null);

        ((TextView) headerView.findViewById(R.id.navigation_header_email)).setText(R.string.email);
        ((TextView) headerView.findViewById(R.id.navigation_header_username)).setText(R.string.name);

        mExpandableListMap = new LinkedHashMap<>();

        mExpandableListMap.put(mDrawerGroups[0],Arrays.asList(getResources().getStringArray(R.array.networking_items)));
        mExpandableListMap.put(mDrawerGroups[1],Arrays.asList(getResources().getStringArray(R.array.google_items)));
        mExpandableListMap.put(mDrawerGroups[3],Arrays.asList(getResources().getStringArray(R.array.mvp_items)));


        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            final ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(this, mExpandableListMap, Arrays.asList(mDrawerGroups));
            mDrawerList.addHeaderView(headerView);
            mDrawerList.setAdapter(expandableListAdapter);
            ExampleApp.screenManager.showAndroidVersions(this, "test");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

