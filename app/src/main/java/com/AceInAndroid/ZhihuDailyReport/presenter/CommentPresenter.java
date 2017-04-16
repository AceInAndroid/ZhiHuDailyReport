package com.AceInAndroid.ZhihuDailyReport.presenter;

import com.AceInAndroid.ZhihuDailyReport.model.http.RetrofitHelper;
import com.AceInAndroid.ZhihuDailyReport.base.RxPresenter;
import com.AceInAndroid.ZhihuDailyReport.model.bean.CommentBean;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.CommentContract;
import com.AceInAndroid.ZhihuDailyReport.util.RxUtil;
import com.AceInAndroid.ZhihuDailyReport.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by AceInAndroid on 17/4/18.
 */

public class CommentPresenter extends RxPresenter<CommentContract.View> implements CommentContract.Presenter{

    public static final int SHORT_COMMENT = 0;

    public static final int LONG_COMMENT = 1;

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public CommentPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getCommentData(int id, int commentKind) {
        if(commentKind == SHORT_COMMENT) {
            addSubscribe(mRetrofitHelper.fetchShortCommentInfo(id)
                .compose(RxUtil.<CommentBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<CommentBean>(mView) {
                    @Override
                    public void onNext(CommentBean commentBean) {
                        mView.showContent(commentBean);
                    }
                })
            );
        } else {
            addSubscribe(mRetrofitHelper.fetchLongCommentInfo(id)
                .compose(RxUtil.<CommentBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<CommentBean>(mView) {
                    @Override
                    public void onNext(CommentBean commentBean) {
                        mView.showContent(commentBean);
                    }
                })
            );
        }
    }
}
