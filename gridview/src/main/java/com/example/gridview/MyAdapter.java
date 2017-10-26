package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sonal on 26/10/17.
 */

public class MyAdapter extends BaseAdapter {

    public final Context context;
    private final ArrayList<MyItem> dataset;
    private LayoutInflater inflater;

    public MyAdapter(Context context,ArrayList<MyItem> dataset){
        this.context=context;
        this.dataset=dataset;

        inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if (convertView==null)
            view=inflater.inflate(R.layout.grid_item,parent,false);
        else view=convertView;
        ((ImageView)view.findViewById(R.id.imgIc)).setImageResource(dataset.get(position).img);
        ((TextView)view.findViewById(R.id.txtName)).setText(dataset.get(position).txt);

        return view;
    }
}
