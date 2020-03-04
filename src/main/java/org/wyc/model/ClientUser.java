package org.wyc.model;

import java.util.Date;

public class ClientUser {
	private Integer id;
	private String account;
	private String password;
	private String name;
	private Integer state;
	private Integer score;
	private Date createTime;
	private String space1;
	private String space2;
	private String space3;
	private String stateStr;
	public ClientUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientUser(Integer id, String account, String password, String name, Integer state, Integer score,
			Date createTime, String space1, String space2, String space3, String stateStr) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.state = state;
		this.score = score;
		this.createTime = createTime;
		this.space1 = space1;
		this.space2 = space2;
		this.space3 = space3;
		this.stateStr = stateStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
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
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientUser [id=");
		builder.append(id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", state=");
		builder.append(state);
		builder.append(", score=");
		builder.append(score);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", space1=");
		builder.append(space1);
		builder.append(", space2=");
		builder.append(space2);
		builder.append(", space3=");
		builder.append(space3);
		builder.append(", stateStr=");
		builder.append(stateStr);
		builder.append("]");
		return builder.toString();
	}
	
}
