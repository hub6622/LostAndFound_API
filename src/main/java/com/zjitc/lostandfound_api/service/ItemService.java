package com.agileboot.api.service;

import com.agileboot.api.pojo.Item; // 修改了pojo的名字
import com.agileboot.api.pojo.ItemComment; // 修改了pojo的名字

import java.util.List;
import java.util.Map;

public interface ItemService { // 修改了service的名字

    List<Item> findAll(); // 修改了返回类型
    List<Item> findNewest();

    List<Item> findByCategory(String category); // 修改了返回类型

    Item getById(Integer id); // 修改了返回类型

    List<ItemComment> getCommentsByItemId(Integer id); // 修改了方法名和参数名

    void addComment(String name, String content, Integer itemId); // 修改了方法名和参数名

    void addCommentReply(String name, String content, Integer commentId); // 修改了方法名

    void addItem(String name, Map<String, Object> item); // 修改了方法名和参数名

    void updateItemCommentCounts(Integer itemId); // 修改了方法名和参数名

    List<String> findCategory(); // 保持不变

    void updateItemViewCounts(Integer itemId); // 修改了方法名和参数名

    List<Item> findItemByViews(); // 修改了方法名和返回类型

    List<Item> findByUser(Integer userId); // 修改了返回类型

    void delItem(Integer itemId); // 修改了方法名和参数名
}
