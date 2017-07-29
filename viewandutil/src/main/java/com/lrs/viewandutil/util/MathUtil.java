package com.lrs.viewandutil.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/27.
 */

public class MathUtil {

    public static List<?> copyToList(Set<?> set){
        List<Object> list=new ArrayList<>();
        if(set==null)
            return list;
        for (Object next : set) {
            list.add(next);
        }
        return list;
    }
}