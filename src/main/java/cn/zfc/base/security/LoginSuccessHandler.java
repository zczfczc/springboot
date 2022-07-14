package cn.zfc.base.security;

import cn.hutool.json.JSONUtil;
import cn.zfc.base.commons.Result.R;
import cn.zfc.base.utils.JwtUtil;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 认证失败返回消息
 *
 * @auther:zfc
 * @Date:2022-07-14 17:08
 **/
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 定义返回消息格式，字符
        response.setContentType("application/json; charset=UTF-8");
        // 获取返回流
        ServletOutputStream outputStream = response.getOutputStream();
        // 生成jwt,放入请求头中
        String token = jwtUtil.generateToken(authentication.getName());
        response.setHeader(jwtUtil.getHeader(), token);

        outputStream.write(JSONUtil.toJsonStr(R.success("登录成功!")).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
