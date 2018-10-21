package com.javaweb.el;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-21-21:00
 */
public class SubElFunction {


    public static String sub(String str,int begin,int last){

        String str1= str.substring(begin,last);
        return str1;
    }

}
