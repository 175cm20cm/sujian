package com.yc.sujian.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.sujian.bean.Article;
import com.yc.sujian.bean.Category;

@FeignClient(name = "sujian-back", fallback = sujianBackAction.class)
public interface IsujianBackAction {

	@GetMapping("getC")
	public List<Category> getC();

	@GetMapping("getCname")
	public Category getCname(@RequestParam Integer id);

	@GetMapping("getArticles")
	public List<Article> getArticles();

	@GetMapping("getArticle")
	public List<Article> getArticle(@RequestParam Integer id);

}