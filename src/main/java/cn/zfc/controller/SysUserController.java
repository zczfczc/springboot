package cn.zfc.controller;


import cn.zfc.base.commons.controller.BaseController;
import cn.zfc.entity.SysUser;
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
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController<SysUser> {

}
