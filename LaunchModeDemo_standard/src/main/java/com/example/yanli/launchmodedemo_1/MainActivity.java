package com.example.yanli.launchmodedemo_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(MainActivity.this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        Button bn = new Button(MainActivity.this);
        bn.setText("go to another activity");
        bn.setTextSize(20);
        ll.addView(bn);
        TextView textView = new TextView(MainActivity.this);
        textView.setText("Activity: "+this.toString()+"\n "+"taskId is: "+this.getTaskId());
        textView.setTextSize(20);
        ll.addView(textView);

        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
