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
     * Convert params to entity.
     */
    public static <T, V> List<V> convertToEntityList(List<T> paramsList, Class<V> entityClass) {

        return paramsList.stream().map(params -> {
            V entityInstance;
            try {
                entityInstance = entityClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create instance of " + entityClass.getName(), e);
            }
            BeanUtils.copyProperties(params, entityInstance);
            return entityInstance;
        }).collect(Collectors.toList());
    }
}