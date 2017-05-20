package com.example.a1.uptogod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

public class RotateActivity extends AppCompatActivity {
    static final int REQUEST_DETAILS = 130;
    LinearLayout rotate_bg;
    SimpleDraweeView frame;
    MyRotateView myRotateView;
    static String background_selected_pic;
    static String pointer_pic;
    static String frame_pic;
    static String rotate_speed;
    static String rotate_friction;
    static String rotate_direction;
    static long rotate_sleepTime;
    static float friction_rotate_angle;
    int count_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        rotate_bg = (LinearLayout) findViewById(R.id.rotate_bg);
        frame = (SimpleDraweeView) findViewById(R.id.frame);
        myRotateView = (MyRotateView) findViewById(R.id.rotate_pie);
        count_num = getIntent().getIntExtra("NumOfOne_counts",2);
        MyRotateView.rotateActivity = this;
        updateBg();
    }

    private void updateBg() { //提取资源图设置
        /** 取SP值 **/
        SharedPreferences sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
        background_selected_pic = sharedPreferences.getString("resPic_bg","bg" );//记录用户默认/选择 背景图
        frame_pic = sharedPreferences.getString("resPic_frame","frame1" );//记录用户默认/选择 圆框图
        pointer_pic = sharedPreferences.getString("resPic_pointer","pointer1" );//记录用户默认/选择 指针图
        rotate_speed = sharedPreferences.getString("res_rotateSpeed","normal" );//记录用户默认/选择 转速；
        rotate_friction = sharedPreferences.getString("res_rotateFriction","medium" );//记录用户默认/选择 摩擦力；
        rotate_direction = sharedPreferences.getString("res_rotateDirection","clockwise" );//记录用户默认/选择 指针转向；

        rotate_bg.setBackgroundResource(getResources().getIdentifier(background_selected_pic,"drawable",this.getPackageName()));
        frame.setImageURI(Uri.parse("res:///"+ getResources().getIdentifier(frame_pic,"drawable",getPackageName())));
        setSpeed();
        setFriction();
    }

    private void setSpeed(){//设置“转速”
        if(rotate_speed.equals("normal")){//正常速度
            rotate_sleepTime = 4;
        }else if(rotate_speed.equals("fast")){//加速
            rotate_sleepTime = 2;
        }else if(rotate_speed.equals("slow")){//慢速
            rotate_sleepTime = 7;
        }
    }

    private void setFriction(){//设置“摩擦力”
        if(RotateActivity.rotate_friction.equals("medium")){//中度
            friction_rotate_angle = 1.5f;
        }else if(RotateActivity.rotate_friction.equals("low")){//低度
            friction_rotate_angle = 2.3f;
        }else if(RotateActivity.rotate_friction.equals("high")){//高度
            friction_rotate_angle = 1f;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_DETAILS){
            finish();
        }

    }

}
