package com.keke.util;

import java.util.LinkedHashMap;
import java.util.List;

public class Layui  extends LinkedHashMap<String, Object> {

    public static Layui data(Integer count, List<?> data){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }

    public static Layui data2(Integer code, String msg){
        Layui r = new Layui();
        r.put("code", code);
        r.put("msg", msg);
        r.put("count", 10);
        r.put("data", "");
        return r;
    }

    public static Layui data3(Integer count, Object data){
        Layui r = new Layui();
        String str = "["+(String)data+"]";
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }

    public static Layui data(Integer count, Object data){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }

}