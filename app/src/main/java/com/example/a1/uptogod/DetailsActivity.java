package com.example.a1.uptogod;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView question_title_pic;
    TextView question_txt;
    RecyclerView answer_txt_recyclerV;
    String answerStr;
    String[] answerStrs;
    int pointerResultStr;
    ImageView return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        return_btn = (ImageView) findViewById(R.id.return_btn);
        question_title_pic = (ImageView) findViewById(R.id.question_title_pic);
        question_title_pic.setImageResource(getResources().getIdentifier(getIntent().getStringExtra("resPic"),"drawable",getPackageName()));
        question_txt = (TextView) findViewById(R.id.question_txt);
        question_txt.setText(getIntent().getStringExtra("question"));
        answer_txt_recyclerV = (RecyclerView) findViewById(R.id.answer_txt_recyclerV);
        return_btn.setOnClickListener(this); //返回按钮的事件监听
        answerStr = this.getIntent().getStringExtra("answers");
        pointerResultStr = this.getIntent().getIntExtra("指针结果",2);   //获取指针结果
        if(!TextUtils.isEmpty(answerStr)){
            answerStrs = answerStr.split(",");
        }

        DetailsAdapter detailsAdapter = new DetailsAdapter(R.layout.recyclerview_answer_selected,pointerResultStr);
        detailsAdapter.detailsActivity = this;
        answer_txt_recyclerV.setAdapter(detailsAdapter);

    }


    @Override
    public void onClick(View v) {
        finish();
    }


}
