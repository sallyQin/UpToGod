package com.example.a1.uptogod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout bg_linearL;
    LinearLayout frame_linearL;
    LinearLayout pointer_linearL;
    LinearLayout speed_linearL;
    LinearLayout friction_linearL;
    LinearLayout orientation_linearL;
    SimpleDraweeView bg_icon;
    ImageView frame_icon;
    ImageView pointer_icon;

    final static int REQUEST_BACKGROUND = 5;
    final static int REQUEST_FRAME = 6;
    final static int REQUEST_POINTER= 7;
    final static int REQUEST_SPEED = 8;
    final static int REQUEST_FRICTION = 9;
    final static int REQUEST_ORIENTATION= 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        bg_linearL = (LinearLayout) findViewById(R.id.bg_linearL);
        frame_linearL = (LinearLayout) findViewById(R.id.frame_linearL);
        pointer_linearL = (LinearLayout) findViewById(R.id.pointer_linearL);
        speed_linearL = (LinearLayout) findViewById(R.id.speed_linearL);
        friction_linearL = (LinearLayout) findViewById(R.id.friction_linearL);
        orientation_linearL = (LinearLayout) findViewById(R.id.orientation_linearL);

        bg_icon = (SimpleDraweeView) findViewById(R.id.bg_icon);
        frame_icon = (ImageView) findViewById(R.id.frame_icon);
        pointer_icon = (ImageView) findViewById(R.id.pointer_icon);

        bg_linearL.setOnClickListener(this);//给“背景”设置点击事件
        frame_linearL.setOnClickListener(this);//给“圆框”设置点击事件
        pointer_linearL.setOnClickListener(this);//给“指针”设置点击事件
        speed_linearL.setOnClickListener(this);//给“转速”设置点击事件
        friction_linearL.setOnClickListener(this);//给“摩擦力”设置点击事件
        orientation_linearL.setOnClickListener(this);//给“方向”设置点击事件
        updateBg();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bg_linearL:
                Intent intent1 = new Intent(SettingActivity.this, BackgroundActivity.class);
                startActivityForResult(intent1,REQUEST_BACKGROUND);
                break;
            case R.id.frame_linearL:
                Intent intent2 = new Intent(SettingActivity.this, FrameActivity.class);
                startActivityForResult(intent2,REQUEST_FRAME);
                break;
            case R.id.pointer_linearL:
                Intent intent3 = new Intent(SettingActivity.this, PointerActivity.class);
                startActivityForResult(intent3,REQUEST_POINTER);
                break;
            case R.id.speed_linearL:
                Intent intent4 = new Intent(SettingActivity.this, SpeedActivity.class);
                startActivityForResult(intent4,REQUEST_SPEED);
                break;
            case R.id.friction_linearL:
                Intent intent5 = new Intent(SettingActivity.this, FrictionActivity.class);
                startActivityForResult(intent5,REQUEST_FRICTION);
                break;
            case R.id.orientation_linearL:
                Intent intent6 = new Intent(SettingActivity.this, OrientationActivity.class);
                startActivityForResult(intent6,REQUEST_ORIENTATION);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        updateBg();
    }


    private void updateBg() { //资源图设置
        /** 取SP值 **/
        SharedPreferences sharedPreferences = getSharedPreferences("资源图", Context.MODE_PRIVATE);
        String background_selected_pic = sharedPreferences.getString("resPic_bg","bg" );//记录用户默认 背景图
        String frame_selected_pic = sharedPreferences.getString("resPic_frame","frame1" );//记录用户默认 圆框图
        String pointer_selected_pic = sharedPreferences.getString("resPic_pointer","pointer1" );//记录用户默认 指针图
        bg_icon.setImageURI(Uri.parse("res:///"+getResources().getIdentifier(background_selected_pic,"drawable",this.getPackageName())));
        frame_icon.setImageResource(getResources().getIdentifier(frame_selected_pic,"drawable",this.getPackageName()));
        pointer_icon.setImageResource(getResources().getIdentifier(pointer_selected_pic,"drawable",this.getPackageName()));
    }
}
