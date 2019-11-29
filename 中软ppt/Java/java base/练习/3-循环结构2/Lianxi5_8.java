package test8_8;

public class Lianxi5_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=10000; i++){
			if(i==1){
				System.out.println("1不是质数");
				continue;
			}if(i==2){
				System.out.println("2是质数");
				continue;
			}
			boolean isZhiShu = true;
			for(int j=2; j<i; j++){
				if(i%j==0){
					isZhiShu = false;
					break;
				}
			}
			if(isZhiShu){
				System.out.println(i+"是质数");
			}else{
				System.out.println(i+"是合数");
			}
			
		}
	}

}
