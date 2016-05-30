package com.example.yanli.handlerdemo_2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    static final String UPPER_NUM = "upper";
    EditText etNum;
    CalThread calThread;






    class CalThread extends Thread {
        public Handler handler;

        public void run() {
            Looper.prepare();
            handler = new Handler() {
                public void handleMessage(Message msg) {
                    if (msg.what == 0x12) {
                           int upper =  msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<Integer>();
                        outer:
                        for (int i = 2; i <= upper; i++){
                            for (int j = 2; j <= Math.sqrt(i); j++){
                                if (i != 2 && i% j == 0 ){
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        Toast.makeText(MainActivity.this, "All the pime numbers are: "+nums.toString(), Toast.LENGTH_LONG).show();
                    }
                }


            };
            Looper.loop();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum = (EditText) findViewById(R.id.etNum);
        calThread = new CalThread();
        calThread.start();


    }
    public void cal(View source) {
        Message msg = new Message();
        msg.what = 0x12;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
        msg.setData(bundle);
        calThread.handler.sendMessage(msg);

    }

}
