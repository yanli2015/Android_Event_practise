package com.example.yanli.intentdemo;

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
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText name = (EditText)findViewById(R.id.name);
                EditText passwd=(EditText)findViewById(R.id.password);
                RadioButton male = (RadioButton)findViewById(R.id.male);
                String gender = male.isChecked()?"male":"female";
                Person p = new Person(name.getText().toString(), passwd.getText().toString(),gender);
                Bundle data=new Bundle();
                data.putSerializable("person",p);
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}
