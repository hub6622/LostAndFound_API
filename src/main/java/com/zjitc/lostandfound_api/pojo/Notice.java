package com.zjitc.lostandfound_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Integer id;
    private String content;
    private String tradeTime;
    private String contact;
    private Integer authorId;
    private User author;
    private Integer itemId;
    private Integer confirm;
    private String updateTime;
    private Integer recipientId;
    private Integer system;
    private User recipient;
}
