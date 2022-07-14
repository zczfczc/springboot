package cn.zfc.base.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTException;
import cn.zfc.base.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther:zfc
 * @Date:2022-07-14 22:13
 **/
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(jwtUtil.getHeader());
        if (StrUtil.isBlankOrUndefined(token)) {
            chain.doFilter(request, response);
            return;
        }
        Claims claim = jwtUtil.getClaimsByToken(token);
        if (ObjectUtil.isNull(claim)) {
            throw new JwtException("token 异常!");
        }
        if (jwtUtil.isTokenExpired(claim)){
            throw new JwtException("登录已过期,请重新登录!");
        }
        // 获取用户权限
        String username = claim.getSubject();
        UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(token1);
        chain.doFilter(request,response);

    }


}
