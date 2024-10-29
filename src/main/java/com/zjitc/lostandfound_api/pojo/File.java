package com.zjitc.lostandfound_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    private Integer id;
    private String fileName;
    private User user;
    private Integer userId;
    private String createTime;
    private String updateTime;
    private String fileUrl;
    private Integer isAvatar;
    private Integer itemId;
}
