package com.baidu.common.face.facematch;


import com.baidu.common.face.AuthService;
import com.baidu.common.face.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FaceMatch {
    public static String faceMatch(Map<String,String> zs,Map<String,String> ls) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            List<Object> mapList =new ArrayList<>();
            mapList.add(zs);
            mapList.add(ls);
            //String param = GsonUtils.toJson(mapList);
            String param = mapList.toString();
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}