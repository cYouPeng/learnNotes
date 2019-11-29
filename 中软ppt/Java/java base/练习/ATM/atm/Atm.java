package atm;

public class Atm {
	User curUser;  //代表当前用户
	User[] users;
	
	public void init() {      //对系统中用户信息初始化
		users = new User[1];
		users[0] = new User();
		users[0].id = 001;
		users[0].pwd = "123456";
		users[0].name = "步惊云";
		users[0].balance = 100000;	
	}	
	
	public boolean logIn(int id,String pwd) {     //实现登陆功能
		for(int i=0;i<users.length;i++) {
			if(users[i].id == id && users[i].pwd.equals(pwd)) {  //数据库中用户信息匹配
				curUser = users[i];  //匹配成功，则把数组中的对象引用赋值给当前用户
				return true;
			}
		}
		return false;
	}
	
	public boolean drawMoney(double money) {  //实现取款的功能
		if(money > curUser.balance) {  //如果要取走的钱大于卡内余额，则返回false
			return false;
		}else {
			curUser.balance -= money;  //卡内余额减去要取走的钱数
			return true;
		}
		
	}
	
	public boolean deposit(double money) { //实现存款的功能
		if(money < 0) {   //要存的钱小于0，返回false
			return false;
		}else {
			curUser.balance += money;  //把要存的钱添加到当前账户余额中
			return true;
		}
	}
	
	public double getBalance() {
		return curUser.balance;
	}
	
}





















