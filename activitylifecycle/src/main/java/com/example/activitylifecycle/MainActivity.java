package com.example.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mt("oncreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onrestart");
    }

    @Override
    protected void onStart() {
        super.onStart();

        mt("onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mt("onresume");
    }

    @Override
    protected void onPause() {
        mt("onpause");

        super.onPause();
    }

    @Override
    protected void onStop() {
        mt("onstop");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mt("ondestroy");

        super.onDestroy();
    }

    private void mt(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
