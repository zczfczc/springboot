package cn.zfc.base.filter;

import cn.hutool.core.util.StrUtil;
import cn.zfc.base.commons.constant.Constant;
import cn.zfc.base.exception.CaptchaException;
import cn.zfc.base.security.LoginFailureHandler;
import cn.zfc.base.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码过滤器
 *
 * @auther:zfc
 * @Date:2022-07-14 20:14
 **/
@Component
public class CaptchaFilter extends OncePerRequestFilter { //OncePerRequestFilter

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();
        if ("/login".equals(url) && request.getMethod().equals("POST")) {
            try {
                // 1.校验验证码
                check(request);
            } catch (CaptchaException e) {
                // 2.处理验证码异常
               loginFailureHandler.onAuthenticationFailure(request,response,e);
            }

        }
        // 放开
        filterChain.doFilter(request,response);

    }

    /**
     * 校验验证码
     *
     * @param request
     */
    private void check(HttpServletRequest request) {
        String code = request.getParameter("code");
        String key = request.getParameter("key");

        if (StrUtil.isBlank(code) || StrUtil.isBlank(key)) {
            throw new CaptchaException("验证码错误!");
        }

        if (!code.equals(redisUtil.hget(Constant.CAPTCHA_KEY, key))) {
            throw new CaptchaException("验证码错误!");
        }
        // 删除验证码
        redisUtil.hdel(Constant.CAPTCHA_KEY, key);
    }


}
