package com.yc.sujian.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.yc.sujian.bean.User;
import com.yc.sujian.biz.BizException;
import com.yc.sujian.biz.UserBiz;

@RestController
@SessionAttributes("loginedUser")
public class IndexAction {
	
	@Resource
	UserBiz ubiz;
	
	@Resource
	sujianBackAction sba;
	
	@Resource
	IsujianBackAction isba;

	@ModelAttribute
	public void init(ModelAndView mav) {
		mav.addObject("clist",isba.getC());
	}

	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView index(ModelAndView mav) {
		// 通过远程服务调用方式获取分类信息
		if (mav.getViewName() == null) {
			mav.setViewName("index");
		}
		mav.addObject("alists", isba.getArticles());
		System.out.println("===ViewName" + mav.getViewName());
		return mav;
	}
	
	@GetMapping({"index1.html"})
	public ModelAndView index1(ModelAndView mav,@RequestParam Integer id) {
		mav.addObject("cname", isba.getCname(id));
		mav.addObject("alist", isba.getArticle(id));
		mav.setViewName("index1");
		return mav;
	}
	
	@GetMapping({ "tologin"})
	public ModelAndView tologin(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("login")
	public ModelAndView login(User user, ModelAndView mav, @SessionAttribute(name = "uri", required = false) String uri,
			HttpSession session) {
		try {
			User dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			if (uri != null) {
				// 这是拦截登录的情况
				mav.setViewName("redirect:http://127.0.0.1" + uri);
			} else {
				// 这是用户的主动登录
				mav.setViewName("index");
				System.out.println("登录成功");
			}
			return index(mav);
		} catch (BizException e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.setViewName("login");
		}
		return mav;
	}
	
	
	@GetMapping("out")
	public ModelAndView out(ModelAndView mav, SessionStatus sessionStatus, HttpSession session) {
		// spring mvc 移除会话
		sessionStatus.setComplete();
		return index(mav);
	}
	
	@GetMapping({"details.html"})
	public ModelAndView details(ModelAndView mav) {
		mav.setViewName("details");
		return mav;
	}
}
