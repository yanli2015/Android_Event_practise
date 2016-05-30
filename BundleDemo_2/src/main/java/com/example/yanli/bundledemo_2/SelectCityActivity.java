package com.example.yanli.bundledemo_2;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by binbin on 5/28/2016.
 */
public class SelectCityActivity extends ExpandableListActivity {

    String[] provinces= new String[]
            {"VA","CA","MD"};
    String[][] cities = new String[][]
            {{"Fairfax","Sterling","Manassa","Reston"},{"Los Angeles","San Diego","San Jose","San Francisco"},
                    {" Baltimore","Germantown","Silver Spring"," Frederick"}};
    int[] imageIds = new int[]
            {R.drawable.virginia,  R.drawable.california, R.drawable.maryland };

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            public TextView getTextView(){
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(SelectCityActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setTextSize(20);
                return textView;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(SelectCityActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView  = new ImageView(SelectCityActivity.this);
                imageView.setImageResource(imageIds[groupPosition]);
                ll.addView(imageView);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
               TextView textView = getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = getIntent();
                intent.putExtra("city",cities[groupPosition][childPosition]);
                SelectCityActivity.this.setResult(0, intent);
                SelectCityActivity.this.finish();
                return false;
            }
        });
    }
}
