package com.baidu.core.service;

import com.baidu.core.po.RequestBean;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ICrudService<T> extends IService<T> {

    boolean verification(RequestBean base64);

    boolean add(RequestBean requestBean);
}
