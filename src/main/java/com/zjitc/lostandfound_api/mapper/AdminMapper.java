package com.zjitc.lostandfound_api.mapper;

import com.zjitc.lostandfound_api.pojo.Category;
import com.zjitc.lostandfound_api.pojo.CommentReply;
import com.zjitc.lostandfound_api.pojo.ItemComment;
import com.zjitc.lostandfound_api.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("SELECT user_id AS id, " +
            "       username AS name, " +
            "       biography, " +
            "       email, " +
            "       phone_number AS phone, " +
            "       sex, " +
            "       avatar, " +
            "       password, " +
            "       status, " +
            "       login_date AS loginTime, " +
            "       is_admin AS isAdmin, " +
            "       create_time AS createTime " +
            "FROM sys_user")
    List<User> findAllUser();

    @Delete("DELETE FROM sys_user WHERE user_id = #{id}")
    Boolean deleteUser(Integer id);

    @Update("update sys_user set username=#{name},email=#{email},phone_number=#{phone}," +
            "sex=#{sex},avatar=#{avatar},is_admin=#{isAdmin},status=#{status} where user_id=#{id}")
    void updateUser(User user);


    @Insert("insert into sys_user(username,email,phone_number,sex,avatar,is_admin,create_time,status) " +
            "values(#{name},#{email},#{phone},#{sex},#{avatar},#{isAdmin},CURRENT_TIMESTAMP,#{status})")
    void newUser(User user);

    @Update("update sys_user set status=#{status} where user_id=#{id}")
    Boolean prohibit(Integer id, Integer status);

    @Select("select user_id AS id," +
            "       username AS name, " +
            "       biography, " +
            "       email, " +
            "       phone_number AS phone, " +
            "       sex, " +
            "       avatar, " +
            "       password, " +
            "       status, " +
            "       login_date AS loginTime, " +
            "       is_admin AS isAdmin, " +
            "       create_time AS createTime " +
            "from sys_user where username like concat('%',#{username},'%') or phone_number like concat('%',#{phone},'%')")
    List<User> getUserByParams(String username, String phone);

    @Select("select is_admin from sys_user where username=#{name}")
    boolean isAdmin(String name);

    @Delete("delete from sys_notice where id=#{id}")
    void deleteNotice(Integer id);

    @Select("select * from t_category")
    List<Category> findAllCategory();

    @Insert("insert into sys_notice(content,author_id,confirm,updateTime,recipient_id) values(#{noticeContent},#{userId},0,CURRENT_TIMESTAMP,0)")
    void addNotice(String noticeContent, Integer userId);
}
