package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by sonal on 10/10/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<CustItm> dataset;
    private LayoutInflater inflater;

    public MyAdapter(Context context,List<CustItm> dataset){
        this.context=context;
        this.dataset=dataset;
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int pos) {
        return dataset.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertview, ViewGroup viewGroup) {
        View viewRoot=null;
        if (convertview==null) viewRoot=inflater.inflate(R.layout.cust_item,viewGroup,false);
        else viewRoot=convertview;

        ((ImageView)viewRoot.findViewById(R.id.imgVw)).setImageResource(dataset.get(pos).getImgId());
        ((TextView)viewRoot.findViewById(R.id.txtVw)).setText(dataset.get(pos).getTxt());
        return viewRoot;
    }
}
