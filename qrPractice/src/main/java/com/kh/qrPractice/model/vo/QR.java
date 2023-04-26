package com.kh.qrPractice.model.vo;

public class QR {
	private String id;
	private String pwd;
	private int count;
	
	public QR () {}

	public QR(String id, String pwd, int count) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "QR [id=" + id + ", pwd=" + pwd + ", count=" + count + "]";
	}
	
	
	
}
