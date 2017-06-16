package com.lrs.viewandutil.database;

import java.io.Serializable;

/**
 * Created by wb-lrs192703 on 2017/6/15.
 */

public class StepData implements Serializable {


    public String mDate;
    public String mCount;

    public StepData(String mDate, String mCount) {
        this.mDate = mDate;
        this.mCount = mCount;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getCount() {
        return mCount;
    }

    public void setCount(String mCount) {
        this.mCount = mCount;
    }
}
