package cn.kr.utils;

import com.alibaba.fastjson.JSON;

/**
 * json util
 * @author Administrator
 */
public class JsonUtil {

    public static String objectToJson(Object object) {
        String jsonString = JSON.toJSONString(object);
        return jsonString;
    }
}
