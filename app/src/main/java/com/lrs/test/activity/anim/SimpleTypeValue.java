package com.lrs.test.activity.anim;

import java.io.Serializable;

/**
 * Created by 廖荣森 on 2017/12/16.
 */

public class SimpleTypeValue implements Serializable {

    public int x;
    public int y;

    public SimpleTypeValue() {
    }

    public SimpleTypeValue(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "SimpleTypeValue{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
