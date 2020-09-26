package com.yc.sujian.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yc.sujian.bean.Article;
import com.yc.sujian.bean.Category;

@Component
public class sujianBackAction implements IsujianBackAction {

	@Override
	public List<Category> getC() {
		List<Category> list = new ArrayList<>();
		return list;
	}

	@Override
	public Category getCname(Integer id) {
		return null;
	}

	@Override
	public List<Article> getArticles() {
		List<Article> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<Article> getArticle(Integer id) {
		List<Article> list = new ArrayList<>();
		return list;
	}

}