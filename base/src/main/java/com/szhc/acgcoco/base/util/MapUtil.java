package com.szhc.acgcoco.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MapUtil {
    public MapUtil() {
    }

    public static Integer getInteger(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        } else {
            Object obj = map.get(key);
            if (obj == null) {
                return null;
            } else {
                return obj instanceof Integer ? (Integer) obj : Integer.valueOf(getString(map, key));
            }
        }
    }

    public static Long getLong(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        } else {
            Object obj = map.get(key);
            if (obj == null) {
                return null;
            } else {
                return obj instanceof Long ? (Long) obj : Long.valueOf(getString(map, key));
            }
        }
    }

    public static String getString(Map<String, Object> map, String key) {
        if (map == null) {
            return "";
        } else {
            Object obj = map.get(key);
            if (obj == null) {
                return "";
            } else {
                return obj instanceof String ? (String) obj : String.valueOf(obj);
            }
        }
    }

    public static Date getDate(Map<String, Object> map, String key) throws Exception {
        String str = getString(map, key);
        if (str != null && !"".equals(str.trim())) {
            SimpleDateFormat sdf;
            if (str.length() == 10) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.parse(str);
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.parse(str);
            }
        } else {
            return null;
        }
    }

    //TODO 小文
    public static <T> T gettet(T t){
        return t;
    }
}
