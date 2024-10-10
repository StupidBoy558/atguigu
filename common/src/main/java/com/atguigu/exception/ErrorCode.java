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
 * @Description: 数据校验错误
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Getter
public enum ErrorCode {

    // 通用错误
    INTERNAL_SERVER_ERROR("1016", "Internal server error"),

    // 用户相关错误
    USER_NOT_FOUND("1017", "User not found"),

    // 权限相关错误
    UNAUTHORIZED("1018", "Unauthorized access"),
    FORBIDDEN("1019", "Access forbidden"),

    // 资源相关错误
    RESOURCE_NOT_FOUND("1020", "Requested resource not found"),
    RESOURCE_ALREADY_EXISTS("1021", "Resource already exists"),

    // 数据库相关错误
    DATABASE_ERROR("1022", "Database operation failed"),

    // 业务逻辑相关错误

    INSUFFICIENT_FUNDS("1001", "Insufficient funds for the operation"),
    INVALID_OPERATION("1002", "Invalid operation"),
    DUPLICATE_ENTRY("1003", "Duplicate entry"),
    DATA_NOT_FOUND("1004", "Data not found"),
    UNAUTHORIZED_ACCESS("1005", "Unauthorized access to resource"),
    VALIDATION_ERROR("1006", "Input validation error"),
    RATE_LIMIT_EXCEEDED("1007", "Rate limit exceeded"),
    RESOURCE_UNAVAILABLE("1008", "Resource temporarily unavailable"),
    TRANSACTION_FAILED("1009", "Transaction failed"),
    INVALID_CREDENTIALS("1010", "Invalid credentials provided"),
    ACCOUNT_LOCKED("1011", "Account is locked"),
    EXPIRED_TOKEN("1012", "Token has expired"),
    INSUFFICIENT_PERMISSIONS("1013", "Insufficient permissions for action"),
    INVALID_INPUT_FORMAT("1014", "Invalid input format"),
    SERVICE_UNAVAILABLE("1015", "Service is currently unavailable");;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}




