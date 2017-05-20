package com.example.a1.uptogod;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.widget.LinearLayout;

public class SpeedActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout normal_linearL;
    LinearLayout fast_linearL;
    LinearLayout slow_linearL;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        normal_linearL = (LinearLayout) findViewById(R.id.normal_linearL);
        fast_linearL = (LinearLayout) findViewById(R.id.fast_linearL);
        slow_linearL = (LinearLayout) findViewById(R.id.slow_linearL);
        normal_linearL.setOnClickListener(this);
        fast_linearL.setOnClickListener(this);
        slow_linearL.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.normal_linearL:
                normal_linearL.setSelected(true);
                fast_linearL.setSelected(false);
                slow_linearL.setSelected(false);
                /** SP保存Speed键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateSpeed","normal" );
                editor.apply();//提交修改
                break;
            case R.id.fast_linearL:
                fast_linearL.setSelected(true);
                normal_linearL.setSelected(false);
                slow_linearL.setSelected(false);
                /** SP保存Speed键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateSpeed","fast" );
                editor.apply();//提交修改
                break;
            case R.id.slow_linearL:
                slow_linearL.setSelected(true);
                fast_linearL.setSelected(false);
                normal_linearL.setSelected(false);
                /** SP保存Speed键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateSpeed","slow" );
                editor.apply();//提交修改
                break;
        }
    }
}
