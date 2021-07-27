package com.baidu.common.face;



import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class CommonObjects {
    private Map<String,Object> map=new HashMap<>();

    private String user_id;
    private String group_id;
    private String image;
    private String image_type;
    //封装的是检测
    public CommonObjects(String image, String image_type) {
        this.image = image;
        this.image_type = image_type;
    }

    //人脸注册
    public CommonObjects(String user_id, String group_id, String image,  String image_type) {
        this.user_id = user_id;
        this.group_id = group_id;
        this.image = image;
        this.image_type = image_type;
    }
    //人脸列表
    public CommonObjects(StringBuffer user_id,String group_id) {
        this.user_id=user_id.toString();
        this.group_id=group_id;
    }


    //检测
    public String faceDetectPacking(){
        map.put("image",image);
        map.put("image_type",image_type);
        return packJson(map);
    }
    //注册
    public String faceAddPacking(){
        map.put("user_id",user_id);
        map.put("group_id",group_id);
        map.put("image",image);
        map.put("image_type",image_type);
        return packJson(map);
    }


    //列表
    public String faceListPacking(){
        map.put("user_id",user_id);
        map.put("group_id",group_id);
        return packJson(map);
    }
    String packJson(Map<String,Object> map){
        return JSON.toJSONString(map);
    }


}
