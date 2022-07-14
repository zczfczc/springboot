package cn.zfc.controller;

import cn.zfc.base.commons.controller.BaseController;
import cn.zfc.entity.SysUser;
import cn.zfc.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zfc
 * @since 2022-07-12
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController<SysUserService,SysUser> {

}
