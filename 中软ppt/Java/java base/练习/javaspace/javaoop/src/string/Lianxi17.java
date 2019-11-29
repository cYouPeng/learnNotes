package string;

public class Lianxi17 {

	public static void main(String[] args) {
		String s = "abc";
//		s+"123"
		s.concat("123");
		
		// TODO Auto-generated method stub
		String reg = "东突|台独|法轮功";
		
		String info = "一伙法轮功分子跑去和东突分子玩游戏";
		info = info.replaceAll(reg, "*");
		System.out.println(info);
	}

}
