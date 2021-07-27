package com.baidu.erpusfrg.controller;

import com.baidu.core.controller.BaseController;
import com.baidu.erpusfrg.service.UserVfService;
import com.baidu.instance.po.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/erp/verification")
public class UserVfController extends BaseController<UserVfService,UserInfo> {
}
