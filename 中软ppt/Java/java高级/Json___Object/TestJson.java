package test;



public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("lisi","123456","李四",20,1);
		String str = MyJson.formatToJson(user);
		System.out.println(str);
		
		String s = "{\"age\":20,\"loginId\":\"lisi\"}";
		System.out.println(MyJson.parseFromJson(s, User.class));
	}

}
