package atm;

public class Atm {
	User curUser;  //����ǰ�û�
	User[] users;
	
	public void init() {      //��ϵͳ���û���Ϣ��ʼ��
		users = new User[1];
		users[0] = new User();
		users[0].id = 001;
		users[0].pwd = "123456";
		users[0].name = "������";
		users[0].balance = 100000;	
	}	
	
	public boolean logIn(int id,String pwd) {     //ʵ�ֵ�½����
		for(int i=0;i<users.length;i++) {
			if(users[i].id == id && users[i].pwd.equals(pwd)) {  //���ݿ����û���Ϣƥ��
				curUser = users[i];  //ƥ��ɹ�����������еĶ������ø�ֵ����ǰ�û�
				return true;
			}
		}
		return false;
	}
	
	public boolean drawMoney(double money) {  //ʵ��ȡ��Ĺ���
		if(money > curUser.balance) {  //���Ҫȡ�ߵ�Ǯ���ڿ������򷵻�false
			return false;
		}else {
			curUser.balance -= money;  //��������ȥҪȡ�ߵ�Ǯ��
			return true;
		}
		
	}
	
	public boolean deposit(double money) { //ʵ�ִ��Ĺ���
		if(money < 0) {   //Ҫ���ǮС��0������false
			return false;
		}else {
			curUser.balance += money;  //��Ҫ���Ǯ��ӵ���ǰ�˻������
			return true;
		}
	}
	
	public double getBalance() {
		return curUser.balance;
	}
	
}





















