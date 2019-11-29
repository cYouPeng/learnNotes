package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orders implements Serializable{

	private int oid;
	private int userId;
	private String createTime;
	private List productsList;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public List getProductsList() {
		return productsList;
	}
	public void setProductsList(List productsList) {
		this.productsList = productsList;
	}
	
}
