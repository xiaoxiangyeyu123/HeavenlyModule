package com.xusangbo.basemoudle.base;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.xusangbo.basemodule.R;
import com.xusangbo.basemoudle.widght.baseadapter.BaseQuickAdapter;
import com.xusangbo.basemoudle.widght.baseadapter.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boxu on 2017/4/1.
 */

public abstract class BaseListFragment<T extends BasePresenter, E extends BaseModel,Z> extends BaseFragment {
    private static final String TAG = "BaseListFragment";

    /**
     * 普通list布局
     */
    protected static final int LINEAR_LAYOUT_MANAGER = 0;
    /**
     * grid布局
     */
    protected static final int GRID_LAYOUT_MANAGER = 1;
    /**
     * 瀑布流布局
     */
    protected static final int STAGGERED_GRID_LAYOUT_MANAGER = 2;


    /**
     * 默认为0单行布局
     */
    private int mListType = 0;
    /**
     * 排列方式默认垂直
     */
    private boolean mIsVertical = true;
    /**
     * grid布局与瀑布流布局默认行数
     */
    private int mSpanCount = 1;


    protected RecyclerView mRecyclerView;

    protected ListAdapter mAdapter;
    /**
     * 子布局id
     */
    private int layoutResId = -1;


    @Override
    protected void initView() {
        initItemLayout();
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.base_list);
        chooseListType(mListType, mIsVertical);
        if (-1 == layoutResId) {
            throw new RuntimeException("layoutResId is null!");
        }
        mAdapter = new ListAdapter(layoutResId, new ArrayList<Z>());
        mRecyclerView.setAdapter(mAdapter);

    }


    /**
     * 设置子布局layout
     *
     * @param layoutResId 子布局layout
     */
    public void setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
    }

    /**
     * 初始化子布局
     * 在这个方法里处理的是recyclerview的所有的初始化，
     * 包括对他的展示形式，是list或grid或瀑布流
     */
    protected abstract void initItemLayout();

    /**
     * 是否打开加载更多
     */
    protected void openLoadMoreSize(boolean loadMore) {
        mAdapter.loadMoreEnd(loadMore);
    }

    /**
     * @param type       布局管理type
     * @param isVertical 是否是垂直的布局 ，true垂直布局，false横向布局
     */
    protected void setListType(int type, boolean isVertical) {
        mListType = type;
        mIsVertical = isVertical;
    }

    /**
     * 为grid样式和瀑布流设置横向或纵向数量
     *
     * @param spanCount 数量
     */
    protected void setSpanCount(int spanCount) {
        if (spanCount > 0)
            mSpanCount = spanCount;
    }

    /**
     * @param listType 选择布局种类
     */
    private void chooseListType(int listType, boolean isVertical) {
        switch (listType) {
            case LINEAR_LAYOUT_MANAGER:
                //设置布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                linearLayoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

                mRecyclerView.setLayoutManager(linearLayoutManager);
                break;
            case GRID_LAYOUT_MANAGER:

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), mSpanCount);

                gridLayoutManager.setOrientation(isVertical ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);

                mRecyclerView.setLayoutManager(gridLayoutManager);
                break;
            case STAGGERED_GRID_LAYOUT_MANAGER:
                //设置布局管理器
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                        (mSpanCount, isVertical ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);

                mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
            default:
                //设置布局管理器
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

                layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

                mRecyclerView.setLayoutManager(layoutManager);
                break;
        }
    }

    /**
     * adapter内的处理
     *
     * @param baseViewHolder BaseViewHolder
     * @param t              泛型T
     */
    protected abstract void MyHolder(BaseViewHolder baseViewHolder, Z t);


    public class ListAdapter extends BaseQuickAdapter<Z, BaseViewHolder> {

        public ListAdapter(int layoutResId, List<Z> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, Z t) {
            MyHolder(baseViewHolder, t);
        }
    }

}