package atm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu m = new Menu();
		newMenu nm = m::mainMenu;
		while(true){
			nm.welcome();
		}
	}

}
interface newMenu{
	void welcome();
}
