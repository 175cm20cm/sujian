package com.yc.sujian.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sujian.bean.Category;
import com.yc.sujian.dao.CategoryMapper;

@RestController
public class CategoryAction {

	@Resource
	private CategoryMapper cm;

	@GetMapping("getC")
	public List<Category> getC() {
		List<Category> list = cm.selectByExample(null);
		System.out.println("category:" + list.get(0).getName());
		return list;

	}

	@GetMapping("getCname")
	public Category getCname(Integer id) {
		return cm.selectByPrimaryKey(id);
	}

}
