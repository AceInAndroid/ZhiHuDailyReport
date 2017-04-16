package com.AceInAndroid.ZhihuDailyReport.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.AceInAndroid.ZhihuDailyReport.app.App;
import com.AceInAndroid.ZhihuDailyReport.util.SystemUtil;

/**
 * Created by AceInAndroid on 16/11/30.
 */

public class GoldItemDecoration extends RecyclerView.ItemDecoration{

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (position > -1) {
            if (position == 0) {
                outRect.set(0, SystemUtil.dp2px(App.getInstance(), 15), 0, 0);
            } else if (position == 3) {
                outRect.set(0, SystemUtil.dp2px(App.getInstance(), 0.5f), 0, SystemUtil.dp2px(App.getInstance(), 15));
            } else {
                outRect.set(0, SystemUtil.dp2px(App.getInstance(), 0.5f), 0, 0);
            }
        }
    }
}
