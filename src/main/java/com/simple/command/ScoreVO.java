package com.simple.command;

public class ScoreVO {
	
	private int bno;
	private String name;
	private String kor;
	private String eng;
	
	public ScoreVO() {
		// TODO Auto-generated constructor stub
	}

	public ScoreVO(int bno, String name, String kor, String eng) {
		super();
		this.bno = bno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "ScoreVO [bno=" + bno + ", name=" + name + ", kor=" + kor + ", eng=" + eng + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	

	
	
}
