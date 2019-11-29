package oop1;

public class TestMyMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMath math = new MyMath();
		int sum = 0;
		for(int i=0; i<=100; i++){
			math.num = i;
			if(math.isOdd()){
				math.showNum();
			}else{
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
