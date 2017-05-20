package com.example.a1.uptogod;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 1 on 2017/5/2.
 */

public abstract class UniversalAdapter extends RecyclerView.Adapter<UniversalHolder> {

    private int mItemRes;


    public UniversalAdapter(@LayoutRes int itemRes) {
        mItemRes = itemRes;
    }

    @Override
    public UniversalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mItemRes, parent, false);
        UniversalHolder universalHolder = new UniversalHolder(view);
        view.setTag(universalHolder);
        // view.setOnClickListener(this);
        return universalHolder;
    }

}