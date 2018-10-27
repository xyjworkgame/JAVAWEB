package com.javaweb.web;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-27-16:28
 */
public class Authority {
    //显示到页面上的权限的名字
    private String displayName;

    //权限对应的 URL 地址: 已权限对应着一个 URL, 例如 Article-1 -> /article1.jsp
    private String url;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Authority(String displayName, String url) {
        this.displayName = displayName;
        this.url = url;
    }

    public Authority() {
    }
}
