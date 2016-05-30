package com.example.mauri.mobileshowcase.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mauri.retrofitexample.R;
import com.example.mauri.mobileshowcase.models.AndroidVersion;

import java.util.List;

/**
 * Created by mauri on 26/05/16.
 */

public class AndroidVersionListAdapter extends RecyclerView.Adapter<AndroidVersionListAdapter.ViewHolder> {
    private List<AndroidVersion> android;

    public AndroidVersionListAdapter(List<AndroidVersion> android) {
        this.android = android;
    }

    @Override
    public AndroidVersionListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AndroidVersionListAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(android.get(i).getName());
        viewHolder.tv_version.setText(android.get(i).getVer());
        viewHolder.tv_api_level.setText(android.get(i).getApi());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }

}