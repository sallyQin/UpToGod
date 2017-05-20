package com.example.a1.uptogod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button setting_btn;
    Button help_btn;
    Button load_btn;
    SimpleDraweeView customized_turntable_btn;
    TextView customized_label_btn;
    SimpleDraweeView frame_2choices;
    TextView choice2_frame_txt;
    SimpleDraweeView frame_3choices;
    TextView choice3_frame_txt;
    LinearLayout bg;
    static int oneOfN; //可选数字
    final static int REQUEST_SETTING = 2;
    final static int REQUEST_HELP = 3;
    final static int REQUEST_LOAD = 4;
    final static int REQUEST_CUSTOMIZED= 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg = (LinearLayout) findViewById(R.id.bg);//背景图
        updateBg();

        setting_btn = (Button) findViewById(R.id.setting_btn);
        help_btn = (Button) findViewById(R.id.help_btn);
        load_btn = (Button) findViewById(R.id.load_btn);
        customized_turntable_btn = (SimpleDraweeView) findViewById(R.id.customized_turntable_btn);
        customized_label_btn = (TextView) findViewById(R.id.customized_label_btn);
        frame_2choices = (SimpleDraweeView) findViewById(R.id.frame_2choices);
        choice2_frame_txt = (TextView) findViewById(R.id.choice2_frame_txt);
        frame_3choices = (SimpleDraweeView) findViewById(R.id.frame_3choices);
        choice3_frame_txt = (TextView) findViewById(R.id.choice3_frame_txt);
        setting_btn.setOnClickListener(this);
        help_btn.setOnClickListener(this);
        load_btn.setOnClickListener(this);
        customized_turntable_btn.setOnClickListener(this);
        customized_label_btn.setOnClickListener(this);
        frame_2choices.setOnClickListener(this);
        choice2_frame_txt.setOnClickListener(this);
        frame_3choices.setOnClickListener(this);
        choice3_frame_txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == setting_btn){ //跳转到"设置"界面
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivityForResult(intent,REQUEST_SETTING );
        }else if(view == help_btn){ //跳转到"帮助"界面
            Intent intent = new Intent(MainActivity.this,HelpActivity.class);
            startActivityForResult(intent,REQUEST_HELP );
        }else if (view == load_btn){ //跳转到"加载"界面(所有保存的抉择)
            oneOfN = 50;
            Intent intent = new Intent(MainActivity.this,LoadActivity.class);
            startActivityForResult(intent,REQUEST_LOAD);
        }else if(view  == customized_turntable_btn || view  == customized_label_btn ){//跳转到"自定义"界面
            Intent intent = new Intent(MainActivity.this,CustomizedActivity.class);
            startActivityForResult(intent,REQUEST_CUSTOMIZED);
        }else if(view == frame_2choices || (view == choice2_frame_txt)){//跳转到所有"2选1"界面
            oneOfN = 2;
            Intent intent = new Intent(MainActivity.this,LoadActivity.class);
            startActivityForResult(intent,REQUEST_LOAD);
        }else if(view == frame_3choices || (view == choice3_frame_txt)){//跳转到所有"3选1"界面
            oneOfN = 3;
            Intent intent = new Intent(MainActivity.this,LoadActivity.class);
            startActivityForResult(intent,REQUEST_LOAD);
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
        String frame_pic = sharedPreferences.getString("resPic_frame","frame1" );//记录用户默认 圆框图
        String pointer_pic = sharedPreferences.getString("resPic_pointer","pointer1" );//记录用户默认 指针图
        bg.setBackgroundResource(getResources().getIdentifier(background_selected_pic,"drawable",this.getPackageName()));
    }
}
