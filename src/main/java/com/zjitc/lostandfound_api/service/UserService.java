package com.zjitc.lostandfound_api.service;


import com.zjitc.lostandfound_api.pojo.ItemComment;
import com.zjitc.lostandfound_api.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean register(User user);

    boolean login(User user);
    User getInfo(String name);
    String getUserName(String token);

    Integer getUserId(String token);

    List<ItemComment> getUserComment(Integer userId);

    void delComment(Integer commentId, Integer itemId);
    void delReply(Integer replyId);

    Boolean confirmPwd(String pwd, String token);

    String updateUserInfo(Map<String, Object> userInfo);

    void updateAvatar(String avatarUrl,Integer userId);

    void sendContact(Map<String, Object> params, String token);
}
