package atm;

import java.util.Scanner;

public class Menu {
	Atm atm;
	Scanner input = new Scanner(System.in);
	
	public void mainMenu() {
		for(int i=0;i<3;i++) {
			
			System.out.println("请输入卡号：");
			int id = input.nextInt();
			System.out.println("请输入密码：");
			String pwd = input.next();
			if(atm.logIn(id, pwd)) {
				
				System.out.println("欢迎使用建设银行ATM服务！");
				while(true) {
					System.out.println("请选择操作编号： 1--取款  2--存款 3--显示余额  4--退卡");
					int select = input.nextInt();
					switch(select) {
					case 1:
						drawMoney();
						break;
					case 2:
						deposit();
						break;
					case 3:
						getBalance();
						break;
					case 4:
					}
				}
				
			}
			if(i == 3) {
				System.out.println("sorry!您三次密码输入错误，请于24小时之后再试！");
			}
			
		}
				
	}
	public void drawMoney(){
		System.out.println("请输入取款金额：");
		double money = input.nextDouble();
		if(atm.drawMoney(money)) {
			System.out.println("您已成功取款"+money+"元");
		}else{
			System.out.println("余额不足！");
		}
	}
	
	public void deposit() {
		System.out.println("请输入存款金额：");
		double money = input.nextDouble();
		if(atm.deposit(money)) {
			System.out.println("您已成功存入"+money+"元");
		}else {
			System.out.println("请输入大于零的存款金额");
		}
	}
	
	public void getBalance() {
		System.out.println(atm.getBalance());
	}

}
