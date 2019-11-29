package test;

public class User {
	private String loginId;
	private String loginPwd;
	private String nickName;
	private Integer age;
	private Integer sex;
	
	
	
	public User() {
		super();
	}
	public User(String loginId, String loginPwd, String nickName, Integer age, Integer sex) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.nickName = nickName;
		this.age = age;
		this.sex = sex;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", loginPwd=" + loginPwd + ", nickName=" + nickName + ", age=" + age
				+ ", sex=" + sex + "]";
	}
	
}
