import java.util.*;
public class books {
	book books_array[] = new book[100];
	public static int booksCount;
	Scanner input = new Scanner(System.in);
	// Compare 2 book objects
	public int compareBook(book b1, book b2){
		// Condition to check if book names match
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
			System.out.println("Book of this Name Already Exists.");
			return 0;
		}
		// Condition to check if book serial numbers match
		if (b1.serialNumber == b2.serialNumber) {
			System.out.println("Book of this Serial No Already Exists.");
			return 0;
		}
		return 1;
	}
	// Add new book
	public void addBook(book b){
		for (int i = 0; i < booksCount; i++) {
			if (this.compareBook(b, this.books_array[i])== 0){
				return;
			}
		}
		// Condition to check for overflow
		if (booksCount < 100){
			books_array[booksCount] = b;
			booksCount++;
		}else {
			System.out.println("No Space to Add More Books.");
		}
	}
	// Search book by Serial Number
	public void searchBySerial(){
		int serialNumber;
		int flag = 0;
		System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
		System.out.println("Enter Serial No of Book:");
		serialNumber = input.nextInt();
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for (int i = 0; i < booksCount; i++){
			// Condition to check if serial number matches any of the book
			if (serialNumber == books_array[i].serialNumber){
				System.out.println(books_array[i].serialNumber + "\t\t"+ books_array[i].bookName + "\t\t"
					+ books_array[i].authorName + "\t\t"+ books_array[i].numOfCopies + "\t\t"
					+ books_array[i].bookQty);
				flag++;
				return;
			}
		}
		if (flag == 0){
			System.out.println("No Book for Serial No "+ serialNumber + " Found.");
		}
	}
	// Search book by author name
	public void searchByAuthor(){
		int flag = 0;
		System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
		input.nextLine();
		System.out.println("Enter Author Name:");
		String authorName = input.nextLine();
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for (int i = 0; i < booksCount; i++){
			// 
			if (authorName.equalsIgnoreCase(
				books_array[i].authorName)) {
				System.out.println(books_array[i].serialNumber + "\t\t"+ books_array[i].bookName + "\t\t"
					+ books_array[i].authorName + "\t\t"+ books_array[i].numOfCopies + "\t\t"
					+ books_array[i].bookQty);
				flag++;
			}
		}
		if (flag == 0){
			System.out.println("No Books of " + authorName + " Found.");
		}	
	}
	// Display all books
	public void showAllBooks(){
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for (int i = 0; i < booksCount; i++){
			System.out.println(books_array[i].serialNumber + "\t\t"+ books_array[i].bookName + "\t\t"
				+ books_array[i].authorName + "\t\t"+ books_array[i].numOfCopies + "\t\t"
				+ books_array[i].bookQty);
		}
	}
	// Increase number of available books
	public void updateBookQty(){
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial No of Book");
		int serialNumber = input.nextInt();
		for (int i = 0; i < booksCount; i++){
			// Condition to match serial number of book 
			if (serialNumber == books_array[i].serialNumber){
				System.out.println("Enter No of Books to be Added:");
				int addingQty = input.nextInt();
				books_array[i].bookQty += addingQty;
				books_array[i].numOfCopies += addingQty;
				return;
			}
		}
	}
	// Create display menu
	public void displayMenu(){
		// Displaying menu
		System.out.println("Press 1 to Add new book to collection");
		System.out.println("Press 2 to Update number of books");
		System.out.println("Press 3 to Search for a particular book by author or serial number");
		System.out.println("Press 4 to Display all books");
		System.out.println("Press 5 to Add new Student");
		System.out.println("Press 6 to Show all students");
		System.out.println("Press 7 to Checkout book if issued");
		System.out.println("Press 8 to Check in book on returning");
		System.out.println("Press 0 to Exit Application.");
		System.out.println("-----------------------------------------------------------------");
	}
	//  Check if book is available or not
	public int isAvailable(int serialNumber){
		for (int i = 0; i < booksCount; i++){
			if (serialNumber == books_array[i].serialNumber){
				if (books_array[i].numOfCopies > 0){
					System.out.println("Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}
		System.out.println("No Book of Serial Number "+ " Available in Library.");
		return -1;
	}
    // Checkout book if issued
	public book checkOutBook(){
		System.out.println("Enter Serial Number of Book to be Checked Out");
		int serialNumber = input.nextInt();
		int bookIndex = isAvailable(serialNumber);

		if (bookIndex != -1){
			books_array[bookIndex].numOfCopies--;
			return books_array[bookIndex];
		}
		return null;
	}
	// Check in book on returning"
	public void checkInBook(book b){
		for (int i = 0; i < booksCount; i++) {
			if (b.equals(books_array[i])) {
				books_array[i].numOfCopies++;
				return;
			}
		}
	}
}
