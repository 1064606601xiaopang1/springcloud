package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Guo
 * @Date: 2020/9/3 12:06
 */
@Data
@NoArgsConstructor   // 空参
@AllArgsConstructor   // 全参
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    /**
     * 返回两个参数的提示
     *
     * @param code
     * @param message
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
