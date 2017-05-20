package com.example.a1.uptogod;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 1 on 2017/5/4.
 */

public class PointerAdapter extends  UniversalAdapter{
    String [] pointerInfo = SettingsInfo.pointer;
    int mSelected = -1;
    static PointerActivity pointerActivity;

    public PointerAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    @Override
    public void onBindViewHolder(final UniversalHolder holder, int position) {
        final String pointerStr = pointerInfo[position];
        SimpleDraweeView pointer_pic = holder.get(R.id.pointer_pic);
        pointer_pic.setImageURI(Uri.parse("res:///"+holder.itemView.getResources().getIdentifier(pointerStr,"drawable",holder.itemView.getContext().getPackageName())));
        if(position == mSelected){
            pointer_pic.setSelected(true); //被选中
        }else{
            pointer_pic.setSelected(false);//未选中
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {//item的点击事件的监听
            @Override
            public void onClick(View view) {
                /** SP保存Pointer的键对值 **/
                SharedPreferences sharedPreferences = pointerActivity.getSharedPreferences("资源图", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                editor.putString("resPic_pointer",pointerStr );
                editor.apply();//提交修改

                mSelected = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pointerInfo.length;
    }
}
