import java.util.*;
class book {
	public int serialNumber;
	public String bookName;
	public String authorName;
	public int bookQty;
	public int numOfCopies;
	Scanner input = new Scanner(System.in);
	public book(){
		System.out.println("Enter the Serial Number of the Book:");
		this.serialNumber = input.nextInt();
		input.nextLine();
		System.out.println("Enter Book Name:");
		this.bookName = input.nextLine();
		System.out.println("Enter Author Name:");
		this.authorName = input.nextLine();
		System.out.println("Enter Quantity of Books:");
		this.bookQty = input.nextInt();
		numOfCopies = this.bookQty;
	}
}
