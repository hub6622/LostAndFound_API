package com.zjitc.lostandfound_api.service;

import com.zjitc.lostandfound_api.pojo.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    String upload(MultipartFile file) throws Exception;

    List<File> getAll();

    boolean delFile(List<String> fileNames);
}
