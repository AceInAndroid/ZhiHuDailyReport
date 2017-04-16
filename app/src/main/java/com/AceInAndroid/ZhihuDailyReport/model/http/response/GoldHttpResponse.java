package com.AceInAndroid.ZhihuDailyReport.model.http.response;

/**
 * Created by AceInAndroid on 16/11/27.
 */

public class GoldHttpResponse<T> {

    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
