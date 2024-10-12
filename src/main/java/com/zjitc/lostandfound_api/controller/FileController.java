package com.zjitc.lostandfound_api.controller;

import com.zjitc.lostandfound_api.config.MinioConfig;
import com.zjitc.lostandfound_api.pojo.Result;
import com.zjitc.lostandfound_api.utils.MinioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileController {
    @Autowired
    private MinioUtils minioUtils;
    @Autowired
    private MinioConfig minioConfig;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {

        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(filename);
        String cotentType = file.getContentType();
        minioUtils.uploadFile(minioConfig.getBucketName(),file,filename,cotentType);
        String url = minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), filename);
        return new Result(200,"上传成功",url);
    }
}
