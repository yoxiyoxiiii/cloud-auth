package cn.kr.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

    public static String ObjectToJson(Object object) {
        String jsonString = JSON.toJSONString(object);
        return jsonString;
    }
}
