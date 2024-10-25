package com.atguigu.service.impl;

import com.atguigu.config.MinioProperties;
import com.atguigu.service.FileService;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.SetBucketPolicyArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @Description: file service impl.
 * @Author: dansheng
 * @CreateTime: 2024/9/28
 **/
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    /**
     * minio client.
     */
    private final MinioClient minioClient;

    /**
     * minio properties.
     */
    private final MinioProperties properties;

    /**
     * 文件上传.
     *
     * @param file 文件
     * @return 文件路径
     */
    @Override
    public String upload(final MultipartFile file) throws Exception {

        boolean bucketExists = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(properties.getBucketName())
                        .build());
        // If the bucket does not exist, create it
        if (!bucketExists) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(properties.getBucketName())
                            .build());
            // Set the bucket's access policy
            String policy = createBucketPolicy(properties.getBucketName());
            minioClient.setBucketPolicy(
                    SetBucketPolicyArgs.builder()
                            .bucket(properties.getBucketName())
                            .config(policy)
                            .build());
        }

        // 文件唯一命名
        String fileName = new SimpleDateFormat("yyyyMMdd")
                .format(new Date())
                + "/" + UUID.randomUUID()
                + "-" + file.getOriginalFilename();

        // 上传文件
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(properties.getBucketName())
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .object(fileName)
                        .contentType(file.getContentType())
                        .build());
        // 返回文件路径
        return String.join(
                "/", properties.getEndpoint(), properties.getBucketName(),
                fileName);

    }

    private String createBucketPolicy(final String bucketName) {
        return """
                {
                  "Statement" : [ {
                    "Action" : "s3:GetObject",
                    "Resource" : "arn:aws:s3:::%s/*",
                    "Effect" : "Allow",
                    "Principal" : "*"
                  } ],
                    "Version" : "2012-10-17"
                }
                """.formatted(bucketName);
    }

}
