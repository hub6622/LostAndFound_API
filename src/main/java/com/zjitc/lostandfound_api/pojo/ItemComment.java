package com.agileboot.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemComment {
    private Integer id;
    private User commentAuthor;
    private String commentTime;
    private String content;
    private Integer commentOrder;
    private List<CommentReply> commentReply;
}
