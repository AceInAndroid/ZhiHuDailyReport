package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.SectionListBean;

/**
 * Created by AceInAndroid on 17/4/12.
 */

public interface SectionContract {

    interface View extends BaseView {

        void showContent(SectionListBean sectionListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getSectionData();
    }
}
