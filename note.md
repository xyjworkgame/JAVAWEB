# servlet

## 1. 在web.xml 中配置servlet
```lxml
    <!--配置和映射Servlet-->
    <servlet>
        <!--Servlet 注册的名字-->
        <servlet-name>helloservlet</servlet-name>
        <!--Servlet 的全类名-->
        <servlet-class>com.study.servlet.HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <!--需要和某一个Servlet 节点的servlet-name 子节点的文本节点一致-->
        <servlet-name>helloservlet</servlet-name>
        <!--映射具体的访问路径：/ 代表当前的web应用的目录-->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```
## 2. 编写的类要进行继承HttpServlet
    并且复写 service方法
## 3. servlet 的过程
浏览器发送请求到服务器，服务器根据请求URL地址中的URL信息在webapps 目录下，找到对应的项目文件夹
然后在web.xml 中检索对应的servlet，找到后调用并执行servlet

web请求地址： 服务器地址：端口号/webapps下的文件夹名称/包名

## 4. servelt 的生命周期
```java
package com.study.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-03-22:05
 * 
 */
public class SecondServlet implements Servlet {
    //初始化方法，在servlet第一次加载内容的时候调用
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Second Servlet init ...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    // service，真正处理请求的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }
    //销毁的方法
    @Override
    public void destroy() {

    }
}
 
```
servlet 的生命周期；
    1. 从第一次调用到内存，到服务器关闭
    2. 如果servlet 在web.xml 中配置了load-on-startup，生命周期从服务器启动到服务器关闭
    注意 ：  
        1. init 方法 是对servlet 进行初始化的方法，会在servelt第一次加载进行存储执行
        2. destroy 是对servlet 销毁执行，也就服务器关闭。
        3. load-up-startup 的数字表示加载顺序，数字小，表示更加优先

## 5. servletMethod
### 1. service方法 和doGet 和doPost 方法的区别
1. service方法 ： 可以处理get/post方式的请求，如果servlet中有service 方法，会优先调用service方法对请求处理
2. doGet ： 处理 get方式请求
3. doPost：处理post请求


### 注意 ：
__如果在覆写的service 方法中调用了父类的service方法，（super.service()方法），
则service处理完之后，还会根据请求方式响应的类别，再次父类调用，所以一般情况下，不再覆写service调用父类service，
避免出现405__

### servlet 的常见错误


#### 404 错误： 资源未找到
1. 原因一 ： 在请求地址中的servlet 的别名书写错误
2. 原因二 ： 虚拟项目名称拼写错误

#### 500错误 ：内部服务器错误
1. 错误一 ： 类未找到，或者拼写错误
2. 错误二 ： service方法体的执行错误
#### 405 错误 ：请求方法不支持
1. 原因 ： 请求方式和servlet中的方法不匹配所造成的
2. 解决： 尽量使用service方法进行请求处理，并且不要再service方法中调用父类的service

### request对象学习
1. 作用 ： request对象中封存了当前请求的所有请求信息
2. 使用 ： 获取请求头数据，获取请求行数据，获取用户数据
3. 注意： requests对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法

### response 对象学习
1. 作用 ： 用来响应数据到浏览器的一个对象
2. 使用：
    * 			设置响应头
    * 				setHeader(String name,String value);//在响应头中添加响应信息，但是同键会覆盖
    * 				addHeader(String name,String value);//在响应头中添加响应信息，但是不会覆盖。
    * 			设置响应状态
    * 				sendError(int num,String msg);//自定义响应状态码。
    * 			设置响应实体
    * 				resp.getWrite().write(String str);//响应具体的数据给浏览器
    * 		设置响应编码格式：
    * 				resp.setContentType("text/html;charset=utf-8");
    * 		总结：
    * 			service请求处理代码流程：
    * 				设置响应编码格式
    * 				获取请求数据
    * 				处理请求数据
    * 					数据库操作（MVC思想）	
    *   			响应处理结果

### servlet 的使用流程
1. 设置请求编码格式
2. 设置响应编码格式
3. 获取请求信息
4. 处理请求信息
5. 响应处理结果

### 请求转发学习
 作用 ： 实现多个servlet 联动操作处理处理请求，可以避免代码冗余，让servlet的职责更加明确
 使用 ：req.getRequestDispatcher("转发的地址").forward(req,resp)
 地址是相对路径


## Cookie 学习
Cookie学习:
  		作用:解决了发送的不同请求的数据共享问题
  		使用:
  			Cookie的创建和存储
  				//创建Cookie对象
  					Cookie c=new Cookie(String name, String value);
  				//设置cookie(可选)
  					//设置有效期
  					c.setMaxAge(int seconds);
 					//设置有效路径
 					c.setPath(String uri)
 				//响应Cookie信息给客户端
 					resp.addCookie(c);
 			Cookie的获取
 				//获取Cookie信息数组
 				Cookie[] cks=req.getCookies();
 				//遍历数组获取Cookie信息
 					使用for循环遍历即可，示例：
	 					if(cks!=null){
							for(Cookie c:cks){
								String name=c.getName();
								String value=c.getValue();
								System.out.println(name+":"+value);
							}
						}
 		注意:
 			一个Cookie对象存储一条数据。多条数据，可以多创建几个Cookie对象进行存储。
 		特点:
 			浏览器端的数据存储技术。
 			存储的数据声明在服务器端。
 			临时存储:存储在浏览器的运行内存中，浏览器关闭即失效。
 			定时存储:设置了Cookie的有效期，存储在客户端的硬盘中，在有效期内符合路径要求的请求都会附带该信息。
 			默认cookie信息存储好之后，每次请求都会附带，除非设置有效路径