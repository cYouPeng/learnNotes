package entity;

import java.io.Serializable;

import entity.FirstTitle;

public class SecondTitle implements Serializable {

	private int sid;
	private String titleName;
	private String newContent;
	private String creator;
	private String createTime;
	private int parentTitleId;
	private FirstTitle ft;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getParentTitleId() {
		return parentTitleId;
	}
	public void setParentTitleId(int parentTitleId) {
		this.parentTitleId = parentTitleId;
	}
	public FirstTitle getFt() {
		return ft;
	}
	public void setFt(FirstTitle ft) {
		this.ft = ft;
	}

}
