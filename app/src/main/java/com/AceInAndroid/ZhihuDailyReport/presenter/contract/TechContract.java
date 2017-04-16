package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GankItemBean;
import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;

import java.util.List;

/**
 * Created by AceInAndroid on 17/4/20.
 */

public interface TechContract {

    interface View extends BaseView {

        void showContent(List<GankItemBean> mList);

        void showMoreContent(List<GankItemBean> mList);

        void showGirlImage(String url, String copyright);
    }

    interface Presenter extends BasePresenter<View> {

        void getGankData(String tech, int type);

        void getMoreGankData(String tech);

        void getGirlImage();

    }
}
