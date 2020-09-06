
public class card {
	private int sicId;
	private String bookTitle;
	private String authorName;
	private double bookPrice;
	private int bookCopies;
	
	public card(int sicId, String title, String author, double bookPrice, int quantity){
		this.sicId      = sicId;
		this.bookTitle  = title;
		this.authorName = author;
		this.bookPrice  = bookPrice;
		this.bookCopies = quantity;
	}
	
	
	
	public int getSicId(){
		return this.sicId;
	}
	public String getTitle(){
		return this.bookTitle;
	}
	public String getAuthor(){
		return this.authorName;
	}
	public double getPrice(){
		return this.bookPrice;
	}
	public void changePrice(double newBookPrice){
		this.bookPrice = newBookPrice;
	}
	public int getbookCopies(){
		return this.bookCopies;
	}
	public void addBookCopies(int addedCopies){
		this.bookCopies = bookCopies + addedCopies;
	}
	public boolean compareAuthors(card otherCard) {
		return this.authorName == otherCard.getAuthor();
	}
	
	public boolean compareTitles(card otherCard) {
		return this.bookTitle == otherCard.getTitle();
	}
	
	public boolean equals(Object other) {
		return this.sicId == ((card) other).getSicId();
	}
	
	
	public String toString() {
		return "("+this.sicId+", "+this.bookTitle+", "+this.authorName+", "+this.bookPrice+", "+this.bookCopies+")";
	}
}
