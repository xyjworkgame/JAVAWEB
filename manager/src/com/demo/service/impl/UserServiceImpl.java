package com.demo.service.impl;



import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.pojo.Page;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;


public class UserServiceImpl implements UserService {

	//声明日志对象
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//声明Dao层对象
	UserDao ud=new UserDaoImpl();
	//用户登录
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		//打印日志
		logger.debug(uname+"发起登录请求");
		User u=ud.checkUserLoginDao(uname, pwd);
		//判断
		if(u!=null){
			logger.debug(uname+"登录成功");
		}else{
			logger.debug(uname+"登录失败");
		}
		return u;
	}
	//修改用户密码
	@Override
	public int userChangePwdService(String newPwd, int uid) {
		logger.debug(uid+":发起密码请求");
		int index=ud.userChangePwdDao(newPwd,uid);
		if(index>0){
			logger.debug(uid+":密码修改成功");
		}else{
			logger.debug(uid+":密码修改失败");
		}
		return index;
	}
	//获取所有的用户信息
	@Override
	public Page userShowService(int pageNum, int pageSize) {
		//换算查询起始位置
		int pageStart=(pageNum-1)*pageSize;
		List<User> lu=ud.userShowDao(pageStart,pageSize);
		logger.debug("显示所有用户信息："+lu);
		//获取总的条数
		int count=ud.getUserCount();
		//换算总的分页数量
		int pages=(int) Math.ceil(count*1.0/pageSize);
		//创建page对象存储分页相关信息
		Page p=new Page();
		p.setLu(lu);
		p.setPageNum(pageNum);
		p.setCount(count);
		p.setPages(pages);
		p.setPageSize(pageSize);
		p.setPageStart(pageStart);
		return p;
	}
	//用户注册
	@Override
	public int userRegService(User u) {
		return ud.userRegDao(u);
	}

}
