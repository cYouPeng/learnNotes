package string;
/**
 * 5.控制台输入Email地址，粗略判断其是否为合法Email
 * @author Administrator
 *
 */
public class Lianxi5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = "xxx@163.com";
		Lianxi5 lx = new Lianxi5();
		if(lx.checkEmail(email)){
			System.out.println("邮箱结构合法");
		}else{
			System.out.println("邮箱结构非法");
		}
		
	}
	
	public boolean checkEmail(String email){
		if(email==null||email.trim().equals("")){
			return false;
		}
		int atIndex = email.indexOf('@');
		if(atIndex<=0){
			return false;
		}
		if(email.indexOf('.',atIndex)<0){
			return false;
		}
		return true;
	}
}
