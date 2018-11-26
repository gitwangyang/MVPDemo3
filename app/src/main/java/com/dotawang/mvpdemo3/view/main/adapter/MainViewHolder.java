package com.dotawang.mvpdemo3.view.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.model.main.MainInfo;
import com.dotawang.mvpdemo3.utils.ImageLoader;
import com.dotawang.mvpdemo3.utils.widget.recyclerview.adapter.BaseRecyclerViewHolder;

/**
 * @author Dota.Wang
 * @date 2018/11/26
 * @description
 */

public class MainViewHolder extends BaseRecyclerViewHolder<MainInfo>{
    private ImageView ivAvatar;
    private TextView tvTitle;
    private TextView tvContent;

    public MainViewHolder(View view) {
        super(view);
        ivAvatar = findView(R.id.im_iv_avatar);
        tvTitle = findView(R.id.im_tv_title);
        tvContent = findView(R.id.im_tv_content);
    }

    @Override
    protected void onItemDataUpdated(@Nullable MainInfo mainInfo) {
        if (null != mainInfo) {
            ImageLoader.loadImage(mainInfo.getArticlePic(), ivAvatar);
            tvTitle.setText(String.valueOf(mainInfo.getArticleTitle()));
            tvContent.setText(String.valueOf(mainInfo.getArticleContent()));
        }
    }
}
