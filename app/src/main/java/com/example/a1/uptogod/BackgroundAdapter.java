package com.example.a1.uptogod;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by 1 on 2017/5/2.
 */

public class BackgroundAdapter extends UniversalAdapter {
    static BackgroundActivity backgroundActivity;
    int mSelected = -1;

    public BackgroundAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    @Override
    public void onBindViewHolder(final UniversalHolder holder, int position) {
        final String backgroundStr = SettingsInfo.backgroundStr[position];
        SimpleDraweeView bg_pic = holder.get(R.id.bg_pic);
        Uri uri = Uri.parse("res:///"+holder.itemView.getResources().getIdentifier(backgroundStr,"drawable",holder.itemView.getContext().getPackageName()));
        if(position == mSelected){  //若被选中，图片做灰度处理
            bg_pic.setController(Fresco.newDraweeControllerBuilder()
                    .setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setPostprocessor(new GrayProcessor(uri)).build())
                    .build());
            bg_pic.setSelected(true);

        }else{
            bg_pic.setImageURI(uri);//不被选中的状态
            bg_pic.setSelected(false);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() { //设置 图片点击 事件监听器
            @Override
            public void onClick(final View view) {
                /** SP保存Background键对值 **/
                SharedPreferences sharedPreferences = backgroundActivity.getSharedPreferences("资源图", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                editor.putString("resPic_bg",backgroundStr );
                editor.apply();//提交修改


                mSelected = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return SettingsInfo.backgroundStr.length;
    }

}
