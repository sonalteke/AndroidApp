package com.example.activitystatemanagementown;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){

            ((ImageView) findViewById(R.id.imageview)).setImageResource(R.drawable.motorbike);
        }
        else if (newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            ((ImageView) findViewById(R.id.imageview)).setImageResource(R.drawable.poppy);
        }
        else {
            ((ImageView) findViewById(R.id.imageview)).setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
