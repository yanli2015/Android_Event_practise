package com.example.yanli.launchmodedemo_singletask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;





public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(SecondActivity.this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        Button bn = new Button(SecondActivity.this);
        bn.setText("go to Main activity");
        bn.setTextSize(20);
        ll.addView(bn);
        TextView textView = new TextView(SecondActivity.this);
        textView.setText("Activity: "+this.toString()+"\n "+"taskId is: "+this.getTaskId());
        textView.setTextSize(20);
        ll.addView(textView);

        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
