package exception;

public class TestThrow1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		try{

			double s1 = calcArea(10);
			System.out.println(s1);
			double s2 = calcArea(-10);
			System.out.println(s2);
//		}catch(Exception e){
//			//e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		System.out.println("end");
		method();
	}
	public static double calcArea(int r)throws Exception{
		if(r<=0){
			throw new Exception("半径必须大于0");//构造器参数被封装到了异常对象的message的属性中
		}else{
			return r*r*Math.PI;
		}
	}
	public static void method() throws RuntimeException{
		throw new RuntimeException();
	}

}
