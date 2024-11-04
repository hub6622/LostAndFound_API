package com.zjitc.lostandfound_api.service.impl;

import com.zjitc.lostandfound_api.config.MinioConfig;
import com.zjitc.lostandfound_api.mapper.FileMapper;
import com.zjitc.lostandfound_api.pojo.File;
import com.zjitc.lostandfound_api.service.FileService;
import com.zjitc.lostandfound_api.utils.MinioUtils;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private MinioUtils minioUtils;
    @Autowired
    private MinioConfig minioConfig;
    @Resource
    private FileMapper fileMapper;
    @Override
    public String upload(MultipartFile file) throws Exception{
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(filename);
        String cotentType = file.getContentType();
        minioUtils.uploadFile(minioConfig.getBucketName(),file,filename,cotentType);
        String url = minioConfig.getEndpoint()+"/"+minioConfig.getBucketName()+"/"+filename;
        System.out.println(url);
        return url;
    }

    @Override
    public List<File> getAll() {
        return fileMapper.findAll();
    }

    @Override
    public boolean delFile(List<String> fileNames) {
        for (String name:fileNames
             ) {
            fileMapper.delFile(name);
            minioUtils.removeFiles(minioConfig.getBucketName(), fileNames);
        }
        return true;
    }
}
