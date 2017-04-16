package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.model.bean.SectionChildListBean;

/**
 * Created by AceInAndroid on 17/4/28.
 */

public interface SectionChildContract {

    interface View extends BaseView {

        void showContent(SectionChildListBean sectionChildListBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getThemeChildData(int id);

        void insertReadToDB(int id);
    }
}
