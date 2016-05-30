package com.example.yanli.launcheractivity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * Created by binbin on 5/26/2016.
 */
public class MyExpandableActivity extends ExpandableListActivity {


    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter () {
            int[] logos = new int[]{R.drawable.professional_woman_1,
                    R.drawable.professional_woman_2,
            };
            String[] names=new String[]
                    {"Lucy","Lily"};
            String[][] hobbies=new String[][]
                    {{"reading","singing","writing"},
                            {"travelling","reading","food"}
                    };

            public Object getChild(int groupPosition, int childPosition) {

                return hobbies[groupPosition][childPosition];
            }

            public  boolean isChildSelectable(int groupPosition, int childPosition){
                return true;
            };

            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            public int getChildrenCount(int groupPosition) {
                return names.length;
            }

            public View getChildView(int groupPosition, int childPosition, boolean isLastChirld, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(MyExpandableActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }

            public Object getGroup(int groupPosition) {
                return names[groupPosition];
            }

            public int getGroupCount() {
                return names.length;
            }

            public long getGroupId(int groupPostion) {
                return groupPostion;
            }

            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(MyExpandableActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(MyExpandableActivity.this);
                logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            public boolean hasStableIds() {
                return true;
            }

        };

        setListAdapter(adapter);


    }
}
