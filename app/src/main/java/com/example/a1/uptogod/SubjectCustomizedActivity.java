package com.example.a1.uptogod;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SubjectCustomizedActivity extends AppCompatActivity {
    final static int REQUESTCUSTOMIZED_ROTATE = 110;
    String[] answerStrs;
    ImageView question_title_pic;
    Boolean isAnswerEmpty = true;//check答案或问题是否为空
    Boolean isQuestionEmpty = true;//check答案或问题是否为空
    String resPicStr;
    EditText question_txt;
    TextView save_icon;
    String answerResultStr;
    ImageView start_btn;
    static int countsN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_customized);
        save_icon = (TextView) findViewById(R.id.save_icon);
        question_txt = (EditText) findViewById(R.id.question_txt);
        question_title_pic = (ImageView) findViewById(R.id.question_title_pic);
        countsN = getIntent().getIntExtra("countsNum",2);
        answerStrs = new String[countsN];
        resPicStr = getIntent().getStringExtra("resPic");
//        counts = getIntent().getIntExtra("countsNum",2);
        question_title_pic.setImageResource(getResources().getIdentifier(resPicStr,"drawable",getPackageName()));



        question_txt.addTextChangedListener(new TextWatcher() { //问题文本 监听框
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(question_txt.getText().toString())){
                    isQuestionEmpty = false;
                }else{
                    isQuestionEmpty = true;
                }
            }
        });

            save_icon.setOnClickListener(new View.OnClickListener() { //对保存按钮设置监听事件
            @Override
            public void onClick(View v) {
                checkAvailableForAnswers();
                if(!isAnswerEmpty && !isQuestionEmpty ){
                    saveInfos();
                    Toast.makeText(SubjectCustomizedActivity.this,"内容已保存",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                Toast.makeText(SubjectCustomizedActivity.this,"请输入问题和每个答案！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        RecyclerView answer_txt_recyclerV = (RecyclerView) findViewById(R.id.answer_txt_recyclerV);
        SubjectCustomizedAdapter subjectCustomizedAdapter = new SubjectCustomizedAdapter(R.layout.recyclerview_subject_customized);
        subjectCustomizedAdapter.subjectCustomizedActivity = this;
        answer_txt_recyclerV.setAdapter(subjectCustomizedAdapter);


        start_btn = (ImageView) findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //插入数据并做值传递
                checkAvailableForAnswers();
                if(!isAnswerEmpty && !isQuestionEmpty ){
                    saveInfos();
                    Toast.makeText(SubjectCustomizedActivity.this,"内容已保存并开转",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SubjectCustomizedActivity.this,RotateActivity.class);
                    intent.putExtra("NumOfOne_counts",countsN);//值传递
                    intent.putExtra("question",question_txt.getText().toString());
                    intent.putExtra("resPic",resPicStr);
                    intent.putExtra("answers",answerResultStr);
                    startActivityForResult(intent,REQUESTCUSTOMIZED_ROTATE);

                }else{
                    Toast.makeText(SubjectCustomizedActivity.this,"请先输入问题和每个答案！",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUESTCUSTOMIZED_ROTATE:
                finish();
                break;   }

    }


    private void saveInfos(){ //保存

        StringBuilder sb = new StringBuilder();
        for(int i =0,y=0;i< countsN;i++,y++){
            if(y < countsN -1){
                sb.append(answerStrs[i]+",");
            }else {
                sb.append(answerStrs[i]);
            }
        } answerResultStr = sb.toString();
        ContentValues cv = new ContentValues();
        cv.put("countsNum",countsN);
        cv.put("resPic",resPicStr);
        cv.put("question", question_txt.getText().toString());
        cv.put("answer",answerResultStr);
        getContentResolver().insert(LoadContentProvider.URI,cv);//插入数据
    }


    private void checkAvailableForAnswers(){ //check 答案是否都填写了

        for(int i = 0;i<countsN;i++){
            if(TextUtils.isEmpty(answerStrs[i])){
                isAnswerEmpty = true;
                break;
            }else{
                isAnswerEmpty = false;
            }
        }
    }

}
