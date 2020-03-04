package org.wyc.model;

import java.util.Date;

public class ScoreLog {

	private Integer id;
	private Integer userId;
	private Integer score;
	private String incident;
	private Integer fileId;
	private Date createTime;
	private Date updateTime;
	private String userName;
	public ScoreLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreLog(Integer id, Integer userId, Integer score, String incident, Integer fileId, Date createTime,
			Date updateTime, String userName) {
		super();
		this.id = id;
		this.userId = userId;
		this.score = score;
		this.incident = incident;
		this.fileId = fileId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.userName = userName;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getIncident() {
		return incident;
	}
	public void setIncident(String incident) {
		this.incident = incident;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScoreLog [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", score=");
		builder.append(score);
		builder.append(", incident=");
		builder.append(incident);
		builder.append(", fileId=");
		builder.append(fileId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}
	
}
