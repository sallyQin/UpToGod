package com.example.a1.uptogod;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class OrientationActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout clockwise;
    LinearLayout antiClockwise;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        clockwise = (LinearLayout) findViewById(R.id.clockwise);
        antiClockwise = (LinearLayout) findViewById(R.id.antiClockwise);
        clockwise.setOnClickListener(this);
        antiClockwise.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.clockwise:
                clockwise.setSelected(true);
                antiClockwise.setSelected(false);
                /** SP保存Direction键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateDirection","clockwise" );
                editor.apply();//提交修改
                break;
            case R.id.antiClockwise:
                antiClockwise.setSelected(true);
                clockwise.setSelected(false);
                /** SP保存Direction键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateDirection","antiClockwise" );
                editor.apply();//提交修改
                break;
        }
    }
}
