package com.yc.sujian.biz;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.sujian.bean.User;
import com.yc.sujian.bean.UserExample;
import com.yc.sujian.dao.UserMapper;



@Service
public class UserBiz {
	
	@Resource
	UserMapper um;
	
	public User login(User user) throws BizException {
		UserExample ue = new UserExample();
		ue.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> list = um.selectByExample(ue);
		if(list.size()!=1) {
			throw new BizException("用户名或密码错误!");
		}
		return list.get(0);
	}
	
	
}
