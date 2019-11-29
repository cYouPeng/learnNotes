package string;
/**
 * 因为系统中的手机号码记录格式不一致（如139 1234 5678或139-1234-5678等不同的分隔符），导致号码识别出错，现在编写代码要求将分隔符去掉。
 * @author Administrator
 *
 */
public class Lianxi15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phoneNum = "139 1234 5678";
		String newNum = phoneNum.replaceAll("\\D", "");
		System.out.println(newNum);
	}

}
