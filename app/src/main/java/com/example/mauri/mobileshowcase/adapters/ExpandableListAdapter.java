package com.example.mauri.mobileshowcase.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.mauri.retrofitexample.R;

import java.util.List;
import java.util.Map;

/**
 * Created by mauri on 30/05/16.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {


    private Activity context;
    private Map<String, List<String>> mExpandableListMap;
    private List<String> items;


    public ExpandableListAdapter(Activity context, Map<String, List<String>> mExpandableListMap, List<String> items) {
        this.context = context;
        this.mExpandableListMap = mExpandableListMap;
        this.items = items;
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mExpandableListMap.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mExpandableListMap.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mExpandableListMap.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String drawerGroup = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.drawer_list_group,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.drawer_text);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(drawerGroup);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String drawerItem = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.drawer_text);

        item.setText(drawerItem);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
