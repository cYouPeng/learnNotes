package string;
/**
 * 请求参数的内容为：id=lisi&pwd=123456,其中“=”左侧为请求参数名，右侧为请求参数值，多个请求参数用“&”间隔，分割字符串得到每一个参数名和参数值，并输出
 * @author Administrator
 *
 */
public class Lianxi11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String paramStr = "id=lisi&pwd=123456";
		String[] paramArr = paramStr.split("&");
		for(String param : paramArr){
			String[] arr = param.split("=");
			System.out.println(arr[0]+":"+arr[1]);
		}
	}

}
