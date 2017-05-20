package com.example.a1.uptogod;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    final static int REQUESTQUESTION_ROTATE =111;
    ImageView question_title_pic;
    TextView question_txt;
    ImageView delete_icon;
    ImageView start_btn;
    RecyclerView answer_txt_recyclerV;
    static String answerStr;
    static int id;
    static String questionStr;
    static String res_pie_pic;
    static String[] answerStrs;
    static int NumOfOne_counts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        question_title_pic = (ImageView) findViewById(R.id.question_title_pic);
        question_txt = (TextView) findViewById(R.id.question_txt);
        answer_txt_recyclerV = (RecyclerView) findViewById(R.id.answer_txt_recyclerV);
        delete_icon = (ImageView) findViewById(R.id.delete_icon);
        start_btn = (ImageView) findViewById(R.id.start_btn);

        start_btn.setOnClickListener(this); //开启旋转界面
        Bundle bundle = this.getIntent().getExtras();
        NumOfOne_counts =bundle.getInt("可选数");
        res_pie_pic = bundle.getString("资源图");
        question_title_pic.setImageResource(getResources().getIdentifier(res_pie_pic,"drawable",getPackageName()));
        id = bundle.getInt("loadId");
        questionStr = bundle.getString("问题");
        question_txt.setText(questionStr);
        answerStr = bundle.getString("答案");
        if(!TextUtils.isEmpty(answerStr)){
            answerStrs = answerStr.split(",");
       }


        delete_icon.setOnClickListener(this);
        AnswerAdapter answerAdapter = new AnswerAdapter(R.layout.recyclerview_loaddetails_choices);
        AnswerAdapter.questionActivity = this;
        answer_txt_recyclerV.setAdapter(answerAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.delete_icon:
                getContentResolver().delete(LoadContentProvider.URI,"question = ?",new String[]{questionStr});
                finish();
                break;
            case R.id.start_btn:
                Intent intent = new Intent(this,RotateActivity.class);
                intent.putExtra("NumOfOne_counts",NumOfOne_counts);
                intent.putExtra("answers",answerStr);
                intent.putExtra("question",questionStr);
                intent.putExtra("resPic",res_pie_pic);
                startActivityForResult(intent,REQUESTQUESTION_ROTATE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUESTQUESTION_ROTATE:
                finish();
                break;
        }
    }
}
