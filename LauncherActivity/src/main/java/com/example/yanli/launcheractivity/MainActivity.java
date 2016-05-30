package com.example.yanli.launcheractivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import com.example.yanli.launcheractivity.MyExpandableActivity;
import com.example.yanli.launcheractivity.MyPreferenceActivity;

public class MainActivity extends LauncherActivity {
    String[] names ={"Pref_class", "Expan_class"};
    public Class<?>[] clazzs={MyPreferenceActivity.class,MyExpandableActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    public Intent intentForPosition(int position){
        return new Intent(MainActivity.this, clazzs[position]);
    }
}
