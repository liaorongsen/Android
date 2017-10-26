package com.lrs.test.activity;

import java.io.Serializable;

/**
 * Created by 廖荣森 on 2017/10/24.
 */

public class BaseModel implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
