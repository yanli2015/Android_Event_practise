package com.example.yanli.launchmodedemo_singleinstance;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(layout);

        TextView tv = new TextView(this);
        tv.setText("Activity：" + this.toString()
                + "\n" + "，Task ID:" + this.getTaskId());
        Button button = new Button(this);
        button.setText("SecondActivity");
        layout.addView(tv);
        layout.addView(button);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this
                        , SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
