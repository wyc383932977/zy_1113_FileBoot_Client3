package org.wyc.model;

import java.util.Date;

public class File {
	private Integer id;
	private Integer userId;
	private String name;
	private String url;
	private Integer state;
	private Date date;
	private String space1;
	private String space2;
	private String space3;
	private Integer fileScore;
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	public File(Integer id, Integer userId, String name, String url, Integer state, Date date, String space1,
			String space2, String space3, Integer fileScore) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.url = url;
		this.state = state;
		this.date = date;
		this.space1 = space1;
		this.space2 = space2;
		this.space3 = space3;
		this.fileScore = fileScore;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSpace1() {
		return space1;
	}
	public void setSpace1(String space1) {
		this.space1 = space1;
	}
	public String getSpace2() {
		return space2;
	}
	public void setSpace2(String space2) {
		this.space2 = space2;
	}
	public String getSpace3() {
		return space3;
	}
	public void setSpace3(String space3) {
		this.space3 = space3;
	}
	public Integer getFileScore() {
		return fileScore;
	}
	public void setFileScore(Integer fileScore) {
		this.fileScore = fileScore;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("File [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", url=");
		builder.append(url);
		builder.append(", state=");
		builder.append(state);
		builder.append(", date=");
		builder.append(date);
		builder.append(", space1=");
		builder.append(space1);
		builder.append(", space2=");
		builder.append(space2);
		builder.append(", space3=");
		builder.append(space3);
		builder.append(", fileScore=");
		builder.append(fileScore);
		builder.append("]");
		return builder.toString();
	}
	
}
