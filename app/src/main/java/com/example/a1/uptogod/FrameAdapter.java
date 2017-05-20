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
 * Created by 1 on 2017/5/3.
 */

public class FrameAdapter extends UniversalAdapter {

    int mSelected =-1;
    static FrameActivity frameActivity;

    public FrameAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    @Override
    public void onBindViewHolder(final UniversalHolder holder, int position) {
        final String frameStr = SettingsInfo.frame[position];
        SimpleDraweeView frame_pic = holder.get(R.id.frame_pic);
        Uri uri = Uri.parse("res:///"+holder.itemView.getResources().getIdentifier(frameStr,"drawable",holder.itemView.getContext().getPackageName()));
        if(position == mSelected){  //若被选中，图片做灰度处理
            frame_pic.setController(Fresco.newDraweeControllerBuilder()
                    .setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setPostprocessor(new GrayProcessor(uri)).build())
                    .build());
             frame_pic.setSelected(true);

        }else{
            frame_pic.setImageURI(uri);//不被选中的状态
            frame_pic.setSelected(false);
        }
        frame_pic.setImageURI(uri);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** SP保存Frame的键对值 **/
                SharedPreferences sharedPreferences = frameActivity.getSharedPreferences("资源图", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                editor.putString("resPic_frame",frameStr );
                editor.apply();//提交修改

                mSelected = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return SettingsInfo.frame.length;
    }


}
