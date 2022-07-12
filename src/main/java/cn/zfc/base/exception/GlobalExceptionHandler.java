package cn.zfc.base.exception;

import cn.zfc.base.commons.Result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @auther:zfc
 * @Date:2022/7/11-07-11-15:19
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public R handler(RuntimeException e){
        log.error("运行异常: -------------------{}",e.getMessage());
        return R.fail(e.getMessage());
    }

}
