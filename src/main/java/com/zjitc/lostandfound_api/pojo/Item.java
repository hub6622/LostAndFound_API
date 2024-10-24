package com.zjitc.lostandfound_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer id;
    private List<String> categories;
    private String title;
    private User author;
    private String picUrl;
    private String createTime;
    private Integer viewCounts;
    private Integer commentCounts;
    private String content;
    private Integer commentId;
    private Integer lostOrFound;
}
