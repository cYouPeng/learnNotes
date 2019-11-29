package string;
/**
 * 12.控制台输入一个ip地址，分别输出4个ip段的值
 * @author Administrator
 *
 */
public class Lianxi12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "33.33.33.100";
		String ipReg = "^\\d{1,3}(\\.\\d{1,3}){3}$";
		if(!ip.matches(ipReg)){
			System.out.println("ip格式错误");
			return;
		}
		for(String ipPart : ip.split("\\.")){
			System.out.println(ipPart);
		}
	}

}
