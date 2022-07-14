package cn.zfc.controller;

import cn.zfc.base.commons.Result.R;
import cn.zfc.base.commons.controller.BaseController;
import cn.zfc.entity.SysMenu;
import cn.zfc.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zfc
 * @since 2022-07-11
 */
@Slf4j
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController<SysMenuService, SysMenu> {

    @PostMapping("/test")
    public R<List<SysMenu>> getSysMenu(){
        List<SysMenu> list = baseService.list();
        return  R.success(list);
    }

}
