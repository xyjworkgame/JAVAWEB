package com.javaweb.web;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-27-16:53
 */
public class UserDao {

    private static Map<String,User> users;

    private static List<Authority> authorities = null;
    static {

        authorities = new ArrayList<>();
        authorities.add(new Authority("Article-1","/article-1.jsp"));
        authorities.add(new Authority("Article-2","/article-2.jsp"));
        authorities.add(new Authority("Article-3","/article-3.jsp"));
        authorities.add(new Authority("Article-4","/article-4.jsp"));

        //这里是数据，但是在实际上是以数据库获取数据的
        users = new HashMap<String, User>();

        User user1 = new User("AAA",authorities.subList(0,2));
        users.put("AAA",user1);

        user1 = new User("BBB",authorities.subList(2,4));
        users.put("BBB",user1);
    }

    public static void update(String username, String[] authorities) {
    }

    public User get(String username){


        return users.get(username);
    }
     public static void update(String username, List<Authority> authorities){

         users.get(username).setAuthorities(authorities);
    }

    public List<Authority> getAuthorities(){
        return authorities;
    }
    public List<Authority> getAuthorities(String[] urls){
        List<Authority> authorities2 = new ArrayList<>();

        for (Authority authority : authorities){

            if (urls != null){
                for (String url : urls){
                    if (url.equals(authority.getUrl())) {

                        authorities2.add(authority);
                    }
                }

            }
        }
        return authorities;
    }
}
