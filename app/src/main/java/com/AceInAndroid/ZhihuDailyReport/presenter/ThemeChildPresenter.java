package com.AceInAndroid.ZhihuDailyReport.presenter;

import com.AceInAndroid.ZhihuDailyReport.base.RxPresenter;
import com.AceInAndroid.ZhihuDailyReport.model.db.RealmHelper;
import com.AceInAndroid.ZhihuDailyReport.model.http.RetrofitHelper;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.ThemeChildContract;
import com.AceInAndroid.ZhihuDailyReport.util.RxUtil;
import com.AceInAndroid.ZhihuDailyReport.model.bean.ThemeChildListBean;
import com.AceInAndroid.ZhihuDailyReport.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * Created by AceInAndroid on 17/4/24.
 */

public class ThemeChildPresenter extends RxPresenter<ThemeChildContract.View> implements ThemeChildContract.Presenter {

    private RetrofitHelper mRetrofitHelper;
    private RealmHelper mRealmHelper;

    @Inject
    public ThemeChildPresenter(RetrofitHelper mRetrofitHelper, RealmHelper mRealmHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
        this.mRealmHelper = mRealmHelper;
    }

    @Override
    public void getThemeChildData(int id) {
        addSubscribe(mRetrofitHelper.fetchThemeChildListInfo(id)
                .compose(RxUtil.<ThemeChildListBean>rxSchedulerHelper())
                .map(new Function<ThemeChildListBean, ThemeChildListBean>() {
                    @Override
                    public ThemeChildListBean apply(ThemeChildListBean themeChildListBean) {
                        List<ThemeChildListBean.StoriesBean> list = themeChildListBean.getStories();
                        for(ThemeChildListBean.StoriesBean item : list) {
                            item.setReadState(mRealmHelper.queryNewsId(item.getId()));
                        }
                        return themeChildListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<ThemeChildListBean>(mView) {
                    @Override
                    public void onNext(ThemeChildListBean themeChildListBean) {
                        mView.showContent(themeChildListBean);
                    }
                })
        );
    }

    @Override
    public void insertReadToDB(int id) {
        mRealmHelper.insertNewsId(id);
    }
}
