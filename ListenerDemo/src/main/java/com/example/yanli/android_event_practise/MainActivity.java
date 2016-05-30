package com.example.yanli.android_event_practise;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;

public class MainActivity extends Activity {
    private int speed = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.night_sky);
        WindowManager windowManager = getWindowManager();
       Display display= windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currentX=metrics.widthPixels /2;
        planeView.currentY=metrics.heightPixels - 40;

        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch(event.getKeyCode()){
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY -= speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX -= speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX += speed;
                        break;

                }
                planeView.invalidate();
                return true;
            }



        });



    }
}
