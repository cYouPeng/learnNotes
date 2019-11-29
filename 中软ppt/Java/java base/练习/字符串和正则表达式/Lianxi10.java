package string;
/**
 * 假定一个类的字节码文件uri(路径+文件名)为：“/com/enity/User.class”，输出这个类的完全限定名
 * @author Administrator
 * 
 *
 */
public class Lianxi10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String uri = "/com/enity/User.class";
		String str = uri.replaceAll("/", ".");//.com.enity.User.class"
		str = str.substring(1, str.lastIndexOf('.'));
		System.out.println(str);
		
		String[] arr = uri.split("/");//{"","com","entity","User.class"}
		String classFile = arr[arr.length-1];//User.class
		String className = classFile.substring(0, classFile.indexOf('.'));//User
		StringBuffer classFullName = new StringBuffer();
		for(int i=0; i<arr.length-1;i++){
			/*
			 * i:0  ""
			 * i:1  "com"
			 * i:2  "entity"
			 */
			if(!arr[i].isEmpty()){
//				packageName = packageName+arr[i]+".";
				classFullName.append(arr[i]).append(".");
			}
		}
		classFullName.append(className);
		System.out.println(classFullName.toString());
	}

}
