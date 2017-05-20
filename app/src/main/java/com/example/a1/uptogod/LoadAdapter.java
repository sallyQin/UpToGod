package com.example.a1.uptogod;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.util.List;

/**
 * Created by 1 on 2017/4/30.
 */

class LoadAdapter extends RecyclerView.Adapter implements LoaderManager.LoaderCallbacks {
    Cursor cursor;
    final static int REQUEST_QUESTION = 11;
    static  LoadActivity loadActivity;

    LoadAdapter() {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = ((Activity) (parent.getContext())).getLayoutInflater().inflate(R.layout.recyclerview_load_question,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        final String resPicStr =  cursor.getString(cursor.getColumnIndex("resPic"));
        final String questionStr =  cursor.getString(cursor.getColumnIndex("question"));
        final int countsNumInt =  cursor.getInt(cursor.getColumnIndex("countsNum"));
        final String answerStr =  cursor.getString(cursor.getColumnIndex("answer"));
        final int idInt =  cursor.getInt(cursor.getColumnIndex("loadId"));

         ((ImageView) holder.itemView.findViewById(R.id.bg_load)).setImageResource(holder.itemView.getResources().getIdentifier(resPicStr,"drawable",holder.itemView.getContext().getPackageName()));
         ((TextView) holder.itemView.findViewById(R.id.txt_load)).setText(questionStr);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loadActivity,QuestionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("可选数",countsNumInt);
                bundle.putString("资源图", resPicStr);
                bundle.putString("问题", questionStr);
                bundle.putString("答案", answerStr);
                bundle.putInt("loadId", idInt);

                intent.putExtras(bundle);
                loadActivity.startActivityForResult(intent,REQUEST_QUESTION);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
          CursorLoader cursorLoader = new CursorLoader(loadActivity);
        if (MainActivity.oneOfN == 50) {
            cursorLoader = new CursorLoader(loadActivity, LoadContentProvider.URI, null, null, null, "countsNum");//所有信息，并按N选1的数字大小来排序
        } else if (MainActivity.oneOfN == 2) {
            cursorLoader =  new CursorLoader(loadActivity, LoadContentProvider.URI, null, "countsNum = ?", new String[]{"2"}, "countsNum");//所有2选1的信息
        } else if (MainActivity.oneOfN == 3) {
            cursorLoader =  new CursorLoader(loadActivity, LoadContentProvider.URI, null, "countsNum = ?", new String[]{"3"}, "countsNum");//所有3选1的信息
        }
        return cursorLoader;
    }
    @Override
    public void onLoadFinished(Loader loader, Object data) {
        if (cursor != data) {
            if (cursor != null) {
                cursor.close();
            }
            cursor = (Cursor) data;
        }
        notifyDataSetChanged();
    }
    @Override
    public void onLoaderReset(Loader loader) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
