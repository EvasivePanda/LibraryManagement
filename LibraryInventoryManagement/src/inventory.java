import java.util.ArrayList;
import java.util.Scanner;

public class inventory {	
private ArrayList<card> list;
/**Scanner to obtain the various inputs from the user */
private Scanner userInputs;

	public inventory() {
		list = new ArrayList<card>();
	}
	
	public void makeCard(){
		this.list = new ArrayList<card>();
		card temp = new card(inputNewCardSicId(), inputNewCardTitle(), inputNewCardAuthor(), inputPrice(), inputQuantity());
		this.list.add(temp);
		orderListBySicId();
		System.out.println(this.list.toString());
	}
	
	
	public int inputNewCardSicId(){
		int sicId=-1;
		do{
			System.out.println("Enter new Sic-Id integer: ");
			this.userInputs = new Scanner(System.in);
			sicId = userInputs.nextInt();
			}while(sicId<0 || !isOpenId(sicId));
		return sicId;
	}
	
	public String inputNewCardTitle(){
		String title="";
		do{
			System.out.println("Enter title of book: ");
			this.userInputs = new Scanner(System.in);
			title = title + userInputs.nextLine();
		}while(title.length()==0);
		
		return title;
	}
	
	public String inputNewCardAuthor(){
		String author = "";
		do{
			System.out.println("Enter authors name: ");
			this.userInputs = new Scanner(System.in);
			author = author + userInputs.nextLine();
			
		}while(author.length()==0); 
		return author;
	}
	
	public double inputPrice(){
		double price = -1.0;
		do{
			System.out.println("Enter the price of the book: ");
			this.userInputs = new Scanner(System.in);
			price = userInputs.nextDouble();
			
		}while(price<0);
		return roundNumberDecimals(price);
	}
	
	public int inputQuantity(){
		int quantity = -1;
		do{
			System.out.println("Enter the amount of books in inventory: ");
			this.userInputs = new Scanner(System.in);
			quantity = userInputs.nextInt();
			
		}while(quantity<0);
	return quantity;
	}
	
	

	public void removeCard(){
		System.out.println("Enter the SIC-ID of card to be deleted: ");
		this.userInputs = new Scanner(System.in);
		int chosenCard = binaryFindSicId(userInputs.nextInt());
		this.list.remove(chosenCard);
	}
	
	public void increaseStock(){
		System.out.println("SIC-ID of which to increase the stock: ");    //make function to get user input for sic id for all sicId functions
		this.userInputs = new Scanner(System.in);
		int chosenCard = binaryFindSicId(userInputs.nextInt());
		System.out.println("Please enter the amount you which to increase the stock by: ");
		this.userInputs = new Scanner(System.in);
		int addedCopies = userInputs.nextInt();
		if(addedCopies > -1){
		this.list.get(chosenCard).addBookCopies(addedCopies);
		}else{
			System.out.println("Error: unable to increase the inventory amount: ");
		}
	}
	
	public void decreaseStock(){
		System.out.println("SIC-ID of which to decrease the stock: ");
		this.userInputs = new Scanner(System.in);
		int chosenCard = binaryFindSicId(userInputs.nextInt());
		System.out.println("Please enter the amount you which to decrease the stock by: ");
		this.userInputs = new Scanner(System.in);
		int addedCopies = userInputs.nextInt();
		if(addedCopies > -1){
		this.list.get(chosenCard).addBookCopies(-addedCopies);
		}else{
			System.out.println("Error: unable to increase the inventory amount: ");
		}
	}
	
	public void displayCardById(){
		System.out.println("Enter the SIC-ID of desired card: ");
		this.userInputs = new Scanner(System.in);
		printCard(binaryFindSicId(userInputs.nextInt()));
	}
	
	public void displayCardByAuthor(){
		System.out.println("Enter the Author to display: ");
		this.userInputs = new Scanner(System.in);
		String author = userInputs.nextLine();
		
		for(int counter=0; counter < this.list.size(); counter++){
			card cardToCheck = this.list.get(counter);
			if(cardToCheck.getAuthor().compareTo(author)==0){
				printCard(counter);
			}
		}
	}
	
	public void displayCardByTitle(){
		System.out.println("Enter the book title to display: ");
		this.userInputs = new Scanner(System.in);
		String title = userInputs.nextLine();
		
		for(int counter=0; counter < this.list.size(); counter++){
			card cardToCheck = this.list.get(counter);
			if(cardToCheck.getTitle().compareTo(title)==0){
				printCard(counter);
			}
		}
	}
	
