package com.example.a1.uptogod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomizedActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout twoOfN;
    LinearLayout threeOfN;
    LinearLayout fourOfN;
    LinearLayout fiveOfN;
    LinearLayout sixOfN;
    LinearLayout sevenOfN;
    LinearLayout eightOfN;
    LinearLayout nineOfN;
    LinearLayout tenOfN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized);
        twoOfN = (LinearLayout) findViewById(R.id.twoOfN);
        threeOfN = (LinearLayout) findViewById(R.id.threeOfN);
        fourOfN = (LinearLayout) findViewById(R.id.fourOfN);
        fiveOfN = (LinearLayout) findViewById(R.id.fiveOfN);
        sixOfN = (LinearLayout) findViewById(R.id.sixOfN);
        sevenOfN = (LinearLayout) findViewById(R.id.sevenOfN);
        eightOfN = (LinearLayout) findViewById(R.id.eightOfN);
        nineOfN = (LinearLayout) findViewById(R.id.nineOfN);
        tenOfN = (LinearLayout) findViewById(R.id.tenOfN);
        twoOfN.setOnClickListener(this);
        threeOfN.setOnClickListener(this);
        fourOfN.setOnClickListener(this);
        fiveOfN.setOnClickListener(this);
        sixOfN.setOnClickListener(this);
        sevenOfN.setOnClickListener(this);
        eightOfN.setOnClickListener(this);
        nineOfN.setOnClickListener(this);
        tenOfN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CustomizedActivity.this,SubjectCustomizedActivity.class);
       if(v == twoOfN ){
           intent.putExtra("resPic","choices2_pie");
           intent.putExtra("countsNum",2);

       }else if(v == threeOfN ){
           intent.putExtra("resPic","choices3_pie");
           intent.putExtra("countsNum",3);
       }else if(v ==  fourOfN ){
            intent.putExtra("resPic","choices4_pie");
            intent.putExtra("countsNum",4);
        }else if(v ==  fiveOfN ){
           intent.putExtra("resPic","choices5_pie");
           intent.putExtra("countsNum",5);
       }else if(v ==  sixOfN ){
           intent.putExtra("resPic","choices6_pie");
           intent.putExtra("countsNum",6);
       }else if(v ==  sevenOfN ){
           intent.putExtra("resPic","choices7_pie");
           intent.putExtra("countsNum",7);
       }else if(v ==  eightOfN ){
           intent.putExtra("resPic","choices8_pie");
           intent.putExtra("countsNum",8);
       }else if(v ==  nineOfN ){
           intent.putExtra("resPic","choices9_pie");
           intent.putExtra("countsNum",9);
       }else if(v ==  tenOfN ){
           intent.putExtra("resPic","choices10_pie");
           intent.putExtra("countsNum",10);
       }
       startActivity(intent);
    }

    }

