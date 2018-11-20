package com.dotawang.mvpdemo3.model.login;

/**
 * @author Dota.Wang
 * @date 2018/11/20
 * @description
 */

public class User {
    private long id;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
