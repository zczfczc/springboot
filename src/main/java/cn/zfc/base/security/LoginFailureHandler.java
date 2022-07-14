package cn.zfc.base.security;

import cn.hutool.json.JSONUtil;
import cn.zfc.base.commons.Result.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

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
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        // 定义返回消息格式，字符
        response.setContentType("application/json; charset=UTF-8");
        // 获取返回流
        ServletOutputStream outputStream = response.getOutputStream();
        // 写入失败数据
        outputStream.write(JSONUtil.toJsonStr(R.fail(e.getMessage())).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
