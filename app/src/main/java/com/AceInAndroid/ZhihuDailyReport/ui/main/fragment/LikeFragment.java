package com.AceInAndroid.ZhihuDailyReport.ui.main.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.AceInAndroid.ZhihuDailyReport.base.BaseFragment;
import com.AceInAndroid.ZhihuDailyReport.model.bean.RealmLikeBean;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.LikeContract;
import com.AceInAndroid.ZhihuDailyReport.ui.main.adapter.LikeAdapter;
import com.AceInAndroid.ZhihuDailyReport.util.SharedPreferenceUtil;
import com.AceInAndroid.ZhihuDailyReport.util.SnackbarUtil;
import com.AceInAndroid.ZhihuDailyReport.widget.DefaultItemTouchHelpCallback;
import com.AceInAndroid.ZhihuDailyReport.R;
import com.AceInAndroid.ZhihuDailyReport.presenter.LikePresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by AceInAndroid on 17/4/23.
 */

public class LikeFragment extends BaseFragment<LikePresenter> implements LikeContract.View {

    @BindView(R.id.rv_like_list)
    RecyclerView rvLikeList;

    LikeAdapter mAdapter;
    List<RealmLikeBean> mList;
    DefaultItemTouchHelpCallback mCallback;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_like;
    }

    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        mAdapter = new LikeAdapter(mContext, mList);
        rvLikeList.setLayoutManager(new LinearLayoutManager(mContext));
        rvLikeList.setAdapter(mAdapter);
        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
                // 滑动删除的时候，从数据库、数据源移除，并刷新UI
                if (mList != null) {
                    mPresenter.deleteLikeData(mList.get(adapterPosition).getId());
                    mList.remove(adapterPosition);
                    mAdapter.notifyItemRemoved(adapterPosition);
                }
            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mList != null) {
                    // 更换数据库中的数据Item的位置
                    boolean isPlus = srcPosition < targetPosition;
                    mPresenter.changeLikeTime(mList.get(srcPosition).getId(),mList.get(targetPosition).getTime(),isPlus);
                    // 更换数据源中的数据Item的位置
                    Collections.swap(mList, srcPosition, targetPosition);
                    // 更新UI中的Item的位置，主要是给用户看到交互效果
                    mAdapter.notifyItemMoved(srcPosition, targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(true);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(rvLikeList);
        mPresenter.getLikeData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            mPresenter.getLikeData();
            if (!SharedPreferenceUtil.getLikePoint()) {
                SnackbarUtil.show(rvLikeList,"支持侧滑删除，长按拖曳哦(。・`ω´・)");
                SharedPreferenceUtil.setLikePoint(true);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isInited) {
            mPresenter.getLikeData();
        }
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.showShort(getActivity().getWindow().getDecorView(),msg);
    }

    @Override
    public void showContent(List<RealmLikeBean> list) {
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
