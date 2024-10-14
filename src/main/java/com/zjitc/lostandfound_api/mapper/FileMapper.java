package com.zjitc.lostandfound_api.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    @Insert("insert into t_file(filename,item,userId) values (#{filename},#{itemId},#{userId}")
    void addFile(String filename, int itemId, Integer userId);
}
