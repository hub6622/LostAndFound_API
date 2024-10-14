package com.zjitc.lostandfound_api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String avatar;
    private String phone;
    private Integer sex;
    private String biography;
    public User(Integer i) {
        this.id = i;
    }
}
