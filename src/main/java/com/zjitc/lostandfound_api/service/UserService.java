package com.zjitc.lostandfound_api.service;


import com.zjitc.lostandfound_api.pojo.ItemComment;
import com.zjitc.lostandfound_api.pojo.Notice;
import com.zjitc.lostandfound_api.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean register(User user);

    Integer login(User user);

    User getInfo(String name);

    String getUserName(String token);

    Integer getUserId(String token);

    List<ItemComment> getUserComment(Integer userId);

    void delComment(Integer commentId, Integer itemId);

    void delReply(Integer replyId);

    Boolean confirmPwd(String pwd, String token);

    void updateUserInfo(Map<String, Object> userInfo, String token);

    void updateAvatar(String avatarUrl, Integer userId);

    void sendContact(Map<String, Object> params, String token);

    List<Notice> getNotice(String token);

    void confirmNotice(Map<String, Object> notice);

    List<Notice> getNoticeHistory(String token);

    void updateUserPwd(Map<String, Object> pwdInfo, String token);

    Boolean resetPwd(Integer id);

    void setLoginTime(String name);

}
