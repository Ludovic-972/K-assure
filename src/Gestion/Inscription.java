package Gestion;
import BDgestion.*;


public class Inscription {
	
	private BDconnection bdd = new BDconnection();
	
	public static String LoginGenerator() {
		boolean inexistant = false;
		while(true) {
			String numbers = "0123456789";
			String login = "";
			for (int i = 0; i < 8; i++) {
				login += numbers.charAt((int)(Math.random()*(numbers.length())));
			}
			System.out.println(login);
			
			
			if(inexistant)
				return login;
			
		}
	}
	
	public static void main(String[] args) {
		String a = LoginGenerator();
	}
}

