package com.yc.sujian.bean;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String content;

    private String label;

    private Date createtime;

    private Integer comments;

    private Integer agreecnt;

    private Integer cid;

    private Integer uid;

    private String image;
    
    private User user;
    
    private Category category;
    
    

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", label=" + label + ", createtime="
				+ createtime + ", comments=" + comments + ", agreecnt=" + agreecnt + ", cid=" + cid + ", uid=" + uid
				+ ", image=" + image + ", user=" + user + ", category=" + category + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getAgreecnt() {
        return agreecnt;
    }

    public void setAgreecnt(Integer agreecnt) {
        this.agreecnt = agreecnt;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}