	public void displayAllCards(){
		System.out.println("Displaying all books:");
		for(int counter =0; counter < this.list.size(); counter++){
			printCard(counter);
		}
		if(this.list.size() == 0){
			System.out.println("The inventory is empty.");
		 }
	}
	
	public void printCard(int counter){
		 card printCard = this.list.get(counter);
		 System.out.println("  \r\n"+
                            "Stock Index Card: " + printCard.getSicId()     +" \r\n"+
                            "Title: "            + printCard.getTitle()     +" \r\n"+
                            "Author: "           + printCard.getAuthor()    +" \r\n"+
                            "Price: "            + printCard.getPrice()     +" \r\n"+
                            "Quantity: "         + printCard.getbookCopies());
	}
	
	public void changePrice(){
		System.out.println("Enter the SIC-ID of card for price change: ");
		//do{
		this.userInputs = new Scanner(System.in);      //Possible way to get this loop on its own method to shorten code
		//int chosenCard = binaryFindSicId(userInputs.nextInt());
		//if(binaryFindSicId(userInputs.nextInt())==-1);{
		//	System.out.println("Enter SIC-ID of card in list: ");
		//}
		//}while(binaryFindSicId(userInputs.nextInt())==-1);
		
		int chosenCard = binaryFindSicId(userInputs.nextInt());
		System.out.println("Enter the new price: ");
		this.userInputs = new Scanner(System.in);
		double newPrice = roundNumberDecimals(userInputs.nextDouble());
		this.list.get(chosenCard).changePrice(newPrice);
		
		
	}
	
	 public void orderListBySicId() {
		 for(int outer =0; outer < this.list.size(); outer++){
			 for(int inner = 0; inner<this.list.size() - outer -1; inner++){
				 card first = this.list.get(inner);
				 card second = this.list.get(inner+1);
				 if(first.getSicId() > second.getSicId()){
					 this.list.set(inner+1, first);
					 this.list.set(inner, second);
				 }
			 }
		 }
	 }
	
	 
	public int binaryFindSicId(int userInputSicId){
		 int locInArray = (int)Math.floor(this.list.size()/2);
		 int prevAttempt= 2;
		 do{	 
			card cardToCheckForId = this.list.get(locInArray);
			int idFromCard = cardToCheckForId.getSicId();
			
			if(idFromCard == userInputSicId){
				return locInArray;
			}
			if(idFromCard > userInputSicId){
				prevAttempt = locInArray;
				locInArray = locInArray - (int)Math.floor(locInArray/prevAttempt);
			}
			if(idFromCard < userInputSicId){
				prevAttempt = locInArray;
				locInArray = locInArray + (int)Math.floor(locInArray/prevAttempt);
			}
		 }while((locInArray !=0 && locInArray < this.list.size()-1));
		 
		if(this.list.get(0).getSicId()==userInputSicId){
			return  0;
		}
		if(this.list.get(this.list.size()-1).getSicId()==userInputSicId){
			return this.list.size()-1;
		}
		return -1;
	}              
	 
	 
	 
	private boolean isOpenId(int id){       //Make this so it starts looking at the middle of the array and then binary searches if position is open
		boolean openId = true;
		for(int counter =0; counter < this.list.size(); counter++){
				 card first = this.list.get(counter);
				 if(id == first.getSicId()){
					 System.out.println("Sic Id already used");
					 openId=false;
				}
		}
		return openId;
	}
	
	
	public String toString(){
		 String returnValue = "";
		 for(card curCard: this.list){
			 returnValue = returnValue + ", "+ curCard.toString();
		 }
		 return returnValue;
	 }
	
	/**
	 * This function takes in a double and rounds it off so it only has numbers into the hundredths place.
	 * @param num : the input double that may contain way more decimal places than two
	 * @return a double that is rounded off to two decimal places. (ex. 2.43256 turns into 2.43)
	 */
	private static double roundNumberDecimals(double num){
		return num = Math.round(num * 100.0) /100.00;
	}
  	
	/**
	 * This method closes off the scanner from the user in order to avoid any issues of overuse.
	 */
	public void finalize(){
		this.userInputs.close();
	}
}
