package atm;

public class User {
	private String id;
	private String pwd;
	private String name;
	private Double money;
	{
		this.id = CardIdFactory.newCardId();
	}
	public User(){
		this.pwd = "000000";
	}
	public User(String pwd, String name, Double money){
		this.pwd = pwd;
		this.name = name;
		this.money = money;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public String getPwd(){
		return this.pwd;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setMoney(Double money){
		this.money = money;
	}
	public Double getMoney(){
		return this.money;
	}
}
class CardIdFactory{
	static int num;
	static{
		num = 1000;
	}
	public static String newCardId(){
		num++;
		return String.valueOf(num);
	}
}
