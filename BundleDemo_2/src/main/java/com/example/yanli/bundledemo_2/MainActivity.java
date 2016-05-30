package com.example.yanli.bundledemo_2;

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

public class MainActivity extends Activity {
    Button bn;
    EditText city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button) findViewById(R.id.bn);
        city = (EditText) findViewById(R.id.city);
        bn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectCityActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0 && resultCode == 0) {
            Bundle data = intent.getExtras();
            String resultCity = data.getString("city");
            city.setText(resultCity);
        }
    }


}
