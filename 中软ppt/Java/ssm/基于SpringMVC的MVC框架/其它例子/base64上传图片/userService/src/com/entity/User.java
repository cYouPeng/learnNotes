package com.entity;

public class User implements Cloneable{
	private String loginId;
	private String loginPwd;
	private String nickName;
	private String headPic;
	
	public User() {
		super();
	}

	public User(String loginId, String loginPwd, String nickName, String headPic) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.nickName = nickName;
		this.headPic = headPic;
	}

	
	public User clone(){
		// TODO Auto-generated method stub
		try {
			return (User)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	
	
}
