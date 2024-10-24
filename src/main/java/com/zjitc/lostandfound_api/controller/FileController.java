package com.zjitc.lostandfound_api.controller;

import com.zjitc.lostandfound_api.config.MinioConfig;
import com.zjitc.lostandfound_api.pojo.Result;
import com.zjitc.lostandfound_api.service.FileService;
import com.zjitc.lostandfound_api.utils.MinioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
public class FileController {
    @Autowired
    private MinioUtils minioUtils;
    @Autowired
    private MinioConfig minioConfig;
    @Resource
    private FileService fileService;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        return new Result(200,"上传成功",fileService.upload(file));
    }
    @GetMapping("/file/findAll")
    public Result findAll(){
        return new Result(200,"查询成功",fileService.getAll());
    }
    @PostMapping("/file/del")
    public Result delFile(@RequestBody List<String> fileNames){
        System.out.println("delFile: " + fileNames);
//        fileService.delFile(fileNames)
        return new Result(200,"删除成功",fileService.delFile(fileNames));
    }
}
