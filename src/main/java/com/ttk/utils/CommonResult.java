package com.ttk.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    private String token;

    /**
     * 成功
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(String message, T data) {
        CommonResult commonResult = new CommonResult(message, data);
        commonResult.setCode(200);
        return commonResult;
    }

    /**
     * 成功：无返回值
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(String message) {
        CommonResult commonResult = new CommonResult(message);
        commonResult.setCode(200);
        return commonResult;
    }

    /**
     * 失败
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> fail(String message, T data) {
        CommonResult commonResult = new CommonResult(message, data);
        commonResult.setCode(500);
        return commonResult;
    }

    /**
     * 权限
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> noPermission(Integer code, String message, T data) {
        CommonResult commonResult = new CommonResult(message, data);
        commonResult.setCode(code);
        return commonResult;
    }

    public CommonResult(String message) {
        this.message = message;
    }

    public CommonResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

}
