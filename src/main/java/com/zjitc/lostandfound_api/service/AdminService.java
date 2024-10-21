package com.zjitc.lostandfound_api.service;

import com.zjitc.lostandfound_api.pojo.ItemComment;
import com.zjitc.lostandfound_api.pojo.Notice;
import com.zjitc.lostandfound_api.pojo.User;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public interface AdminService {

    List<User> getAllUser();

    boolean deleteUsers(List<Integer> ids);

    Boolean updateUser(User user);


    Boolean newUser(User user);

    Boolean prohibit(Map<String, Object> params);

    List<User> getUserByParams(String username, String phone);

    List<ItemComment> getAllComment();

    boolean deleteComments(List<Integer> ids);

    boolean deleteReplys(List<Integer> ids);


    Integer login(User user);

    List<Notice> getAllNotice();

    boolean deleteNotice(List<Integer> ids);
}
