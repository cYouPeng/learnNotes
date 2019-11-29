package test8_8;

public class Lianxi4_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double height = 10;
		int num = 0;
		while(true){
			
			height/=2;
			num++;
			if(height<0.01){
				break;
			}
			
		}
		System.out.println(num);
	}

}
