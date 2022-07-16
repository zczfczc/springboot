package cn.zfc.service.base;

import cn.hutool.core.util.ObjectUtil;
import cn.zfc.base.security.AccountUser;
import cn.zfc.entity.User;
import cn.zfc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @auther:zfc
 * @Date:2022-07-15 11:19
 **/
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = sysUserService.getByUsername(username);
        User user = new User();
        if (ObjectUtil.isNull(user)) {
            throw new UsernameNotFoundException("用户名或者密码错误!");
        }

        return new AccountUser(user.getId(), user.getUsername(), user.getPassword(), getUserAuthorities(user.getId()));

    }

    /**
     * 获取用户权限信息角色，菜单
     *
     * @param userId
     * @return
     */
    public List<GrantedAuthority> getUserAuthorities(Long userId) {
//        String authorities = sysUserService.getUserAuthorities(userId);
        String authorities = "";
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }

}
