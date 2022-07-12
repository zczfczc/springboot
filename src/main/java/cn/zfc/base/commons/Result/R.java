package cn.zfc.base.commons.Result;

import cn.zfc.base.commons.constant.ConstantCode;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一结果返回类
 * @auther:zfc
 * @Date:2022-7-10-16:49
 **/
@Data
@Accessors(chain = true)
public class R<T> implements Serializable {
    // 返回的数据
    private T data;
    // 响应信息
    private String msg;
    // 响应状态码
    private Integer code;

    public R() {
    }

    public R(T data, String msg, Integer code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public R(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public R(Integer code) {
        this.code = code;
    }

    public static <E> R<E> success(E data, String msg, Integer code) {
        return new R<>(data, msg, code);
    }

    public static <E> R<E> success(E data) {
        return new R<>(data, "操作成功！", ConstantCode.SUCCESS_CODE);
    }

    public static <E> R<E> success(Integer code) {
        return new R<>(code);
    }

    public static <E> R<E> success(String msg) {
        return new R<>(msg, ConstantCode.SUCCESS_CODE);
    }

    public static <E> R<E> fail(String msg) {
        return new R<>(msg, ConstantCode.FAIL_CODE);
    }

    public static <E> R<E> fail(E data, String msg, Integer code) {
        return new R<>(data, msg, code);
    }

    public static <E> R<E> fail(E data, String msg) {
        return new R<>(data, msg, ConstantCode.FAIL_CODE);
    }
}
