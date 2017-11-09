package com.example.uithread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.myLooper());
    }

    public void onOk(View view) {
        new myTask().execute(0,10/*param*/);
    }

    private void counter() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((TextView) findViewById(R.id.txtcnt)).setText(String.valueOf(i));
        }
    }

    private void threadCounter() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter();
            }
        }).start();
    }

    int i = 0;

    private void handlerCounter() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) findViewById(R.id.txtcnt)).setText(String.valueOf(i));
                        }
                    });
                }
            }
        }).start();
    }

    private class myTask extends AsyncTask<Integer/*param*/,String/*progress*/,Boolean/*result*/>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Ui Thread
        }

        @Override
        protected Boolean doInBackground(Integer... integers/*param*/) {
            //Worker Thread

            for (int i=integers[0]; i<integers[1]; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }
                return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*result*/) {
            super.onPostExecute(aBoolean);
            //Ui Thread
        }

        @Override
        protected void onProgressUpdate(String... values/*progress*/) {
            super.onProgressUpdate(values);
            //Ui Thread
            ((TextView) findViewById(R.id.txtcnt)).setText(values[0]);
        }
    }
}


