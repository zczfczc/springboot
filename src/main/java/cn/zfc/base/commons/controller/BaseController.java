package cn.zfc.base.commons.controller;

import cn.zfc.base.commons.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther:zfc
 * @Date:2022/7/11-14:12
 **/
@SuppressWarnings("all")
public abstract class BaseController<S extends BaseService<T>, T>{

    @Autowired
    protected S baseService;

    public BaseController() {
    }

    public S getBaseService() {
        return this.baseService;
    }

}
