##1.Filter:
###1) Filter 是什么？
   1) javaweb 的一个重要的组件，可以对发送到Servelt的请求进行拦截，并对相应进行拦截
   2) Filter 实现了Filter接口的java类
   3) Filter 需要再web.xml 文件中进行配置和映射，(但是web4可以用注解的形式去配置和映射的)
###2)如何创建一个Filter，并把它跑起来
1) 创建一个Filter类：实现Filter接口：public class HelloFilter implements Filter 
2) 在web.xml或者注解进行配置和映射该类(这个跟servlet没什么区别)其中url-pattern 执行该Filter可以拦截那些资源，即可以通过那些url，访问到该Filter
###3)FIlter 相关的API   
1)Filter接口：
1. public void init(FilterConfig config)  类似于Sersvlet 的init方法，在创阿Filter对象后，立即被调用且只被调用一次，FIlter对象将在SErvelt被加载调用
    1. FilterConfig 类似与Servtconfig
    2. 可以在web.xml 文件中配置初始化参数，配置方式也是类似
2. public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)  真正FIlter的逻辑代码需要编写在这个方法，每次拦截都要调用这个方法。
    1. FilterChain : Filter链，多个Filter可以构成一个Filter链，
        
        -- doFilter（SErvletRequest request，SErveltResponse response）: 把请求传给Filter链的下个Filter，若当前Filter是当前链中的最后一个，将把请求给目标SErvelt(JSP)
        
        -- 多个Filter拦截的顺序和<Filter-mapping > 配置的顺序有关，靠前的先被调用
3. public void destroy() ；销毁的Filter所占用的资源的方法
