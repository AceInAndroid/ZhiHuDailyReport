package com.AceInAndroid.ZhihuDailyReport.model.http.response;

/**
 * Created by AceInAndroid on 2017/4/3.
 */
public class GankHttpResponse<T> {

    private boolean error;
    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
