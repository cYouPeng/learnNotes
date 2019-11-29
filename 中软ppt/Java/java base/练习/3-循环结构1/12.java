package test8_8;

public class Lianxi4_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int headNum = 10;
		int footNum = 37;
		if(footNum%2!=0 || footNum>4*headNum || footNum<2*headNum){
			System.out.println("error");
			return;
		}
		//i是鸡的数量
		for(int i=0; i<=headNum; i++){
			if(i*2+(headNum-i)*4 == footNum){
				System.out.println("鸡的数量是"+i+"只,兔子的数量是"+(headNum-i)+"只");
			}
		}
	}

}
