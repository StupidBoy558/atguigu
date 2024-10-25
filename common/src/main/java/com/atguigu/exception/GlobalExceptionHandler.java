package com.atguigu.exception;

import com.atguigu.result.ResponseData;
import com.atguigu.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


/**
 * @Description: 全局异常处理.
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            final MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(
                    fieldName, ErrorCode.VALIDATION_ERROR.getMessage() + ": "
                            + errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseData handle(final RuntimeException e) {
        log.error("RuntimeException: ", e);
        return ResponseData.fail(ResultCodeEnum.REPEAT_SUBMIT.getCode(), "");
    }

    @ExceptionHandler(LeaseException.class)
    @ResponseBody
    public ResponseData handle(final LeaseException e) {
        log.error("LeaseException: ", e);
        return ResponseData.fail(ResultCodeEnum.DATA_ERROR.getCode(), "Unknown error");
    }


}
