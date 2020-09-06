import java.util.Scanner;

public class userInterface {
	
	/**Scanner to obtain the users decision on which option to choose */
	private Scanner userInputs;
	/**Integer value obtained by user from scanner */
	private int userChoice;
	private boolean keepInterfaceLoop = true;
	
	public userInterface() {
		while(keepInterfaceLoop){
			printInterface();
			userInputChoice();
			makeDecision();
		}
	}
	

	public void printInterface() {
		System.out.println("  \r\n"+ 
				"  \r\n"+
				"Please enter number from the options \r\n"+
				"1) Add new Stock Index Card\r\n" + 
				"2) Remove Stock Index Card by SIC-ID \r\n" + 
				"3) Increase Stock by SIC-ID\r\n" + 
				"4) Decrease Stock by SIC-ID\r\n" + 
				"5) Display Stock Index Card by SIC-ID\r\n" + 
				"6) Display Stock Index Card by Author\r\n" + 
				"7) Display Stock Index Card by Title\r\n" + 
				"8) Display All Stock Index Cards\r\n" + 
				"9) Change price by SIC-ID \r\n"+
				"10) Quit");
	}
	
	public void makeDecision(){
		inventory inv = new inventory();
		if(this.userChoice == 1){
			inv.makeCard();
		}
		if(this.userChoice == 2){
			inv.removeCard();
		}
		if(this.userChoice == 3){
			inv.increaseStock();
		}
		if(this.userChoice == 4){
			inv.decreaseStock();
		}
		if(this.userChoice == 5){
			inv.displayCardById();
		}
		if(this.userChoice == 6){
			inv.displayCardByAuthor();
		}
		if(this.userChoice == 7){
			inv.displayCardByTitle();
		}
		if(this.userChoice == 8){
			inv.displayAllCards();
		}	
		if(this.userChoice == 9){
			inv.changePrice();
		}
		if(this.userChoice == 10){
			this.keepInterfaceLoop = false;
			System.out.println("Thank you for using the library inventory!");
		}
	}
	
	
	public void userInputChoice(){
		this.userChoice = -1;
		do{
			this.userInputs = new Scanner(System.in);
			userChoice = userInputs.nextInt();
			if(userChoice<1||userChoice>10){
				System.err.println("Please enter valid integer");
			}
		}while(userChoice<1||userChoice>10);
	}
	
	/**
	 * This method closes off the scanner from the user in order to avoid any issues of overuse.
	 */
	public void finalize(){
		this.userInputs.close();
	}	
}