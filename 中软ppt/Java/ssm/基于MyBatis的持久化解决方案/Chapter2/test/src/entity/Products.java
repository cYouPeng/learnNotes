package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Products implements Serializable{

	private int pid;
	private String productName;
	private int productPrice;
	private List ordersList;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public List getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List ordersList) {
		this.ordersList = ordersList;
	}
}
