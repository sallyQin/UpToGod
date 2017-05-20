package com.example.a1.uptogod;

import android.support.annotation.LayoutRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 1 on 2017/5/7.
 */

public class SubjectCustomizedAdapter extends UniversalAdapter {


    static EditText choices_txt;
    SubjectCustomizedActivity subjectCustomizedActivity;



    public SubjectCustomizedAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    @Override
    public void onBindViewHolder(final UniversalHolder holder, int position) {

        TextView  num_choices_txt = holder.get(R.id.num_choices_txt);
        num_choices_txt.setText((position + 1)+".");
        choices_txt =holder.get(R.id.choices_txt);

        choices_txt.addTextChangedListener(new TextWatcher() { //监听文本监听事件
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (TextUtils.isEmpty(s.toString())) {
                    subjectCustomizedActivity.answerStrs[holder.getAdapterPosition()] = "";
                } else {
                    subjectCustomizedActivity.answerStrs[holder.getAdapterPosition()] = s.toString();//把当前的editText记录下来
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return SubjectCustomizedActivity.countsN;
    }

}
