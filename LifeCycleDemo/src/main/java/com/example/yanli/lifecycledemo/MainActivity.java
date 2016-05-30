package com.example.yanli.lifecycledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends Activity {
Button finish, startActivity;
    final String TAG = "---Life Cycle----";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"---onCreate----");
        finish = (Button)findViewById(R.id.finish);
        startActivity = (Button)findViewById(R.id.startActivity);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

    }
    public void onStart(){
        super.onStart();
        Log.d(TAG,"---onStart----");

    }

    public void onRestart(){
        super.onRestart();
        Log.d(TAG,"---onRestart----");

    }

    public void onResume(){
        super.onResume();
        Log.d(TAG,"---onResume----");

    }
    public void onPause(){
        super.onPause();
        Log.d(TAG,"---onPause----");

    }

    public void onStop(){
        super.onStop();
        Log.d(TAG,"---onStop----");

    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"---onDestroy----");

    }




}
