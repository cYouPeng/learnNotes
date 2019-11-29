package oopcore.finals;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello";
		TextStyle.textDraw(s, TextStyle.TEXT_NO_STYLE);
		TextStyle.textDraw("world", TextStyle.TEXT_SHADOW|TextStyle.TEXT_BOLDER|TextStyle.TEXT_UNDER_LINE);
	}

}

class TextStyle{
	public static final int TEXT_NO_STYLE = 0;
	public static final int TEXT_SHADOW = 1<<0;
	public static final int TEXT_BOLDER = 1<<1;
	public static final int TEXT_UNDER_LINE = 1<<2;
	public static final int TEXT_EM = 1<<3;
	
	public static void textDraw(String info, int style){

		if((style&TEXT_SHADOW) == TEXT_SHADOW){
			System.out.println(info+"有阴影");
		}
		if((style&TEXT_BOLDER) == TEXT_BOLDER){
			System.out.println(info+"加粗");
		}
		if((style&TEXT_UNDER_LINE) == TEXT_UNDER_LINE){
			System.out.println(info+"有下划线");
		}
		if((style&TEXT_EM) == TEXT_EM){
			System.out.println(info+"倾斜");
		}
	}
}
