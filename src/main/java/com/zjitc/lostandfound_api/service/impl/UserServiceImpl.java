package com.zjitc.lostandfound_api.service.impl;


import com.auth0.jwt.interfaces.Claim;
import com.zjitc.lostandfound_api.config.MinioConfig;
import com.zjitc.lostandfound_api.mapper.FileMapper;
import com.zjitc.lostandfound_api.mapper.ItemMapper;
import com.zjitc.lostandfound_api.mapper.UserMapper;
import com.zjitc.lostandfound_api.pojo.ItemComment;
import com.zjitc.lostandfound_api.pojo.CommentReply;
import com.zjitc.lostandfound_api.pojo.Notice;
import com.zjitc.lostandfound_api.pojo.User;
import com.zjitc.lostandfound_api.service.UserService;
import com.zjitc.lostandfound_api.utils.EncodeUtil;
import com.zjitc.lostandfound_api.utils.JwtToken;
import com.zjitc.lostandfound_api.utils.MinioUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    FileMapper fileMapper;
    EncodeUtil encodeUtil = new EncodeUtil();

    @Override
    public boolean register(User user) {
        user.setPassword(encodeUtil.Md5Encode(user.getPassword()));
        if(user.getAvatar()==null) user.setAvatar("http://www.ppg6.store:9000/public/d5f11b41-4b24-49ae-9268-283a580b7767.png");
        String filename = user.getAvatar().substring(user.getAvatar().lastIndexOf('/') + 1);
        System.out.println(filename);
        Integer id = userMapper.register(user);
        if(user.getAvatar()==null){
            return true;
        }else{
            fileMapper.addUserFile(filename, user.getAvatar(), id);
        }
        return true;
    }

    @Override
    public Integer login(User user) {
        String Pwd = userMapper.getPwd(user.getName());
        try {
            if (encodeUtil.checkPassword(Pwd, user.getPassword())){
                if(userMapper.status(user.getName()) == 1){
                    return 1;
                }else {
                    return 2;
                }
            }else {
                return 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 4;
        }
    }

    @Override
    public User getInfo(String name) {
        return userMapper.getUser(name);
    }

    @Override
    public String getUserName(String token) {
        JwtToken jwtToken = new JwtToken();
        Map<String, Claim> map = jwtToken.verify(token);
        return map.get("username").asString();
    }

    @Override
    public Integer getUserId(String token) {
        JwtToken jwtToken = new JwtToken();
        Map<String, Claim> map = jwtToken.verify(token);
        return map.get("id").asInt();

    }

    @Override
    public List<ItemComment> getUserComment(Integer userId) {
        List<ItemComment> itemComment = userMapper.getComments(userId);
        List<CommentReply> commentReply = userMapper.getReply(userId);
        ItemComment itemComment1 = itemComment.get(0);
        itemComment1.setCommentReply(commentReply);
        itemComment.set(0, itemComment1);
        return itemComment;
    }

    @Override
    public void delComment(Integer commentId, Integer itemId) {
        userMapper.delCommentById(commentId);
        List<Integer> replyIds = userMapper.findReplyIdByCommentId(commentId);
        System.out.println("size" + replyIds.size());
        userMapper.subtractCommentCounts(replyIds.size(), itemId);
        System.out.println("replyIds" + replyIds);
        for (Integer id : replyIds) {
            userMapper.delReplyById(id);
        }
        userMapper.delArticleCommentReplyByCommentId(commentId);
    }

    @Override
    public void delReply(Integer replyId) {
        userMapper.delReplyById(replyId);
        userMapper.delArticleCommentReplyByReplyId(replyId);
    }

    @Override
    public Boolean confirmPwd(String pwd, String token) {
        String realPwd = userMapper.getPwd(getUserName(token));
        try {
            return encodeUtil.checkPassword(realPwd, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateUserInfo(Map<String, Object> userInfo, String token) {
        User user = new User();
        user.setId(getUserId(token));
        user.setEmail(userInfo.get("email").toString());
        user.setSex(Integer.valueOf(userInfo.get("sex").toString()));
        user.setBiography(userInfo.get("biography").toString());
        user.setPhone(userInfo.get("phone").toString());
        userMapper.updateUserInfo(user);
    }

    @Override
    public void updateAvatar(String avatarUrl, Integer userId) {
        String filename = avatarUrl.substring(avatarUrl.lastIndexOf('/') + 1);
        System.out.println(filename);
        fileMapper.updateUserFile(filename, avatarUrl, userId);
        userMapper.updateAvatar(avatarUrl, userId);
    }

    @Override
    public void sendContact(Map<String, Object> params, String token) {
        Notice notice = new Notice();
        notice.setContact(params.get("contact").toString());
        notice.setAuthorId(getUserId(token));
        notice.setContent(params.get("content").toString());
        notice.setRecipientId(Integer.parseInt(params.get("recipientId").toString()));
        // 定义输入日期时间格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        // 解析输入的日期时间字符串
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(params.get("tradeTime").toString(), inputFormatter.withZone(ZoneId.of("Z")));
        // 转换为 LocalDateTime
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        // 定义输出日期时间格式
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化为 MySQL 支持的格式
        notice.setTradeTime(localDateTime.format(outputFormatter));
        notice.setItemId(Integer.parseInt(params.get("itemId").toString()));
        userMapper.sendContact(notice);
    }

    @Override
    public List<Notice> getNotice(String token) {
        return userMapper.getNotice(getUserId(token));
    }

    @Override
    public void confirmNotice(Integer id) {
        userMapper.updateNoticeConfirm(id);
    }

    @Override
    public List<Notice> getNoticeHistory(String token) {
        return userMapper.getNoticeHistory(getUserId(token));
    }

    @Override
    public void updateUserPwd(Map<String, Object> pwdInfo, String token) {
        User user = new User();
        user.setId(getUserId(token));
        user.setPassword(encodeUtil.Md5Encode(pwdInfo.get("password").toString()));
        userMapper.updateUserPwd(user);
    }

    @Override
    public Boolean resetPwd(Integer id) {
        String pwd = encodeUtil.Md5Encode("12345678");
        return userMapper.resetPwd(pwd, id);
    }

    @Override
    public void setLoginTime(String name) {
        userMapper.setLoginTime(name);
    }
}
