package com.dotawang.mvpdemo3.utils.ptr.loadmore;

import android.view.View;
import android.view.View.OnClickListener;


public interface ViewHandler {

	/**
	 * 
	 * @param contentView
	 * @param loadMoreView
	 * @param onClickLoadMoreListener
	 * @return 是否有 initJPush ILoadMoreView
	 */
	public boolean handleSetAdapter(View contentView, ILoadMoreViewFactory.ILoadMoreView loadMoreView, OnClickListener onClickLoadMoreListener);

	public void setOnScrollBottomListener(View contentView, OnScrollBottomListener onScrollBottomListener);

}
