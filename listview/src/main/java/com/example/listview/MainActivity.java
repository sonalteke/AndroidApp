package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> dataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //advancedList();
        normallist();
    }

    private void normallist() {
        dataset.add("C");
        dataset.add("C++");
        dataset.add("java");
        dataset.add("php");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dataset);


        ListView lstlan = findViewById(R.id.listview);
        lstlan.setAdapter(adapter);

        lstlan.setOnItemClickListener
                ((adapterView, view, pos, id) -> ((EditText) findViewById(R.id.lanet)).setText(dataset.get(pos)));

        lstlan.setOnItemLongClickListener((adapterView, view, pos, id) -> {
            dataset.remove(pos);
            adapter.notifyDataSetChanged();
            return true;
        });
    }

    public void onadd(View view){
        dataset.add(((EditText)findViewById(R.id.lanet)).getText().toString());
        ArrayAdapter<String> adapter=(ArrayAdapter<String>)((ListView)findViewById(R.id.listview)).getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void advancedList(){
        List<CustItm> datasetcust=new ArrayList<>();
        datasetcust.add(new CustItm(R.drawable.ic_launcher_background,"simple"));
        datasetcust.add(new CustItm(R.drawable.ic_bus,"bus"));
        datasetcust.add(new CustItm(R.drawable.ic_house,"house"));

        MyAdapter adapter=new MyAdapter(this,datasetcust);
        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);
    }
}
