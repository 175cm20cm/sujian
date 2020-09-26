package com.yc.sujian.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sujian.bean.Article;
import com.yc.sujian.bean.ArticleExample;
import com.yc.sujian.dao.ArticleMapper;

@RestController
public class ArticleAction {

	@Resource
	private ArticleMapper am;
	
	@GetMapping("getArticles")
	public List<Article> getArticles() {
		List<Article> list = am.selectByExample(null);
		System.out.println("Article_title:" + list.get(0).getTitle());
		System.out.println("article_table:" + list.get(0).getCategory().getName());
		return list;

	}

	@GetMapping("getArticle")
	public List<Article> getArticle(Integer id) {
		ArticleExample ae  = new ArticleExample();
		ae.createCriteria().andCidEqualTo(id);
		List<Article> list = am.selectByExample(ae);
		System.out.println("Article_title:" + list.toString());
		return list;

	}

}
