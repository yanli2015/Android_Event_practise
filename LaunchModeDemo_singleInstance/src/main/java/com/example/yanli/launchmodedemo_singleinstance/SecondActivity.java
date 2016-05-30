package com.example.yanli.launchmodedemo_singleinstance;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        TextView tv = new TextView(this);
        tv.setText("Activity：" + this.toString()
                + "\n" + "，Task ID:" + this.getTaskId());
        layout.addView(tv);
        Button button = new Button(this);
        button.setText("MainActivity");
        layout.addView(button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this
                        ,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}