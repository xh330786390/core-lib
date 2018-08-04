package com.tengxh.json;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: AbstractJson.java
 * @Description: java类作用描述
 * @Author: tengxh
 * @CreateDate: 2018/8/4
 * @Version: 1.0
 */
public abstract class AbstractJson {

    /**
     * 序列化：传入一个对象，将对象转成JSON字符串。
     *
     * @param obj
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    public abstract String toJson(Object obj);

    /**
     * 序列化：传入一个Map，将对象转成JSON字符串。
     *
     * @param map
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    public abstract String toJson(Map map);

    /**
     * 序列化：传入一个Map，将对象转成JSON字符串。
     *
     * @param mapList
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    public abstract String toJson(List<Map> mapList);


    /**
     * 序列化：传入一个date，将对象转成JSON字符串。
     *
     * @param date
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    public abstract String toJson(Date date);

    /**
     * 反序列：json 字符串转换成对象
     *
     * @param json
     * @return java.lang.Object
     * @author tengxh
     * @date 2018/8/4 14:54
     */
    public abstract Object fromJson(String json);
}
