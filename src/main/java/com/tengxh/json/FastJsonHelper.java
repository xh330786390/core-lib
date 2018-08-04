package com.tengxh.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tengxh.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * @ClassName: FastJsonHelper.java
 * @Description: java类作用描述
 * @Author: tengxh
 * @CreateDate: 2018/8/4
 * @Version: 1.0
 */
public class FastJsonHelper extends AbstractJson {
    static final Log log = LogFactory.getLog(FastJsonHelper.class);

    /**
     * 序列化：传入一个对象，将对象转成JSON字符串。
     *
     * @param obj
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    @Override
    public String toJson(Object obj) {
        String strJson = JSON.toJSONString(obj);
        return strJson;
    }

    /**
     * 序列化：传入一个Map，将对象转成JSON字符串。
     *
     * @param map
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    @Override
    public String toJson(Map map) {
        String strJson = JSON.toJSONString(map);
        return strJson;
    }

    /**
     * 序列化：传入一个Map，将对象转成JSON字符串。
     *
     * @param mapList
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    @Override
    public String toJson(List<Map> mapList) {
        String strJson = JSON.toJSONString(mapList);
        return strJson;
    }

    /**
     * 序列化：传入一个date，将对象转成JSON字符串。
     *
     * @param date
     * @return java.lang.String
     * @author tengxh
     * @date 2018/8/4 14:16
     */
    @Override
    public String toJson(Date date) {
//        String dateJson = JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat);
        String dateJson = JSON.toJSONString(date, SerializerFeature.UseSingleQuotes);
//        String dateJson = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd");
        return dateJson;
    }

    /**
     * 反序列：json 字符串转换成对象
     *
     * @param json
     * @return java.lang.Object
     * @author tengxh
     * @date 2018/8/4 14:54
     */
    @Override
    public Object fromJson(String json) {

        User user1 = JSON.parseObject(json, User.class);
        return user1;
    }

    /**
     * 测试
     *
     * @param args
     * @return void
     * @author tengxh
     * @date 2018/8/4 14:25
     */
    public static void main(String[] args) {
        FastJsonHelper fastJsonHelper = new FastJsonHelper();
//        fastJsonHelper.testObj();
        fastJsonHelper.testMap();
//        fastJsonHelper.testJsonObject();
//        fastJsonHelper.testListMap();
//        fastJsonHelper.testDate();
    }

    //测试obj
    public void testObj() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("my test!");
        user.setAddress("shanghai");
        String json = toJson(user);
        System.out.println("obj to json = " + json);

        Object obj = fromJson(json);


    }

    //测试map
    public void testMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "One");
        map.put("key2", "Two");
        map.put("key3", new String[]{"hiking", "swimming"});
        String json = JSON.toJSONString(map);

        map = JSON.parseObject(json, Map.class);
        System.out.println("map to json = " + json);
    }

    //测试map
    public void testJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "One");
        jsonObject.put("key2", "Two");
        jsonObject.put("key3", new String[]{"hiking", "swimming"});

        String json = jsonObject.toJSONString();
        System.out.println("jsonObject to json = " + json);

        json = jsonObject.toString();
        System.out.println("jsonObject to json = " + json);
    }

    //测试map
    public void testListMap() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("key1", "One");
        map1.put("key2", "Two");

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("key1", "Three");
        map2.put("key2", "Four");

        list.add(map1);
        list.add(map2);

        String json = JSON.toJSONString(list);
        System.out.println("listmap to json = " + json);
    }

    public void testDate() {
        String json = toJson(new Date());
        System.out.println("date to json = " + json);
    }
}
