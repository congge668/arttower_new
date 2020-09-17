package com.example.arttower.fragment.CoursePage.view.tabfragmetn;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arttower.R;

public class ClassisfyActivity extends AppCompatActivity {
    private String mNames[] = {
            "古典舞", "芭蕾舞", "名族舞",
            "民间舞", "现代舞", "网红舞",
            "独舞"
    };
    private XCFlowLayout mFlowlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classisfy);
        initView();
    }

    private void initView() {
        mFlowlayout = (XCFlowLayout) findViewById(R.id.flowlayout);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for(int i = 0; i < mNames.length; i ++){
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_button_circular));
            mFlowlayout.addView(view,lp);
        }


    }

}