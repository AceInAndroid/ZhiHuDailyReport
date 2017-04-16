package com.AceInAndroid.ZhihuDailyReport.presenter;

import com.AceInAndroid.ZhihuDailyReport.base.RxPresenter;
import com.AceInAndroid.ZhihuDailyReport.model.db.RealmHelper;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.LikeContract;

import javax.inject.Inject;

/**
 * Created by AceInAndroid on 2017/4/23.
 */
public class LikePresenter extends RxPresenter<LikeContract.View> implements LikeContract.Presenter{

    private RealmHelper mRealmHelper;

    @Inject
    public LikePresenter(RealmHelper mRealmHelper) {
        this.mRealmHelper = mRealmHelper;
    }

    @Override
    public void getLikeData() {
        mView.showContent(mRealmHelper.getLikeList());
    }

    @Override
    public void deleteLikeData(String id) {
        mRealmHelper.deleteLikeBean(id);
    }

    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        mRealmHelper.changeLikeTime(id,time,isPlus);
    }
}
