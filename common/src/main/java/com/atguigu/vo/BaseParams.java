package com.atguigu.vo;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class BaseParams implements Serializable {

    private static final long serialVersionUID = 1L;

    public BaseParams() {
    }

    /**
     * Convert a list of objects to a list of another type.
     */
    public static <T, V> List<V> convertList(List<T> sourceList, Class<V> targetClass) {
        return sourceList.stream().map(source -> {
            V targetInstance;
            try {
                targetInstance = targetClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create instance of " + targetClass.getName(), e);
            }
            BeanUtils.copyProperties(source, targetInstance);
            return targetInstance;
        }).collect(Collectors.toList());
    }
}