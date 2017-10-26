package com.example.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyItem> dataset=new ArrayList<>();
        dataset.add(new MyItem(R.mipmap.ic_launcher,"Launcher"));
        dataset.add(new MyItem(R.mipmap.ic_launcher,"Settings"));
        dataset.add(new MyItem(R.mipmap.ic_launcher,"Internet"));
        dataset.add(new MyItem(R.mipmap.ic_launcher,"Location"));

        MyAdapter adapter=new MyAdapter(this,dataset);

        ((GridView)findViewById(R.id.gridIcon)).setAdapter(adapter);

    }
}
