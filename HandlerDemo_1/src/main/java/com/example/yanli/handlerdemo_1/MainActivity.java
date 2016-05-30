package com.example.yanli.handlerdemo_1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
int[] imageIds = new int[]{
        R.drawable.professional_woman_1,
        R.drawable.professional_woman_2,
        R.drawable.professional_woman_3,
        R.drawable.professional_woman_4,
};
    int currentImageId = 0;
    ImageView  show;

  final private Handler handler=  new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == 12){
                show.setImageResource(imageIds[currentImageId++%imageIds.length]);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       show= (ImageView)findViewById(R.id.show1);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(12);}
            },0,1200);

    }
}
