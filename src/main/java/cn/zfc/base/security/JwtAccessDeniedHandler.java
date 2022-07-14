package cn.zfc.base.security;

import cn.hutool.json.JSONUtil;
import cn.zfc.base.commons.Result.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @auther:zfc
 * @Date:2022-07-14 22:40
 **/
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        // 定义返回消息格式，字符
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 返回403
        // 获取返回流
        ServletOutputStream outputStream = response.getOutputStream();
        // 写入失败数据
        outputStream.write(JSONUtil.toJsonStr(R.fail(e.getMessage())).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
