package test8_8;

public class Lianxi3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 90;
		if(score>100||score<0){
			return;
		}
		switch(score/10){
		case 10:
		case 9:System.out.println("A");break;
		case 8:System.out.println("B");break;
		case 7:
		case 6:System.out.println("C");break;
			default:
				System.out.println("D");
		}
		
		if(score>=90){
			System.out.println("A");
		}else if(score>=80){
			System.out.println("B");
		}else if(score>=60){
			System.out.println("C");
		}else{
			System.out.println("D");
		}
		
		if(score>=80){
			if(score>=90){
				System.out.println("A");
			}else{
				System.out.println("B");
			}
		}else{
			if(score>=60){
				System.out.println("C");
			}else{
				System.out.println("D");
			}
		}
		
	}

}
