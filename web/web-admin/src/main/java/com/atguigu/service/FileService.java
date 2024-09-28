package com.atguigu.service;

import io.minio.errors.InsufficientDataException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.XmlParserException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
public interface FileService {

    /**
     * 文件上传.
     *
     * @param file 文件
     * @return 文件路径
     */
    String upload(MultipartFile file) throws Exception;
}
