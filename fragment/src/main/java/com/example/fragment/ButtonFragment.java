package com.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {


    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rtvw= inflater.inflate(R.layout.fragment_button, container, false);

        rtvw.findViewById(R.id.btnflower).setOnClickListener(this::onflower);
        rtvw.findViewById(R.id.btnairplane).setOnClickListener(this::onairplane);
        rtvw.findViewById(R.id.btncar).setOnClickListener(this::oncar);
        
        return rtvw;
    }

    private void oncar(View view) {

        ((MainActivity) getActivity()).loadFrag(
                Image1Fragment.getInstance(R.drawable.ic_automobile));
    }

    private void onairplane(View view) {
        Image1Fragment fragment=new Image1Fragment();
        Bundle bundle=new Bundle();
        bundle.putInt("img",R.drawable.ic_airplane);
        fragment.setArguments(bundle);

        ((MainActivity) getActivity()).loadFrag(fragment);
    }

    private void onflower(View view) {
        Image1Fragment fragment=new Image1Fragment();
        Bundle bundle=new Bundle();
        bundle.putInt("img",R.drawable.ic_flower);
        fragment.setArguments(bundle);

        ((MainActivity) getActivity()).loadFrag(fragment);
    }
}
