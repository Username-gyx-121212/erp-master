package com.baidu.common.face.faceadd;

import com.baidu.common.face.AuthService;
import com.baidu.common.face.HttpUtil;


public class FaceAdd {


    public static String add(String param){
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
//            Map<String, Object> map = new HashMap<>();
//            map.put("image", "027d8308a2ec665acb1bdf63e513bcb9");
//            map.put("group_id", "group_repeat");用户组
//            map.put("user_id", "user1");
//            map.put("image_type", "FACE_TOKEN");
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

//    public static void main(String[] args) {
//        FaceAdd.add();
//    }
}
