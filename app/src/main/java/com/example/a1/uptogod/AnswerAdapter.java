package com.example.a1.uptogod;

import android.content.ContentValues;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 1 on 2017/5/5.
 */

public class AnswerAdapter extends UniversalAdapter {
    static  QuestionActivity questionActivity;

    public AnswerAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    String answer_txt;
    @Override
    public void onBindViewHolder(final UniversalHolder holder, final int position) {
        if(!TextUtils.isEmpty( QuestionActivity.answerStr)){
            answer_txt = questionActivity.answerStrs[position];
        }


        final TextView num_choices = holder.get(R.id.num_choices_txt);
        final EditText choices_txt = holder.get(R.id.choices_txt);
        ImageView modify_icon_btn = holder.get(R.id.modify_icon);

        num_choices.setText((position +1)+ ".");
        choices_txt.setText(answer_txt);
        modify_icon_btn.setOnClickListener(new View.OnClickListener() { //修改 按钮的监听事件
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                if(choices_txt.isEnabled()){
                    String userEditTxt = choices_txt.getText().toString();
                    if(!TextUtils.isEmpty( QuestionActivity.answerStr)){
                    QuestionActivity.answerStrs[position] = userEditTxt;
                    for(int i =0,y=0;i< QuestionActivity.NumOfOne_counts;i++,y++){
                        if(y < QuestionActivity.NumOfOne_counts -1){
                            sb.append(QuestionActivity.answerStrs[i]+",");
                        }else {
                            sb.append(QuestionActivity.answerStrs[i]);
                        }
                    }
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("answer",sb.toString());
                    QuestionActivity.answerStr = sb.toString();
                    questionActivity.getContentResolver().update(LoadContentProvider.URI,contentValues,"loadId = ?",new String[]{""+ QuestionActivity.id});
                            choices_txt.setEnabled(false);
                }else{
                        choices_txt.setEnabled(true);
                    }
                }

        });
    }

    @Override
    public int getItemCount() {
        return QuestionActivity.NumOfOne_counts;
    }
}
