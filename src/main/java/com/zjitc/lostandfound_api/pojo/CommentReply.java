package com.zjitc.lostandfound_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentReply {
    private Integer id;
    private User replyAuthor;
    private String replyTime;
    private Integer itemId;
    private String content;
}
