package string;
/**
 * 8.控制台输入Email地址，输出账户名和服务名
 * @author Administrator
 *
 */
public class Lianxi8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = "abc@163.com";
		int atIndex = email.indexOf('@');
		System.out.println(email.substring(0, atIndex));
		System.out.println(email.substring(atIndex+1));
	}

}
