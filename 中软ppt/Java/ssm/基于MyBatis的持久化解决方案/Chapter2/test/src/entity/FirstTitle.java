package entity;

import java.io.Serializable;
import java.util.List;

public class FirstTitle implements Serializable{

	private int fid;
	private String titleName;
	private String creator;
	private String createTime;
	private List stList;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
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
	public List getStList() {
		return stList;
	}
	public void setStList(List stList) {
		this.stList = stList;
	}
	
}
