package com.zjitc.lostandfound_api.service.impl;

import com.zjitc.lostandfound_api.mapper.AdminMapper;
import com.zjitc.lostandfound_api.mapper.FileMapper;
import com.zjitc.lostandfound_api.mapper.ItemMapper;
import com.zjitc.lostandfound_api.mapper.UserMapper;
import com.zjitc.lostandfound_api.pojo.*;
import com.zjitc.lostandfound_api.service.AdminService;
import com.zjitc.lostandfound_api.service.ItemService;
import com.zjitc.lostandfound_api.service.UserService;
import com.zjitc.lostandfound_api.utils.EncodeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private ItemService itemService;
    @Resource
    private FileMapper fileMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;
    @Override
    public List<User> getAllUser() {
        return adminMapper.findAllUser();
    }

    @Override
    public boolean deleteUsers(List<Integer> ids) {
        try {
            for (Integer id : ids) {
                // 单个删除逻辑
                adminMapper.deleteUser(id);
                fileMapper.delFileByUserId(id);;
                itemService.delItem(itemMapper.getItemIdByUser(id));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Boolean updateUser(User user) {
        adminMapper.updateUser(user);
        return true;
    }

    @Override
    public Boolean newUser(User user) {
        EncodeUtil encodeUtil = new EncodeUtil();
        user.setPassword(encodeUtil.Md5Encode("12345678"));
        String filename = null;
        if (user.getAvatar() != null){
            filename = user.getAvatar().substring(user.getAvatar().lastIndexOf('/') + 1);
        }
        System.out.println(filename);
        adminMapper.newUser(user);
        if (user.getAvatar() == null) {
            return true;
        } else {
            fileMapper.addUserFile(filename, user.getAvatar(), user.getId());
        }
        return true;
    }

    @Override
    public Boolean prohibit(Map<String, Object> params) {
        Integer status = Integer.valueOf(params.get("status").toString());
        if (status == 1){
            status = 0;
        }else {
            status = 1;
        }
        return adminMapper.prohibit(Integer.valueOf(params.get("id").toString()), status);
    }

    @Override
    public List<User> getUserByParams(String username, String phone) {
        if (username != null) {
            username = username.trim();
        }
        if (phone != null) {
            phone = phone.trim();
        }
        return adminMapper.getUserByParams(username,phone);

    }

    @Override
    public List<ItemComment> getAllComment() {
        List<ItemComment> itemComment = itemMapper.getAllComments();
        List<CommentReply> commentReply = itemMapper.getAllReply();
        System.out.println(commentReply);
        try {
            ItemComment itemComment1 = itemComment.get(0);
            itemComment1.setCommentReply(commentReply);
            itemComment.set(0, itemComment1);
            return itemComment;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteComments(List<Integer> ids) {
        for (Integer commentId:ids
             ) {
            userMapper.delCommentById(commentId);
            List<Integer> replyIds = userMapper.findReplyIdByCommentId(commentId);
            Integer itemId = itemMapper.findItemIdByCommentId(commentId);
            userMapper.subtractCommentCounts(replyIds.size(), itemId);
            for (Integer id : replyIds) {
                userMapper.delReplyById(id);
            }
            userMapper.delArticleCommentReplyByCommentId(commentId);
        }
        return true;
    }

    @Override
    public boolean deleteReplys(List<Integer> ids) {
        for (Integer replyId:ids
             ) {
            userMapper.delReplyById(replyId);
            userMapper.delArticleCommentReplyByReplyId(replyId);
        }
        return true;
    }

    @Override
    public Integer login(User user) {
        EncodeUtil encodeUtil = new EncodeUtil();
        if (encodeUtil.checkPassword(userMapper.getPwd(user.getName()), user.getPassword())){
            if(adminMapper.isAdmin(user.getName())){
                return 1;
            }else{
                return 2;
            }
        } else {
            return 3;
        }
    }

    @Override
    public List<Notice> getAllNotice() {
        return userMapper.getAllNotice();
    }

    @Override
    public boolean deleteNotice(List<Integer> ids) {
        for (Integer id:ids
             ) {
            adminMapper.deleteNotice(id);
        }
        return true;
    }

    @Override
    public List<Category> findCategory() {
        return adminMapper.findAllCategory();
    }

    @Override
    public void addNotice(String noticeContent, String token) {
        Integer userId = userService.getUserId(token);
        adminMapper.addNotice(noticeContent,userId);
    }


}
