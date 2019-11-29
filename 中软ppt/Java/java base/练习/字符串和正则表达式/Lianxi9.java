package string;

import java.util.Random;

/*
 * 9.控制台输入文件名，判断是否为图片(html可用)，并将文件的逻辑名替换成一个随机数字
 */
public class Lianxi9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] types = new String[]{"jpg","png","gif","bmp"};
		String oldName = "a.bmp";
		String lastName = oldName.substring(oldName.lastIndexOf('.')+1);
		boolean isMatch = false;
//		for(String type : types){
//			if(type.equalsIgnoreCase(lastName)){
//				isMatch = true;
//				break;
//			}
//		}
		switch(lastName){
		case "jpg":
		case "png":
		case "gif":
		case "bmp": isMatch = true; 
		}
		if(isMatch){
			String newName = new Random().nextInt(9000)+1000+"."+lastName;
			System.out.println(newName);
		}else{
			System.out.println("不是图片");
		}
	}

}
