package com.AceInAndroid.ZhihuDailyReport.base;

/**
 * Created by AceInAndroid on 2017/4/2.
 * Presenter基类
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
