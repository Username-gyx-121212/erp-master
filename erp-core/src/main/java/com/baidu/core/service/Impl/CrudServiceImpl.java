package com.baidu.core.service.Impl;


import com.baidu.core.mapper.ICurdMapper;
import com.baidu.core.po.BaseEntity;
import com.baidu.core.po.RequestBean;
import com.baidu.core.service.ICrudService;
import com.baidu.core.utils.face.CommonObjects;
import com.baidu.core.utils.face.ListFinal;
import com.baidu.core.utils.face.faceadd.FaceAdd;
import com.baidu.core.utils.face.facedetect.FaceDetect;
import com.baidu.core.utils.face.facelistmatch.FaceGetList;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

public class CrudServiceImpl<T extends BaseEntity> extends ServiceImpl<ICurdMapper<T>,T> implements ICrudService<T> {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //验证
    @Override
    public boolean verification(RequestBean bean) {
        //得到用户列表
        //String faceGetList = FaceGetList.faceGetList(new CommonObjects(new StringBuffer(bean.getUsername()).append(bean.getPhonenum()), ListFinal.erpUser.toString()).faceListPacking());

        //得到用户face_token
        //认证user_id用用户的号码和用户电话做拼接
        String faceDetect = FaceDetect.faceDetect(new CommonObjects(bean.getBase64(),ListFinal.FACE_TOKEN.toString()).faceDetectPacking());

        //redis缓存看有没有相应的face_token
        //享元模式查看

        if(faceDetect.equals(redisTemplate.opsForValue().get(bean.getPhonenum()))){
            return true;
        }
        return true;
    }

    @Override
    public boolean add(RequestBean requestBean) {
            //注册人脸
        try {
            redisTemplate.opsForValue().set(requestBean.getPhonenum(), Objects.requireNonNull(FaceAdd.add(new CommonObjects(requestBean.getBase64(), ListFinal.FACE_TOKEN.toString(), ListFinal.erpUser.toString(), ListFinal.User.toString())
                    .faceAddPacking())));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}