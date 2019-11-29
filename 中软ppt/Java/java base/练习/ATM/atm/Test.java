package atm;

public class Test {

		public static void main(String [] args) {
			
			Atm atm = new Atm();
			Menu menu = new Menu();
			menu.atm = atm;
			atm.init();
			menu.mainMenu();
		}
}
