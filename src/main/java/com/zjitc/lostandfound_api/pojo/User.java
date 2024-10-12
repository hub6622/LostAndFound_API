package com.agileboot.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String nickname;
    private String password;
    private String email;
    private String avatar;

    public User(Integer i) {
        this.id = i;
    }
}
