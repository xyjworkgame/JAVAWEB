package com.javaweb.web;

import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-27-16:28
 */
public class User {
    private String username;
    private List<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public User(String username, List<Authority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public User() {
    }
}
