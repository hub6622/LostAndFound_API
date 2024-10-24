package com.zjitc.lostandfound_api.mapper;

import com.zjitc.lostandfound_api.pojo.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("insert into t_file(filename,item,userId) values (#{filename},#{itemId},#{userId}")
    void addFile(String filename, int itemId, Integer userId);

    @Insert("insert into sys_file(file_name,file_url,user_id,create_time) values(#{filename},#{avatarUrl},#{userId},CURRENT_TIMESTAMP)")
    void addUserFile(String filename, String avatarUrl, Integer userId);

    @Update("update sys_file set update_time=CURRENT_TIMESTAMP,file_name=#{filename},file_url=#{avatarUrl} where user_id=#{userId}")
    void updateUserFile(String filename, String avatarUrl, Integer userId);

    @Update("update sys_file set update_time=CURRENT_TIMESTAMP,file_name=#{filename},file_url=#{picUrl} where id=#{id}")
    void updateItemFile(Integer id, String filename, String picUrl);


    List<File> findAll();

    @Delete("delete from sys_file where file_name=#{name}")
    void delFile(String name);
}
