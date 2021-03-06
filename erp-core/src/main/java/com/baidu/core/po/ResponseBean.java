package com.baidu.core.po;

import java.io.Serializable;

public class ResponseBean implements Serializable {
    private static  final long serialVersionUID=1L;
    /**
     * 成功标记
     */
    private boolean success=true;
    /**
     * 提示信息
     */
    private String msg="操作成功";
    /**
     *http状态码
     *
     */
    private int code =200;
    /**
     * 添加修改的实体类
     */
    private Object model;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }
}
