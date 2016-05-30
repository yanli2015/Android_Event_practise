package com.example.yanli.overwriteonconfigurationchanged;

import android.app.Activity;
import android.content.pm.ActivityInfo;
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
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration configuration = getResources().getConfiguration();
                if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }}
        });

    }
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
       String screen =  newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ?"Landscape":"portrait";
        Toast.makeText(this, "orientation of this screen has been changed. "+"\n After changing, the orientation of screen is "+screen, Toast.LENGTH_SHORT).show();
    }


}
