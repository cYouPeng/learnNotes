package toolsclass;

import java.math.BigInteger;

public class TestMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.ceil(-1.1));
		System.out.println(Math.floor(-1.7));
		System.out.println(Math.round(-1.1));
		System.out.println(Math.round(-1.7));
		double pi = 3.1415926;
		//System.out.println(Math.round(pi*10000)/10000.0);
		System.out.println(roundNum(pi, 6));
		
		BigInteger bi = new BigInteger("922337203685477580700");
		bi = bi.multiply(new BigInteger("10000000000000000000000000000000000000000"));
		System.out.println(bi.toString());
		
	}
	public static double roundNum(double num, int len){
		if(len<0){
			throw new RuntimeException("保留位数必须大于等于0");
		}
		double temp = 1.0;
		
		for(int i=1; i<=len; i++){
			temp*=10;
		}
		return Math.round(num*temp)/temp;
	}
}
