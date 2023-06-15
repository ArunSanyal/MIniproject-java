import java.util.*;
public class Library {
	public static void main(String[] args)
	{
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Welcome to the Library Management System");
			System.out.println("Choose the following selections:");
			System.out.println("");
			books boo = new books();
			students stu = new students();
			int choice,search;
			do {
				boo.displayMenu();
				choice = input.nextInt();
				switch (choice) {
					case 1:
						book b = new book();
						boo.addBook(b);
						break;
					case 2:
						boo.updateBookQty();
						break;
					case 3:
						System.out.println("Click 1 to search with serial No.");
						System.out.println("Click 2 to search with author Name.");
						search = input.nextInt();
						switch (search) {
							case 1:
								boo.searchBySerial();
								break;
							case 2:
								boo.searchByAuthor();
								break;
						}
					case 4:
						boo.showAllBooks();
						break;
					case 5:
						student s = new student();
						stu.addStudent(s);
						break;
					case 6:
						stu.showAllStudents();
						break;
					case 7:
						stu.checkOutBook(boo);
						break;
					case 8:
						stu.checkInBook(boo);
						break;
					default:
						System.out.println("ENTER BETWEEN 0 TO 8.");
					}
				}
				while (choice != 0);
		}
	}
}
