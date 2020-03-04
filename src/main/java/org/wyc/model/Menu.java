package org.wyc.model;

import java.util.Date;

public class Menu {
	private Integer id;
	private String name;
	private String url;
	private Integer state;
	private Integer fid;
	private Date ctime;
	private String stateStr;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(Integer id, String name, String url, Integer state, Integer fid, Date ctime, String stateStr) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.state = state;
		this.fid = fid;
		this.ctime = ctime;
		this.stateStr = stateStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
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
		builder.append("Menu [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", url=");
		builder.append(url);
		builder.append(", state=");
		builder.append(state);
		builder.append(", fid=");
		builder.append(fid);
		builder.append(", ctime=");
		builder.append(ctime);
		builder.append(", stateStr=");
		builder.append(stateStr);
		builder.append("]");
		return builder.toString();
	}
	
}
