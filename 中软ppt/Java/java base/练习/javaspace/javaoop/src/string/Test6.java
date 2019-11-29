package string;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("hello");//hello
		sb.insert(0, "lisi say:");//lisi say:hello
		sb.append(" world!!!");//lisi say:hello world!!!
		
		sb.insert(0, "lisi say:").append(" world!!!");
		
		String s1 = "hello";
		String s2 = new String("hello");
		String s3 = new String("hello");
		
		
		StringBuffer sb1 = new StringBuffer("hello");
		
		
		
	}

}
