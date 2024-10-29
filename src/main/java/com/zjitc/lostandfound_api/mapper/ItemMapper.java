package com.zjitc.lostandfound_api.mapper;

import com.zjitc.lostandfound_api.pojo.Category;
import com.zjitc.lostandfound_api.pojo.Item; // 修改了pojo的名字
import com.zjitc.lostandfound_api.pojo.ItemComment; // 修改了pojo的名字
import com.zjitc.lostandfound_api.pojo.CommentReply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper { // 修改了mapper的名字

    List<Item> findAll(); // 修改了返回类型
    List<Item> findNewest();

    List<Item> getItemByCategory(String category); // 修改了方法名

    Item getItemById(Integer id); // 修改了方法名和返回类型

    List<ItemComment> getComments(Integer id); // 修改了返回类型

    List<CommentReply> getReply(Integer id); // 保持不变

    Integer addComment(ItemComment itemComment); // 修改了参数类型

    Integer addCommentReply(CommentReply commentReply); // 保持不变

    @Insert("insert into t_item_comment_reply(item,comment,reply) values (#{itemId},#{commentId},#{replyId})") // 修改了表名和字段名
    void addItemCommentReply(Integer itemId, Integer commentId, Integer replyId); // 修改了方法名和参数名
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addItem(Item item);

    @Update("update t_item set comment_counts = comment_counts + 1 where id = #{itemId}") // 修改了表名和字段名
    void updateItemCommentCounts(Integer itemId); // 修改了方法名
    @Update("update t_item set title=#{title}, content=#{content}, picUrl=#{picUrl}, lostfound=#{lostOrFound} where id = #{id}")
    void updateItem(Item item);
    @Select("select item from t_item_comment_reply where comment = #{commentId}") // 修改了表名和字段名
    Integer findItemIdByCommentId(Integer commentId); // 修改了方法名和返回类型
    @Select("select distinct comment from t_item_comment_reply where item = #{itemId}") // 修改了表名和字段名
    List<Integer> findCommentIdByItemId(Integer itemId); // 修改了方法名和参数名

    @Select("select distinct category_name from t_category") // 修改了表名
    List<String> findAllCategory(); // 保持不变

    @Update("update t_item set view_counts = view_counts + 1 where id = #{itemId}") // 修改了表名和字段名
    void updateViewCounts(Integer itemId); // 修改了方法名

    @Select("select * from t_item order by view_counts desc limit 0,5") // 修改了表名
    List<Item> findItemByViews(); // 修改了方法名和返回类型

    List<Item> findByUserName(Integer userId); // 修改了返回类型

    @Delete("delete from t_item where id = #{itemId}") // 修改了表名和字段名
    void delItem(Integer itemId); // 修改了方法名和参数名

    @Delete("delete from t_item_comment_reply where item = #{itemId}") // 修改了表名和字段名
    void delItemCommentReplyByItemId(Integer itemId); // 修改了方法名和参数名

    List<Item> findByParams(String category, String title);

    List<CommentReply> getAllReply();

    List<ItemComment> getAllComments();
    List<String> getCategoriesByItemId(Integer id);

    void updateItemCategory(String categoryName, Integer itemId);

    @Insert("insert into t_category(category_name,create_time) values(#{categoryName},CURRENT_TIMESTAMP)")
    boolean addCategory(String categoryName);

    @Update("update t_category set category_name=#{categoryName},update_time=CURRENT_TIMESTAMP where id = #{id}")
    Boolean updateCategory(String categoryName, Integer id);

    @Delete("delete from t_category where id = #{id}")
    void delCategory(Integer id);

    @Delete("delete from t_item_category where item_id = #{id}")
    void delItemCategory(Integer id);
}
