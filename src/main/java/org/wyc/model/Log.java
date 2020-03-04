package org.wyc.model;

import java.util.Date;

public class Log {
	private Integer id;
	private Integer userId;
	private String incident;
	private Date createTime;
	private String space1;
	private String space2;
	private String space3;
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(Integer id, Integer userId, String incident, Date createTime, String space1, String space2,
			String space3) {
		super();
		this.id = id;
		this.userId = userId;
		this.incident = incident;
		this.createTime = createTime;
		this.space1 = space1;
		this.space2 = space2;
		this.space3 = space3;
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
	public String getIncident() {
		return incident;
	}
	public void setIncident(String incident) {
		this.incident = incident;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Log [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", incident=");
		builder.append(incident);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", space1=");
		builder.append(space1);
		builder.append(", space2=");
		builder.append(space2);
		builder.append(", space3=");
		builder.append(space3);
		builder.append("]");
		return builder.toString();
	}
	
}
