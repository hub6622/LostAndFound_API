package com.zjitc.lostandfound_api.service.impl;

import com.zjitc.lostandfound_api.mapper.FileMapper;
import com.zjitc.lostandfound_api.mapper.ItemMapper;
import com.zjitc.lostandfound_api.mapper.UserMapper;
import com.zjitc.lostandfound_api.pojo.*;
import com.zjitc.lostandfound_api.service.ItemService;
import com.zjitc.lostandfound_api.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    ItemMapper itemMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    FileMapper fileMapper;

    @Resource
    UserService userService;

    @Override
    public List<Item> findAll() {
        List<Item> itemList = itemMapper.findAll();
        for (Item item:itemList
             ) {
            item.setCategories(itemMapper.getCategoriesByItemId(item.getId()));
        }
        return itemList;
    }

    @Override
    public List<Item> findNewest() {
        List<Item> itemList = itemMapper.findNewest();
        for (Item item:itemList
        ) {
            item.setCategories(itemMapper.getCategoriesByItemId(item.getId()));
        }
        return itemList;
    }

    @Override
    public List<Item> findByCategory(String category) {
        List<Item> itemList = itemMapper.getItemByCategory(category);
        for (Item item:itemList
        ) {
            item.setCategories(itemMapper.getCategoriesByItemId(item.getId()));
        }
        return itemList;
    }

    @Override
    public Item getById(Integer id) {
        return itemMapper.getItemById(id);
    }


    @Override
    public List<ItemComment> getCommentsByItemId(Integer id) {
        List<ItemComment> itemComment = itemMapper.getComments(id);
        for (ItemComment ic : itemComment) {
            ic.setCommentReply(itemMapper.getReply(ic.getId()));
        }
        return itemComment;
    }

    @Override
    public void addComment(String name, String content, Integer itemId) {
        ItemComment itemComment = new ItemComment();
        itemComment.setCommentAuthor(new User(userMapper.getUser(name).getId()));
        itemComment.setContent(content);
        itemComment.setItemId(itemId);

        itemMapper.addComment(itemComment);
        Integer commentId = itemComment.getId();
        itemMapper.addItemCommentReply(itemId, commentId, null);
    }

    @Override
    public void addCommentReply(String name, String content, Integer commentId, Integer itemId) {
        CommentReply commentReply = new CommentReply();
        commentReply.setReplyAuthor(new User(userMapper.getUser(name).getId()));
        commentReply.setContent(content);
        commentReply.setItemId(itemId);
        itemMapper.addCommentReply(commentReply);
        Integer replyId = commentReply.getId();
        itemMapper.addItemCommentReply(null, commentId, replyId);
    }

    @Override
    public void addItem(String name, Map<String, Object> item) {
        Item item1 = new Item();
        String url= (String) item.get("picUrl");
        item1.setTitle((String) item.get("title"));
        item1.setContent((String) item.get("content"));
        item1.setPicUrl(url);
//        item1.setCategory((String) item.get("category"));
        item1.setLostOrFound(Integer.parseInt(item.get("lostOrFound").toString()));
        User user = userMapper.getUser(name);
        item1.setAuthor(user);
        String filename = url.substring(url.lastIndexOf('/') + 1);
        itemMapper.addItem(item1);
        fileMapper.addUserFile( filename, item1.getPicUrl(), user.getId());
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
        String url= (String) item.get("picUrl");
        item1.setId(Integer.parseInt(item.get("id").toString()));
        item1.setTitle((String) item.get("title"));
        item1.setContent((String) item.get("content"));
        item1.setPicUrl((String) item.get("picUrl"));
        List<Integer> categoriesId = (List<Integer>) item.get("categories");

        item1.setLostOrFound(Integer.parseInt(item.get("lostOrFound").toString()));
        String filename = url.substring(url.lastIndexOf('/') + 1);
        fileMapper.updateItemFile(item1.getId(), filename, item1.getPicUrl());
        itemMapper.updateItem(item1);
        for (Integer categoryId:categoriesId
             ) {
            itemMapper.updateItemCategory(categoryId,item1.getId());
        }

    }

    @Override
    public List<Item> findByParams(String category, String title) {
        List<Item> itemList = itemMapper.findByParams(category, title);
        for (Item item:itemList
        ) {
            item.setCategories(itemMapper.getCategoriesByItemId(item.getId()));
        }
        return itemList;
    }

    @Override
    public boolean addCategory(Map<String, Object> params) {
        String categoryName = (String) params.get("categoryName");
        System.out.println("categoryName"+categoryName);
        return itemMapper.addCategory(categoryName);
    }

    @Override
    public Boolean updateCategory(Map<String, Object> params) {
        String categoryName = (String) params.get("categoryName");
        System.out.println("categoryName"+categoryName);
        Integer id = Integer.parseInt(params.get("id").toString());
        System.out.println("updateCategory"+id+"===="+categoryName);
        return itemMapper.updateCategory(categoryName, id);
    }

    @Override
    public boolean deleteCategory(List<Integer> ids) {
        System.out.println("deleteCategory"+ids);
        for (Integer id:ids
             ) {
            itemMapper.delCategory(id);
        }
        return true;
    }


}
