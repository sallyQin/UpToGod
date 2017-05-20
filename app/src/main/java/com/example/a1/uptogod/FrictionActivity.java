package com.example.a1.uptogod;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FrictionActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout medium_friction;
    LinearLayout low_friction;
    LinearLayout high_friction;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friction);
        medium_friction = (LinearLayout) findViewById(R.id.medium_friction);
        low_friction = (LinearLayout) findViewById(R.id.low_friction);
        high_friction = (LinearLayout) findViewById(R.id.high_friction);
        medium_friction.setOnClickListener(this);
        low_friction.setOnClickListener(this);
        high_friction.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.medium_friction:
                medium_friction.setSelected(true);
                low_friction.setSelected(false);
                high_friction.setSelected(false);
                /** SP保存friction键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateFriction","medium" );
                editor.apply();//提交修改
                break;
            case R.id.low_friction:
                low_friction.setSelected(true);
                medium_friction.setSelected(false);
                high_friction.setSelected(false);
                /** SP保存friction键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateFriction","low" );
                editor.apply();//提交修改
                break;
            case R.id.high_friction:
                high_friction.setSelected(true);
                medium_friction.setSelected(false);
                low_friction.setSelected(false);
                /** SP保存friction键对值 **/
                sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();//获取编辑器
                editor.putString("res_rotateFriction","high" );
                editor.apply();//提交修改
                break;
        }
    }
}
