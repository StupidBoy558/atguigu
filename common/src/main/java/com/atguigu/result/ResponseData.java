package com.atguigu.result;

import lombok.Data;

/**
 * 全局统一返回结果类
 */
@Data
public class ResponseData<T> {

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    public ResponseData() {
    }

    private static <T> ResponseData<T> build(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        if (data != null) {
            responseData.setData(data);
        }
        return responseData;
    }

    public static <T> ResponseData<T> build(T body, ResultCodeEnum resultCodeEnum) {
        ResponseData<T> responseData = build(body);
        responseData.setCode(resultCodeEnum.getCode());
        responseData.setMessage(resultCodeEnum.getMessage());
        return responseData;
    }


    public static <T> ResponseData<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static <T> ResponseData<T> ok() {
        return ResponseData.ok(null);
    }

    public static <T> ResponseData<T> fail() {
        return build(null, ResultCodeEnum.FAIL);
    }

    public static <T> ResponseData<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }
}
