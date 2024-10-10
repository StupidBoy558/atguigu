package com.atguigu.vo;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/
public class BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public BaseVo() {
    }

    /**
     * Convert entity to Vo.
     */
    public static <T, V> List<V> convertToVoList(List<T> entityList, Class<V> voClass) {
        return entityList.stream().map(entity -> {
            V voInstance;
            try {
                voInstance = voClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create instance of " + voClass.getName(), e);
            }
            BeanUtils.copyProperties(entity, voInstance);
            return voInstance;
        }).collect(Collectors.toList());
    }
}
