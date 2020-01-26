package com.javaweb.test;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-31-19:07
 */
public class Customer implements HttpSessionBindingListener , HttpSessionActivationListener
                        , Serializable {

    private static final long serialVersionUID = 1L;

    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("绑定到session");

        Object value = httpSessionBindingEvent.getValue();
        System.out.println(value == this);
        System.out.println(httpSessionBindingEvent.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

        System.out.println("从session中解除绑定");
    }

    /**
     * 活化：从硬盘里读出来
     * 钝化：写到硬盘里
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

        System.out.println("从内存中写到硬盘");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

        System.out.println("从磁盘中读取");
    }

    @Override
    public String toString() {
       return super.toString() + ",time : " + time;
    }
}
