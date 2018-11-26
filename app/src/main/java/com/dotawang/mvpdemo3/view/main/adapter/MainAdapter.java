package com.dotawang.mvpdemo3.view.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.model.main.MainInfo;
import com.dotawang.mvpdemo3.utils.InflateView;
import com.dotawang.mvpdemo3.utils.widget.recyclerview.adapter.BaseRecyclerAdapter;

/**
 * @author Dota.Wang
 * @date 2018/11/26
 * @description
 */

public class MainAdapter extends BaseRecyclerAdapter<MainInfo,MainViewHolder> {
    public MainAdapter(Context context, OnItemClickListener<MainViewHolder> listener) {
        super(context, listener);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainViewHolder(InflateView.inflateLayout(getContext(), R.layout.item_main,viewGroup,false));
    }
}
