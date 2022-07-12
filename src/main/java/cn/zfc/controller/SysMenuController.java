package cn.zfc.controller;


import cn.zfc.base.commons.Result.R;
import cn.zfc.base.commons.controller.BaseController;
import cn.zfc.entity.SysMenu;
import cn.zfc.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zfc
 * @since 2022-07-11
 */
@Slf4j
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController implements BaseController<SysMenu> {
    @Autowired
    private SysMenuService  sysMenuService;
    @GetMapping("/test")
    public R<List<SysMenu>> getSys(){
        List<SysMenu> list = sysMenuService.list();
        return R.success(list);
    }
}
