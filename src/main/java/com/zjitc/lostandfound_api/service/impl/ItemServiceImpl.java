package com.zjitc.lostandfound_api.service.impl;

import com.zjitc.lostandfound_api.config.MinioConfig;
import com.zjitc.lostandfound_api.mapper.ItemMapper; // 修改了mapper的名字
import com.zjitc.lostandfound_api.mapper.UserMapper;
import com.zjitc.lostandfound_api.pojo.Item; // 修改了pojo的名字
import com.zjitc.lostandfound_api.pojo.ItemComment; // 修改了pojo的名字
import com.zjitc.lostandfound_api.pojo.CommentReply;
import com.zjitc.lostandfound_api.pojo.User;
import com.zjitc.lostandfound_api.service.ItemService; // 修改了service的名字
import com.zjitc.lostandfound_api.service.UserService;
import com.zjitc.lostandfound_api.utils.MinioUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService { // 修改了service impl的名字
    @Resource
    ItemMapper itemMapper; // 修改了mapper的名字
    @Resource
    UserMapper userMapper;

    @Resource
    UserService userService;

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public List<Item> findNewest() {
        return itemMapper.findNewest();
    }

    @Override
    public List<Item> findByCategory(String category) {
        return itemMapper.getItemByCategory(category); // 修改了方法名
    }

    @Override
    public Item getById(Integer id) {
        return itemMapper.getItemById(id); // 修改了方法名和返回类型
    }

    @Override
    public List<ItemComment> getCommentsByItemId(Integer id) { // 修改了方法名
        List<ItemComment> itemComment = itemMapper.getComments(id); // 修改了返回类型
        for (ItemComment ic : itemComment) {
            ic.setCommentReply(itemMapper.getReply(ic.getId())); // 修改了方法名
        }
        return itemComment;
    }

    @Override
    public void addComment(String name, String content, Integer itemId) { // 修改了方法名和参数名
        ItemComment itemComment = new ItemComment(); // 修改了pojo的名字
        itemComment.setCommentAuthor(new User(userMapper.getUser(name).getId()));
        itemComment.setContent(content);
        itemComment.setItemId(itemId);

        itemMapper.addComment(itemComment); // 返回的是受影响的行数
        Integer commentId = itemComment.getId(); // 返回的是插入后自增的id
        itemMapper.addItemCommentReply(itemId, commentId, null); // 修改了方法名和参数名
    }

    @Override
    public void addCommentReply(String name, String content, Integer commentId, Integer itemId) {
        CommentReply commentReply = new CommentReply();
        commentReply.setReplyAuthor(new User(userMapper.getUser(name).getId()));
        commentReply.setContent(content);
        commentReply.setItemId(itemId);
        itemMapper.addCommentReply(commentReply); // 返回的是受影响的行数
        Integer replyId = commentReply.getId(); // 返回的是插入后自增的id
        itemMapper.addItemCommentReply(null, commentId, replyId); // 修改了方法名和参数名
    }

    @Override
    public void addItem(String name, Map<String, Object> item) { // 修改了方法名
        Item item1 = new Item(); // 修改了pojo的名字
        item1.setTitle((String) item.get("title"));
        item1.setContent((String) item.get("content"));
        item1.setPicUrl((String) item.get("picUrl"));
        item1.setCategory((String) item.get("category"));
        item1.setLostOrFound(Integer.parseInt(item.get("lostOrFound").toString()));
        item1.setAuthor(new User(userMapper.getUser(name).getId()));
        System.out.println("item1++++" + item1);
        itemMapper.addItem(item1); // 修改了方法名
    }

    @Override
    public void updateItemCommentCounts(Integer id) { // 修改了方法名
        itemMapper.updateItemCommentCounts(id); // 修改了方法名
    }

    @Override
    public List<String> findCategory() {
        return itemMapper.findAllCategory(); // 保持不变
    }

    @Override
    public void updateItemViewCounts(Integer itemId) { // 修改了方法名
        itemMapper.updateViewCounts(itemId); // 修改了方法名
    }

    @Override
    public List<Item> findItemByViews() { // 修改了方法名和返回类型
        return itemMapper.findItemByViews(); // 修改了方法名
    }

    @Override
    public List<Item> findByUser(Integer userId) { // 修改了返回类型
        return itemMapper.findByUserName(userId); // 保持不变
    }

    @Override
    public void delItem(List<Integer> ids) {
        for (Integer id : ids) {
            itemMapper.delItem(id);
            List<Integer> commentIds = itemMapper.findCommentIdByItemId(id);
            for (Integer cId : commentIds) {
                userService.delComment(cId, id);
            }
            itemMapper.delItemCommentReplyByItemId(id);
        }
    }

    @Override
    public void updateItem(Map<String, Object> item) {
        Item item1 = new Item();
        item1.setId(Integer.parseInt(item.get("id").toString()));
        item1.setTitle((String) item.get("title"));
        item1.setContent((String) item.get("content"));
        item1.setPicUrl((String) item.get("picUrl"));
        item1.setCategory((String) item.get("category"));
        item1.setLostOrFound(Integer.parseInt(item.get("lostOrFound").toString()));
        itemMapper.updateItem(item1);
    }

    @Override
    public List<Item> findByParams(String category, String title) {
        return itemMapper.findByParams(category, title);
    }


}
