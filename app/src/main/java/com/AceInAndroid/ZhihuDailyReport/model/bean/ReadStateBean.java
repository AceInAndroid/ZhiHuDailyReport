package com.AceInAndroid.ZhihuDailyReport.model.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by AceInAndroid on 17/4/17.
 */

public class ReadStateBean extends RealmObject{

    @PrimaryKey
    private int id;

    public ReadStateBean() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
