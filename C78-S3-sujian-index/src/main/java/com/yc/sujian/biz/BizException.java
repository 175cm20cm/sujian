package com.yc.sujian.biz;

public class BizException extends Exception {
	private static final long serialVersionUID = 1L;

	//错误的名称(属性名)
	private String name;
	
	//错误编码
	private int code;
	
	//自定义构造方法
	public BizException(int code, String name,String msg) {
		super(msg);
		this.name = name;
		this.code = code;
	}

	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
