package com.atguigu.exception;

/**
 * @Description: 全局异常处理类.
 * @Author: dansheng
 * @CreateTime: 2024/9/30
 **/
public class SystemResponse extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    public SystemResponse(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public SystemResponse(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
