package com.javaweb.el;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-19-17:50
 */
public class Customer {

    /**
     * 只要这个类有无参构造器，可以利用反射创建对象的话，就是javabean
     *
     */

    private Integer id;
    private String name;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer() {

        System.out.println("Customer's constructor");
    }
}
