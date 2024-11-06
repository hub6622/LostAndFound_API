package com.zjitc.lostandfound_api.mapper;

import com.zjitc.lostandfound_api.pojo.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("insert into sys_file(file_name,file_url,item_id,user_id,create_time,is_avatar) values (#{filename},#{picUrl},#{itemId},#{userId},CURRENT_TIMESTAMP,0)")
    void addItemFile(Integer itemId, String filename, String picUrl,Integer userId);

    @Insert("insert into sys_file(file_name,file_url,user_id,create_time,is_avatar) values(#{filename},#{avatarUrl},#{userId},CURRENT_TIMESTAMP,1)")
    void addUserFile(String filename, String avatarUrl, Integer userId);

    @Update("update sys_file set update_time=CURRENT_TIMESTAMP,file_name=#{filename},file_url=#{avatarUrl} where user_id=#{userId} and isAvatar = 1")
    void updateUserFile(String filename, String avatarUrl, Integer userId);

    @Update("update sys_file set update_time=CURRENT_TIMESTAMP,file_name=#{filename},file_url=#{picUrl} where item_id=#{item_id}")
    void updateItemFile(Integer item_id, String filename, String picUrl);


    List<File> findAll();

    @Delete("delete from sys_file where file_name=#{name}")
    void delFile(String name);
    @Delete("delete from sys_file where user_id=#{id}")
    void delFileByUserId(Integer id);
}
