package com.example.yanli.launcheractivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by binbin on 5/26/2016.
 */
public class MyPreferenceActivity extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasHeaders()) {
            Button button = new Button(this);
            button.setText("Preference Button");
            setListFooter(button);
        }
    }


    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    public boolean isValidFragment(String fragmentName){
        return true;
    }
public static class Prefs1Fragment extends PreferenceFragment {
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);
        }
    }

    public static class Prefer2Fragment extends Prefs1Fragment{
        public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.display_prefs);
            String website = getArguments().getString("website");
            Toast.makeText(getActivity(),"Website ip is "+website, Toast.LENGTH_LONG).show();
    }
    }
}
