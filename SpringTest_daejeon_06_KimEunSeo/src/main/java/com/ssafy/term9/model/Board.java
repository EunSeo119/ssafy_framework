package com.ssafy.term9.model;

public class Board {
	private String ano;
	private String userid;
	private String issuedate;
	private String issue;
	// 편의성을 위해
	private String name;
	private String rname;
	private int rclass;
//	//상세 정보에서 필요한 유저 정보를 담기 위한 UserInfo
//	private Member member;
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRclass() {
		return rclass;
	}
	public void setRclass(int rclass) {
		this.rclass = rclass;
	}
	

}
