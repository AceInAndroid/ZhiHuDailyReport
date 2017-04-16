package com.AceInAndroid.ZhihuDailyReport.model.event;

/**
 * Created by AceInAndroid on 17/4/27.
 */

public class NightModeEvent {

    private boolean isNightMode;

    public void setNightMode(boolean nightMode) {
        isNightMode = nightMode;
    }

    public boolean getNightMode() {
        return isNightMode;
    }
}
