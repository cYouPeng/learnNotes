package innerclass;

public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberFactory.getIntFromString("123"));
		System.out.println(NumberFactory.getDoubleFromString("1.25"));
	}

}
class NumberFactory{
	public static int getIntFromString(String num){
		IntFactory ifac = Integer::valueOf;
		return ifac.getInt(num);
	}
	public static double getDoubleFromString(String num){
		DoubleFactory dfac = Double::valueOf;
		return dfac.getDouble(num);
	}
	interface IntFactory{
		int getInt(String num);
		
	}
	interface DoubleFactory{
		double getDouble(String num);
	}
}



