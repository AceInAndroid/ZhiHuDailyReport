package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.RealmLikeBean;

import java.util.List;

/**
 * Created by AceInAndroid on 2017/4/23.
 */
public interface LikeContract {

    interface View extends BaseView {

        void showContent(List<RealmLikeBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getLikeData();

        void deleteLikeData(String id);

        void changeLikeTime(String id,long time,boolean isPlus);
    }
}
