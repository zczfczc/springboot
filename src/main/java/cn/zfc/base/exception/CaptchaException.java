package cn.zfc.base.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常类
 * @auther:zfc
 * @Date:2022-07-14 20:16
 **/
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }
}
