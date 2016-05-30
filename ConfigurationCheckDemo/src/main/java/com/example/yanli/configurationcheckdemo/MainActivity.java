package com.example.yanli.configurationcheckdemo;

import android.app.Activity;
import android.content.res.Configuration;
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
    EditText ori, navigation, touch, mnc;
    Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ori=(EditText)findViewById(R.id.ori);

        touch = (EditText)findViewById(R.id.touch);
        mnc = (EditText)findViewById(R.id.mnc);
        bn=(Button)findViewById(R.id.bn1);
        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Configuration cfg = getResources().getConfiguration();
               String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE? "Lanscape":"Portrait";
                ori.setText(screen);
                String mncCode = cfg.mnc+"";
                mnc.setText(mncCode);
              String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH?"Touch Screeen":"Nontouch Screen";
                touch.setText(touchName);

            }
        });

    }
}
