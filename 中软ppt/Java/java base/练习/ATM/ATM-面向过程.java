import java.util.Scanner;

public class ATM{

	public static void main(String [] args){

		String id = "6001 1002";
		String name = "Jack";
		String passWord = "123456";
		double money = 500;            //���ĸ��������ڴ洢�û���Ϣ

		Scanner input = new Scanner(System.in);     //�����ı�ɨ����
		int lastTime = 3;            //���ڴ洢ʣ����������Ĵ���
		System.out.println("����������:");
		while(lastTime >= 1){        //�ж�ʣ������Ƿ��Ѿ�����
			lastTime--;
			String pwd = input.next();    //����pwd�洢�Ӽ������������
			if(pwd.equals(passWord)){     //�ж����������Ƿ���ȷ
				int item = 0;
				while(item != 5 ){

					System.out.println("********************");
					System.out.println("1.��ѯ");
					System.out.println("2.���");
					System.out.println("3.ȡ��");
					System.out.println("4.�޸�����");
					System.out.println("5.�˿�");
					System.out.println("********************");       //������������Ϊ����������ȷ֮����ʾ��һ������
				
					item = input.nextInt();              //�Ӽ����������ִ����û�ѡ��ִ�����ֹ���
					switch(item){

						case 1:
							System.out.println("����ǰ�˻������Ϊ:" + money);
							break;

						case 2:
							System.out.println("���������Ĵ����:");
							int saveMoney = input.nextInt();
							money += saveMoney;
							System.out.println("���ɹ�");
					       		break;

						case 3:
							System.out.println("����������ȡ����:");
							int getMoney = input.nextInt();
							if(getMoney > money){
							
								System.out.println("�˻������㣡");

							}else{

								money -= getMoney;
								System.out.println("ȡ��ɹ�");
							}
							break;
	
						case 4:
							System.out.println("�������µ�����:");
							String newPWD = input.next();
							if(newPWD.equals(passWord)){
								System.out.println("���ܺ�ԭ������ͬ");
							}else{
								passWord = newPWD;
								System.out.println("�޸ĺ������Ϊ:"+newPWD);
							}
							
							break;
						case 5:
							System.out.println("ллʹ�ý�������ATM��");
							break;



					}
				}
			}else if(lastTime > 0){

				System.out.println("���������������ʣ"+ lastTime +"�λ���");
			}else{

				System.out.println("�����յ�����������������꣬����24Сʱ֮���ٴ�ʹ�ã�лл��");
			}

			if(pwd.equals(passWord) == true){

				break;
			}
			
			

		}


	}

}