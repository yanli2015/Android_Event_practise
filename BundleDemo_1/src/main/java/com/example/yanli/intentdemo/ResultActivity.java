package com.example.yanli.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by binbin on 5/27/2016.
 */
public class ResultActivity extends Activity {
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        TextView name = (TextView)findViewById(R.id.name);
        TextView passwd = (TextView)findViewById(R.id.passwd);
        TextView gender = (TextView)findViewById(R.id.gender);

        Intent intent = getIntent();
        Person p = (Person)intent.getSerializableExtra("person");
        name.setText("Your name is "+p.getName());
        passwd.setText("Your password is "+p.getPasswd());
        gender.setText("Your gender is "+p.getGender());

    }
}
