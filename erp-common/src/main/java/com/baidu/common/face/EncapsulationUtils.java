package com.baidu.common.face;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class EncapsulationUtils {
    public static String packing(String base64){
        Map<String, Object> map = new HashMap<>();
            map.put("image", base64);
            map.put("group_id", ListFinal.User);//用户组
            map.put("user_id", ListFinal.erpUser);
            map.put("image_type", "FACE_TOKEN");
            return JSON.toJSONString(map);
    }
}
