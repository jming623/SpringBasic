package com.simple.command;

import java.util.ArrayList;

public class ReqVO {
	
	//폼값에 name과 일치하는 멤버변수로 선언
	private String id;
	private String pw;
	private String name;
	private ArrayList<String> inter; //다중값은 list로 처리
	
	public ReqVO() {
		// TODO Auto-generated constructor stub
	}

	public ReqVO(String id, String pw, String name, ArrayList<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.inter = inter;
	}
	
	@Override
	public String toString() {
		return "ReqVO [id=" + id + ", pw=" + pw + ", name=" + name + ", inter=" + inter + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getInter() {
		return inter;
	}

	public void setInter(ArrayList<String> inter) {
		this.inter = inter;
	}

	
	
	
	
	
	
}
