package com.atguigu.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:数据校验错误
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Getter
public enum ErrorCode {

    // 通用错误
    VALIDATION_ERROR("VALIDATION_ERROR", "Validation error occurred"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Internal server error"),

    // 用户相关错误
    USER_NOT_FOUND("USER_NOT_FOUND", "User not found"),
    INVALID_CREDENTIALS("INVALID_CREDENTIALS", "Invalid username or password"),

    // 权限相关错误
    UNAUTHORIZED("UNAUTHORIZED", "Unauthorized access"),
    FORBIDDEN("FORBIDDEN", "Access forbidden"),

    // 资源相关错误
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", "Requested resource not found"),
    RESOURCE_ALREADY_EXISTS("RESOURCE_ALREADY_EXISTS", "Resource already exists"),

    // 数据库相关错误
    DATABASE_ERROR("DATABASE_ERROR", "Database operation failed"),

    // 业务逻辑相关错误
    INSUFFICIENT_FUNDS("INSUFFICIENT_FUNDS", "Insufficient funds for the operation"),
    INVALID_OPERATION("INVALID_OPERATION", "Invalid operation");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}




