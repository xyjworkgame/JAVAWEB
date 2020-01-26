package com.javaweb.el;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-20-17:08
 */
public class Customer1 {

    private int id;
    private String Name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer1(int id, String name, int age) {
        this.id = id;
        Name = name;
        this.age = age;
    }
}
