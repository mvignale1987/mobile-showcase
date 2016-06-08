package com.example.mauri.mobileshowcase.utils;

import android.content.res.Resources;

import com.example.mauri.retrofitexample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauri on 8/06/16.
 */

public class ExpandableListUtils {

    public static HashMap<String, List<String>> getData(Resources res){
        HashMap expandableListDetail = new HashMap<String,List<String>>();


        expandableListDetail.put(Arrays.asList(res.getStringArray(R.array.drawer_groups)).get(0),Arrays.asList(res.getStringArray(R.array.networking_items)));
        expandableListDetail.put(Arrays.asList(res.getStringArray(R.array.drawer_groups)).get(1), Arrays.asList(res.getStringArray(R.array.google_items)));
        expandableListDetail.put(Arrays.asList(res.getStringArray(R.array.drawer_groups)).get(3),Arrays.asList(res.getStringArray(R.array.mvp_items)));


        return expandableListDetail;
    }
}
