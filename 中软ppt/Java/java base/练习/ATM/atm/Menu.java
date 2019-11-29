package atm;

import java.util.Scanner;

public class Menu {
	Atm atm;
	Scanner input = new Scanner(System.in);
	
	public void mainMenu() {
		for(int i=0;i<3;i++) {
			
			System.out.println("�����뿨�ţ�");
			int id = input.nextInt();
			System.out.println("���������룺");
			String pwd = input.next();
			if(atm.logIn(id, pwd)) {
				
				System.out.println("��ӭʹ�ý�������ATM����");
				while(true) {
					System.out.println("��ѡ�������ţ� 1--ȡ��  2--��� 3--��ʾ���  4--�˿�");
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
				System.out.println("sorry!���������������������24Сʱ֮�����ԣ�");
			}
			
		}
				
	}
	public void drawMoney(){
		System.out.println("������ȡ���");
		double money = input.nextDouble();
		if(atm.drawMoney(money)) {
			System.out.println("���ѳɹ�ȡ��"+money+"Ԫ");
		}else{
			System.out.println("���㣡");
		}
	}
	
	public void deposit() {
		System.out.println("���������");
		double money = input.nextDouble();
		if(atm.deposit(money)) {
			System.out.println("���ѳɹ�����"+money+"Ԫ");
		}else {
			System.out.println("�����������Ĵ����");
		}
	}
	
	public void getBalance() {
		System.out.println(atm.getBalance());
	}

}
