import gui.Console;
import controller.IOController;
import controller.MonopoliController;


public class Main {

	public static void main (String[] args) {
			
		boolean endPlay = false;
		int input;
	
		System.out.println("BENVENUTO NEL GIOCO DEL MONOPOLI\n");
		
		do{
			Console.showMenu();
			
			input = IOController.readInputOption();
			endPlay = MonopoliController.manageChoice(input);
		}while(!endPlay);
	}
}
