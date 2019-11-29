import java.util.Scanner;

public class ATM{

	public static void main(String [] args){

		String id = "6001 1002";
		String name = "Jack";
		String passWord = "123456";
		double money = 500;            //这四个变量用于存储用户信息

		Scanner input = new Scanner(System.in);     //创建文本扫描器
		int lastTime = 3;            //用于存储剩余输入密码的次数
		System.out.println("请输入密码:");
		while(lastTime >= 1){        //判断剩余次数是否已经用完
			lastTime--;
			String pwd = input.next();    //变量pwd存储从键盘输入的密码
			if(pwd.equals(passWord)){     //判断输入密码是否正确
				int item = 0;
				while(item != 5 ){

					System.out.println("********************");
					System.out.println("1.查询");
					System.out.println("2.存款");
					System.out.println("3.取款");
					System.out.println("4.修改密码");
					System.out.println("5.退卡");
					System.out.println("********************");       //这六条输出语句为密码输入正确之后显示的一级界面
				
					item = input.nextInt();              //从键盘输入数字代表用户选择执行哪种功能
					switch(item){

						case 1:
							System.out.println("您当前账户内余额为:" + money);
							break;

						case 2:
							System.out.println("请输入您的存款金额:");
							int saveMoney = input.nextInt();
							money += saveMoney;
							System.out.println("存款成功");
					       		break;

						case 3:
							System.out.println("请输入您的取款金额:");
							int getMoney = input.nextInt();
							if(getMoney > money){
							
								System.out.println("账户内余额不足！");

							}else{

								money -= getMoney;
								System.out.println("取款成功");
							}
							break;
	
						case 4:
							System.out.println("请输入新的密码:");
							String newPWD = input.next();
							if(newPWD.equals(passWord)){
								System.out.println("不能和原密码相同");
							}else{
								passWord = newPWD;
								System.out.println("修改后的密码为:"+newPWD);
							}
							
							break;
						case 5:
							System.out.println("谢谢使用建设银行ATM！");
							break;



					}
				}
			}else if(lastTime > 0){

				System.out.println("密码输入错误，您还剩"+ lastTime +"次机会");
			}else{

				System.out.println("您今日的密码输入次数已用完，请于24小时之后再次使用，谢谢！");
			}

			if(pwd.equals(passWord) == true){

				break;
			}
			
			

		}


	}

}