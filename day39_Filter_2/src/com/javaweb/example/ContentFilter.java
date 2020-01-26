package com.javaweb.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-28-16:48
 */

public class ContentFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //1.获取请求content参数的值
        String content = request.getParameter("content");
        HttpServletRequest req = new MyHttpServletRequest(request);
        //2.把其中fuck，shit等等字符串替换为型号
        if (content.contains(" fuck ")){
            //ServletRequest，HttpServletRequest 中没有提供诸如setParameter（paramName，paramValue）
            //类似于这样的方法

            //目标：该表HttpServletRequest 的getParameter(String )方法的行为：若该方法的返回值中
            //包含" fuck ",则替换为"****"

            //1.若对于一个类的方法不满意，需要进行重写，最常见的方式是，继承父类，重写方法
            //若实现则需要继承org.apache.catalina.connector.RequestFacade 而这仅是Tomacat
            //服务器的实现，若更换服务器，则无法使用 ×

            //2.直接写一个HttpServletRequest 接口的实现类：无法实现其中方法。 ×

            //3.装饰目标的HttpServletRequest 对象： 装饰其getParameter方法，而其他方法还和其实现相同
            //创建一个类，该类实现HTTPServletRequest接口，把当前doFilter中的request传入到该类中，作为
            //其成员变量，使用该成员变量去实现接口的全部方法

        }
        //3. 转到目标页面
        filterChain.doFilter(request,response);
    }
}
