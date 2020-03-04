package org.wyc.utils;

public class PageBean {
	private int currPage;
	private int allPage;
	private int pageNum;
	public PageBean() {

	}
	public PageBean(int currPage, int allPage, int pageNum) {
		super();
		this.currPage = currPage;
		this.allPage = allPage;
		this.pageNum = pageNum;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [currPage=");
		builder.append(currPage);
		builder.append(", allPage=");
		builder.append(allPage);
		builder.append(", pageNum=");
		builder.append(pageNum);
		builder.append("]");
		return builder.toString();
	}
	
}
