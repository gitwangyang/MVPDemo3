package com.dotawang.mvpdemo3.utils.widget.recyclerview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.utils.ptr.PtrClassicFrameLayout;
import com.dotawang.mvpdemo3.utils.ptr.PtrDefaultHandler;
import com.dotawang.mvpdemo3.utils.ptr.PtrFrameLayout;
import com.dotawang.mvpdemo3.utils.ptr.loadmore.OnLoadMoreListener;
import com.dotawang.mvpdemo3.utils.widget.loadmore.OnScrollToBottomLoadMoreListener;
import com.dotawang.mvpdemo3.utils.widget.recyclerview.divider.RecyclerViewDivider;
import com.dotawang.mvpdemo3.utils.widget.refersh.OnPullToRefreshListener;
import com.dotawang.mvpdemo3.utils.InflateView;


/**
 *
 */

public class PtrRecyclerViewUIComponent extends PtrClassicFrameLayout {

    private boolean canRefresh = true;

    public PtrRecyclerViewUIComponent(Context context) {
        super(context);
    }

    public PtrRecyclerViewUIComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PtrRecyclerViewUIComponent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private RecyclerViewWithEV mRecyclerView;

    private OnScrollToBottomLoadMoreListener mOnScrollToBottomLoadMoreListener;

    private OnPullToRefreshListener mOnPullToRefreshListener;

    public void setOnScrollToBottomLoadMoreListener(OnScrollToBottomLoadMoreListener mOnScrollToBottomLoadMoreListener) {
        this.mOnScrollToBottomLoadMoreListener = mOnScrollToBottomLoadMoreListener;
    }

    public void setOnPullToRefreshListener(OnPullToRefreshListener mOnPullToRefreshListener) {
        this.mOnPullToRefreshListener = mOnPullToRefreshListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerViewWithEV) findViewById(R.id.recyclerview_uicomponent);

        setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mOnPullToRefreshListener.onPullToRefresh();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                if (!canRefresh) {
                    return false;
                }
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);
            }
        });

        setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                mOnScrollToBottomLoadMoreListener.onScrollToBottomLoadMore();
            }
        });
    }

    public <T extends RecyclerView.LayoutManager> void setLayoutManager(T layoutManager) {
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public <T extends RecyclerView.Adapter> void setAdapter(T adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    public void setCanRefresh(boolean canRefresh) {
        this.canRefresh = canRefresh;
    }

    /**
     * 设置emptyView
     *
     * @param emptyView
     */
    public void setEmptyView(View emptyView) {
        mRecyclerView.setEmptyView(emptyView);
    }

    public void setEmptyView(@LayoutRes int emptyResLayout) {
        View emptyView = InflateView.inflateLayout(getContext(), emptyResLayout);
        setEmptyView(emptyView);
    }

    /**
     * 添加分割线
     *
     * @param divider 自定义的分割线
     */
    public void setRecyclerViewDivider(RecyclerViewDivider divider) {
        mRecyclerView.addItemDecoration(divider);
    }

    public void delayRefresh(long delayMillis) {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                autoRefresh();
            }
        }, delayMillis);
    }
}
