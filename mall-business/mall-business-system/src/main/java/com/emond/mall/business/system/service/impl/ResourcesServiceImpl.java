package com.emond.mall.business.system.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.emond.mall.business.system.exception.ResourceException;
import com.emond.mall.business.system.service.ResourcesService;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: Chen Weiming
 */
@Service
@Slf4j
public class ResourcesServiceImpl implements ResourcesService {

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    private volatile MinioClient minioClient;

    public void connect() {
        try {
            minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            if (!minioClient.bucketExists(BUCKET_NAME)) {
                minioClient.makeBucket(BUCKET_NAME);

                StringBuilder builder = new StringBuilder();
                builder.append("{\n");
                builder.append("    \"Statement\": [\n");
                builder.append("        {\n");
                builder.append("            \"Action\": [\n");
                builder.append("                \"s3:GetBucketLocation\",\n");
                builder.append("                \"s3:ListBucket\"\n");
                builder.append("            ],\n");
                builder.append("            \"Effect\": \"Allow\",\n");
                builder.append("            \"Principal\": \"*\",\n");
                builder.append("            \"Resource\": \"arn:aws:s3:::").append(BUCKET_NAME).append("\"\n");
                builder.append("        },\n");
                builder.append("        {\n");
                builder.append("            \"Action\": \"s3:GetObject\",\n");
                builder.append("            \"Effect\": \"Allow\",\n");
                builder.append("            \"Principal\": \"*\",\n");
                builder.append("            \"Resource\": \"arn:aws:s3:::").append(BUCKET_NAME).append("/*\"\n");
                builder.append("        }\n");
                builder.append("    ],\n");
                builder.append("    \"Version\": \"2012-10-17\"\n");
                builder.append("}\n");
                // 更改桶权限 设置公共可下载
                minioClient.setBucketPolicy(BUCKET_NAME, builder.toString());
                String bucketPolicy = minioClient.getBucketPolicy(BUCKET_NAME);
                System.out.println(bucketPolicy);
                log.info("创建资源桶成功: BUCKET_NAME = {}", BUCKET_NAME);
            }
        } catch (Exception e) {
            throw new ResourceException("连接资源服务器失败", e);
        }
    }

    @Override
    public String upload(MultipartFile file) {
        try {
            if (ObjectUtils.isEmpty(minioClient)) {
                synchronized (this.getClass()) {
                    if (ObjectUtils.isEmpty(minioClient)) {
                        connect();
                    }
                }
            }
            // 文件后缀
            String extName = FileUtil.extName(file.getOriginalFilename());
            // 设置存储对象名称
            String objectName = IdUtil.simpleUUID() + "." + extName;
            // 使用putObject上传一个文件到存储桶中
            minioClient.putObject(BUCKET_NAME, objectName, file.getInputStream(), file.getSize(), null, null, file.getContentType());
            String url = ENDPOINT + "/" + BUCKET_NAME + "/" + objectName;
            log.info("图片上传成功，图片地址：{}", url);
            return url;
        } catch (Exception e) {
            throw new ResourceException("资源上传失败", e);
        }
    }
}
