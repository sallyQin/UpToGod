package com.example.a1.uptogod;

import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 1 on 2017/5/14.
 */

public class DetailsAdapter extends UniversalAdapter {

    DetailsActivity detailsActivity;
    String answer_txt;
    int mSelected;
    public DetailsAdapter(@LayoutRes int itemRes,int mSelected) {
        super(itemRes);
        this.mSelected = mSelected;
    }

    public DetailsAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    @Override
    public void onBindViewHolder(UniversalHolder holder, int position) {

        if(!TextUtils.isEmpty( detailsActivity.answerStr)){
            answer_txt = detailsActivity.answerStrs[position];
        }
        LinearLayout wholeLine_answers = holder.get(R.id.wholeLine_answers);
        TextView num_choices_txt = holder.get(R.id.num_choices_txt);
        TextView choices_txt = holder.get(R.id.choices_txt);
        TextView selected_slogan = holder.get(R.id.selected_slogan);

        if(position == mSelected -1){
            selected_slogan.setVisibility(View.VISIBLE); //被选中
            selected_slogan.setText("被选中");
            wholeLine_answers.setSelected(true);
        }else{
            selected_slogan.setVisibility(View.INVISIBLE);//未选中
            wholeLine_answers.setSelected(false);
        }
        num_choices_txt.setText((position +1)+ ".");
        choices_txt.setText(answer_txt);

    }

    @Override
    public int getItemCount() {
        return detailsActivity.answerStrs.length;
    }
}
