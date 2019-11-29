package test8_8;

public class Lianxi5_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int starNum=1;
		for(int i=1; i<=4; i++){
			for(int j=1; j<=4-i; j++){
				System.out.print(" ");
			}
			for(int j=1; j<=starNum; j++){
				//if(j%2!=0){//q9条件
				if(j==1 || j==starNum){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			starNum+=2;
			System.out.println();
		}
	}

}
