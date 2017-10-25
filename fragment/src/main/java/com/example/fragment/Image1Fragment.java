package com.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Image1Fragment extends Fragment {


    public static final String KEY_IMG="img";

    public static Image1Fragment getInstance(int img){
        Image1Fragment frag=new Image1Fragment();
        Bundle bundle=new Bundle();
        bundle.putInt(KEY_IMG,img);
        frag.setArguments(bundle);
        return frag;
    }
    public Image1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rtvw= inflater.inflate(R.layout.fragment_image1, container, false);

        Bundle bundle=getArguments();
        if (bundle!=null){
            int img=bundle.getInt("img");
            ((ImageView)rtvw.findViewById(R.id.imageview)).setImageResource(img);
        }
        return rtvw;
    }

}
