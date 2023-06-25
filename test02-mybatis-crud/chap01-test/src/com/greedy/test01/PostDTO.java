package com.greedy.test01;

import java.util.Date;

public class PostDTO {
	
	private int postNum;
	private String blogNum;
	private String fileNum;
	private String postTitle;
	private String postCon;
	private Date PostTime;
	private String state;
	private String cateNum;
	
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(int postNum, String blogNum, String fileNum, String postTitle, String postCon, Date postTime,
			String state, String cateNum) {
		super();
		this.postNum = postNum;
		this.blogNum = blogNum;
		this.fileNum = fileNum;
		this.postTitle = postTitle;
		this.postCon = postCon;
		PostTime = postTime;
		this.state = state;
		this.cateNum = cateNum;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getBlogNum() {
		return blogNum;
	}

	public void setBlogNum(String blogNum) {
		this.blogNum = blogNum;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostCon() {
		return postCon;
	}

	public void setPostCon(String postCon) {
		this.postCon = postCon;
	}

	public Date getPostTime() {
		return PostTime;
	}

	public void setPostTime(Date postTime) {
		PostTime = postTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCateNum() {
		return cateNum;
	}

	public void setCateNum(String cateNum) {
		this.cateNum = cateNum;
	}

	@Override
	public String toString() {
		return "PostDTO [postNum=" + postNum + ", blogNum=" + blogNum + ", fileNum=" + fileNum + ", postTitle="
				+ postTitle + ", postCon=" + postCon + ", PostTime=" + PostTime + ", state=" + state + ", cateNum="
				+ cateNum + "]";
	}

}
