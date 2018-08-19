package com.tengxh.generic;

import java.util.*;

/**
 * @ClassName: MapHelper.java
 * @Description: java类作用描述
 * @Author: tengxh
 * @CreateDate: 2018/8/19
 * @Version: 1.0
 */
public class MapHelper {

    private void HashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a1", "a");
        map.put("b2", "b");
        map.put("c3", "c");

        print(map);
    }

    private void LinkedHashMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        print(map);
    }

    private void TreeMap() {
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);       //按照key值大小升序排列       -o1.compareTo(o2)即o2.compareTo(o1)按照key值大小降序排列
                return 1;                     //按put反顺序排序      1则为 put顺序排列
            }
        });
        map.put("5", "a");
        map.put("3", "c");
        map.put("4", "b");
        map.put("2", "d");
        map.put("1", "e");

        print(map);
    }

    private <K, V> void print(Map<K, V> map) {
        for (Map.Entry<K, V> obj : map.entrySet()) {
            System.out.println("key = " + obj.getKey() + " value = " + obj.getValue());
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MapHelper helper = new MapHelper();
        helper.HashMap();
        helper.LinkedHashMap();
        helper.TreeMap();
    }
}
