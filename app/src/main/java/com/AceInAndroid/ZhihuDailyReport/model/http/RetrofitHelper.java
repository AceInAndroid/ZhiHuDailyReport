package com.AceInAndroid.ZhihuDailyReport.model.http;

import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeListBean;
import com.AceInAndroid.ZhihuDailyReport.app.Constants;
import com.AceInAndroid.ZhihuDailyReport.model.bean.CommentBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.DailyBeforeListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.DailyListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.DetailExtraBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GankItemBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GankSearchItemBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GoldListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.HotListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.RepliesListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.SectionChildListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.SectionListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.ThemeChildListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.ThemeListBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.VersionBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.WXItemBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.WelcomeBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.ZhihuDetailBean;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.GankApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.GoldApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.MyApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.VtexApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.WeChatApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.ZhihuApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.response.GankHttpResponse;
import com.AceInAndroid.ZhihuDailyReport.model.http.response.GoldHttpResponse;
import com.AceInAndroid.ZhihuDailyReport.model.http.response.MyHttpResponse;
import com.AceInAndroid.ZhihuDailyReport.model.http.response.WXHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by AceInAndroid on 2017/4/3.
 */
public class RetrofitHelper {

    private ZhihuApis mZhihuApiService;
    private GankApis mGankApiService;
    private WeChatApis mWechatApiService;
    private MyApis mMyApiService;
    private GoldApis mGoldApiService;
    private VtexApis mVtexApiService;

    public RetrofitHelper(ZhihuApis zhihuApiService, GankApis gankApiService, WeChatApis wechatApiService,
                          MyApis myApiService, GoldApis goldApiService, VtexApis vtexApiService) {
        this.mZhihuApiService = zhihuApiService;
        this.mGankApiService = gankApiService;
        this.mWechatApiService = wechatApiService;
        this.mMyApiService = myApiService;
        this.mGoldApiService = goldApiService;
        this.mVtexApiService = vtexApiService;
    }

    public Flowable<DailyListBean> fetchDailyListInfo() {
        return mZhihuApiService.getDailyList();
    }

    public Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date) {
        return mZhihuApiService.getDailyBeforeList(date);
    }

    public Flowable<ThemeListBean> fetchDailyThemeListInfo() {
        return mZhihuApiService.getThemeList();
    }

    public Flowable<ThemeChildListBean> fetchThemeChildListInfo(int id) {
        return mZhihuApiService.getThemeChildList(id);
    }

    public Flowable<SectionListBean> fetchSectionListInfo() {
        return mZhihuApiService.getSectionList();
    }

    public Flowable<SectionChildListBean> fetchSectionChildListInfo(int id) {
        return mZhihuApiService.getSectionChildList(id);
    }

    public Flowable<ZhihuDetailBean> fetchDetailInfo(int id) {
        return mZhihuApiService.getDetailInfo(id);
    }

    public Flowable<DetailExtraBean> fetchDetailExtraInfo(int id) {
        return mZhihuApiService.getDetailExtraInfo(id);
    }

    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }

    public Flowable<CommentBean> fetchLongCommentInfo(int id) {
        return mZhihuApiService.getLongCommentInfo(id);
    }

    public Flowable<CommentBean> fetchShortCommentInfo(int id) {
        return mZhihuApiService.getShortCommentInfo(id);
    }

    public Flowable<HotListBean> fetchHotListInfo() {
        return mZhihuApiService.getHotList();
    }

    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return mGankApiService.getTechList(tech, num, page);
    }

    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return mGankApiService.getGirlList(num, page);
    }

    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
        return mGankApiService.getRandomGirl(num);
    }

    public Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query,String type,int num,int page) {
        return mGankApiService.getSearchList(query,type,num,page);
    }

    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
        return mWechatApiService.getWXHot(Constants.KEY_API, num, page);
    }

    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word) {
        return mWechatApiService.getWXHotSearch(Constants.KEY_API, num, page, word);
    }

    public Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo() {
        return mMyApiService.getVersionInfo();
    }

    public Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldList(String type, int num, int page) {
        return mGoldApiService.getGoldList(Constants.LEANCLOUD_ID, Constants.LEANCLOUD_SIGN,
                "{\"category\":\"" + type + "\"}", "-createdAt", "user,user.installation", num, page * num);
    }

    public Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldHotList(String type, String dataTime, int limit) {
        return mGoldApiService.getGoldHot(Constants.LEANCLOUD_ID, Constants.LEANCLOUD_SIGN,
                "{\"category\":\"" + type + "\",\"createdAt\":{\"$gt\":{\"__type\":\"Date\",\"iso\":\"" + dataTime + "T00:00:00.000Z\"}},\"objectId\":{\"$nin\":[\"58362f160ce463005890753e\",\"583659fcc59e0d005775cc8c\",\"5836b7358ac2470065d3df62\"]}}",
                "-hotIndex", "user,user.installation", limit);
    }

    public Flowable<NodeBean> fetchNodeInfo(String name) {
        return mVtexApiService.getNodeInfo(name);
    }

    public Flowable<List<NodeListBean>> fetchTopicList(String name) {
        return mVtexApiService.getTopicList(name);
    }

    public Flowable<List<NodeListBean>> fetchTopicInfo(String id) {
        return mVtexApiService.getTopicInfo(id);
    }

    public Flowable<List<RepliesListBean>> fetchRepliesList(String id){
        return mVtexApiService.getRepliesList(id);
    }
}
