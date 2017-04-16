package com.AceInAndroid.ZhihuDailyReport.presenter;

import com.AceInAndroid.ZhihuDailyReport.base.RxPresenter;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GoldListBean;
import com.AceInAndroid.ZhihuDailyReport.model.http.RetrofitHelper;
import com.AceInAndroid.ZhihuDailyReport.model.http.response.GoldHttpResponse;
import com.AceInAndroid.ZhihuDailyReport.util.RxUtil;
import com.AceInAndroid.ZhihuDailyReport.widget.CommonSubscriber;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.GoldContract;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by AceInAndroid on 16/11/27.
 */

public class GoldPresenter extends RxPresenter<GoldContract.View> implements GoldContract.Presenter{

    private static final int NUM_EACH_PAGE = 20;
    private static final int NUM_HOT_LIMIT = 3;

    private RetrofitHelper mRetrofitHelper;
    private List<GoldListBean> totalList = new ArrayList<>();

    private boolean isHotList = true;
    private int currentPage = 0;
    private String mType;

    @Inject
    public GoldPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getGoldData(String type) {
        mType = type;
        currentPage = 0;
        totalList.clear();
        Flowable<List<GoldListBean>> list = mRetrofitHelper.fetchGoldList(type, NUM_EACH_PAGE, currentPage++)
                .compose(RxUtil.<GoldHttpResponse<List<GoldListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GoldListBean>>handleGoldResult());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);

        Flowable<List<GoldListBean>> hotList = mRetrofitHelper.fetchGoldHotList(type,
                new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()), NUM_HOT_LIMIT)
                .compose(RxUtil.<GoldHttpResponse<List<GoldListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GoldListBean>>handleGoldResult());

        addSubscribe(Flowable.concat(hotList, list)
                .subscribeWith(new CommonSubscriber<List<GoldListBean>>(mView) {
                    @Override
                    public void onNext(List<GoldListBean> goldListBean) {
                        if (isHotList) {
                            isHotList = false;
                            totalList.addAll(goldListBean);
                        } else {
                            isHotList = true;
                            totalList.addAll(goldListBean);
                            mView.showContent(totalList);
                        }
                    }
                })
        );
    }

    @Override
    public void getMoreGoldData() {
        addSubscribe(mRetrofitHelper.fetchGoldList(mType, NUM_EACH_PAGE, currentPage++)
                .compose(RxUtil.<GoldHttpResponse<List<GoldListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GoldListBean>>handleGoldResult())
                .subscribeWith(new CommonSubscriber<List<GoldListBean>>(mView) {
                    @Override
                    public void onNext(List<GoldListBean> goldListBeen) {
                        totalList.addAll(goldListBeen);
                        mView.showMoreContent(totalList, totalList.size(), totalList.size() + NUM_EACH_PAGE);
                    }
                })
        );
    }
}
