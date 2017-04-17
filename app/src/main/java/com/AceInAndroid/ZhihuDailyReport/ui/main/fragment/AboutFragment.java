package com.AceInAndroid.ZhihuDailyReport.ui.main.fragment;

import com.AceInAndroid.ZhihuDailyReport.app.Constants;
import com.AceInAndroid.ZhihuDailyReport.base.SimpleFragment;
import com.AceInAndroid.ZhihuDailyReport.util.AlipayUtil;
import com.AceInAndroid.ZhihuDailyReport.util.SnackbarUtil;
import com.AceInAndroid.ZhihuDailyReport.R;

import butterknife.OnClick;

/**
 * Created by AceInAndroid on 17/4/23.
 */

public class AboutFragment extends SimpleFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initEventAndData() {
    }

    @OnClick(R.id.cv_about_award)
    void awardAuthor() {
//        if (AlipayUtil.hasInstalledAlipayClient(mContext)) {
//            AlipayUtil.startAlipayClient(getActivity(), Constants.KEY_ALIPAY);
//        } else {
//        }
        SnackbarUtil.showShort(getActivity().getWindow().getDecorView(), "蟹蟹蟹蟹 支付宝key还没申请下来");
    }

}
