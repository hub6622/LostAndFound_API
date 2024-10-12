package com.zjitc.lostandfound_api.mapper;


import com.zjitc.lostandfound_api.pojo.ItemComment;
import com.zjitc.lostandfound_api.pojo.CommentReply;
import com.zjitc.lostandfound_api.pojo.Notice;
import com.zjitc.lostandfound_api.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into sys_user(username,password,nickname) values (#{name},#{password},#{name})")
    boolean register(User user);
    User getUser(String name);
    @Select("select * from t_comments where author_id=#{userId}")
    List<ItemComment> getComments(Integer userId);
    @Select("select * from t_comment_reply where author_id=#{userId}")
    List<CommentReply> getReply(Integer userId);
    @Delete("delete from t_comments where id=#{commentId}")
    void delCommentById(Integer commentId);
    @Delete("delete from t_comment_reply where id=#{replyId}")
    void delReplyById(Integer replyId);
    @Delete("delete from t_item_comment_reply where comment = #{commentId}")
    void delArticleCommentReplyByCommentId(Integer commentId);

    @Delete("delete from t_item_comment_reply where reply = #{replyId}")
    void delArticleCommentReplyByReplyId(Integer replyId);
    @Select("select reply from t_item_comment_reply where comment = #{commentId}")
    List<Integer> findReplyIdByCommentId(Integer commentId);

    @Select("select password from sys_user where username=#{userName}")
    String getPwd(String userName);

    @Update("update sys_user set password=#{password} where user_id=#{id}")
    void updateUserPwd(User user);
    @Update("update sys_user set email=#{email} where user_id=#{id}")
    void updateUserEmail(User user);

    @Update("update sys_user set avatar=#{avatarUrl} where user_id=#{userId}")
    void updateAvatar(String avatarUrl,Integer userId);
    @Insert("insert into sys_notice(content,tradeTime,contact,author_id,item_id,updateTime)" +
            " values( #{content},#{tradeTime},#{contact},#{authorId},#{itemId},CURRENT_TIMESTAMP)")
    void sendContact(Notice notice);

    @Update("update t_item set comment_counts = comment_counts - #{count} where id = #{id}")
    void subtractCommentCounts(Integer count,Integer id);
}
