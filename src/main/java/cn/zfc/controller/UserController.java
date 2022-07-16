package cn.zfc.controller;

import cn.zfc.base.commons.Result.R;
import cn.zfc.base.commons.controller.BaseController;
import cn.zfc.entity.User;
import cn.zfc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController extends BaseController<UserService, User> {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/pass")
    public R<String> pass(){
        String password = bCryptPasswordEncoder.encode("123456");
        boolean matches = bCryptPasswordEncoder.matches("123456", password);
        return R.success(password);
    }
}
