package com.baidu.core.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.core.po.BaseEntity;
import com.baidu.core.po.RequestBean;
import com.baidu.core.po.ResponseBean;
import com.baidu.core.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;


public abstract class BaseController<S extends  ICrudService<T>,T extends BaseEntity>{
    @Autowired
    private S service;

    ResponseBean responseBean = new ResponseBean();


    @PostMapping("/identity")
    public String VfUser(RequestBean bean){
        boolean flag=false;
        try {
           flag = service.verification(Objects.requireNonNull(bean));
            responseBean.setMsg("操作成功");
            responseBean.setCode(200);
            responseBean.setSuccess(flag);
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setMsg("操作失败");
            responseBean.setCode(500);
        }

        return  JSONObject.toJSON(responseBean).toString();
    }
    @PostMapping("/register")
    public String RegUser(RequestBean requestBean){
        //注册人脸
        boolean flag=false;
        try {
            flag= service.add(Objects.requireNonNull(requestBean));
            responseBean.setMsg("操作成功");
            responseBean.setCode(200);
            responseBean.setSuccess(flag);
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setMsg("操作失败");
            responseBean.setCode(500);
        }
        return  JSONObject.toJSON(responseBean).toString();
    }
    public void  afterEdit(T entity){
    }

}
