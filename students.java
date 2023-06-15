import java.util.*;
public class students {
	student students_array[] = new student[100];
	public static int studentsCount = 0;
	Scanner input = new Scanner(System.in);
	// Add students
	public void addStudent(student s){
		for (int i = 0; i < studentsCount; i++){
			// Condition to check if there is any repetition in the registrations
			if (s.regNum.equalsIgnoreCase(students_array[i].regNum)){
				System.out.println("Student of Reg Num " + s.regNum+ " is Already Registered.");
				return;
			}
		}
		if(studentsCount <= 100){
			students_array[studentsCount] = s;
			studentsCount++;
		}
	}
	// Display all students
	public void showAllStudents(){
		System.out.println("Student Name\t\tReg Number");
		for (int i = 0; i < studentsCount; i++) {
			System.out.println(students_array[i].studentName+ "\t\t"+ students_array[i].regNum);
		}
	}
	// To check if record is Student or not
	public int isStudent(){
		System.out.println("Enter Reg Number:");
		String regNum = input.nextLine();
		for (int i = 0; i < studentsCount; i++){
			if (students_array[i].regNum.equalsIgnoreCase(regNum)) {
				return i;
			}
		}
		System.out.println("Student is not Registered.");
		System.out.println("Get Registered First.");
		return -1;
	}
	//Checkout book if student is issuing it
	public void checkOutBook(books book){
		int studentIndex = this.isStudent();
		if (studentIndex != -1){
			book.showAllBooks();
			book b = book.checkOutBook();
			System.out.println("checking out");
			if (b != null){
				if (students_array[studentIndex].booksCount<= 3){
					System.out.println("adding book");
					students_array[studentIndex].borrowedBooks[students_array[studentIndex].booksCount]= b;
					students_array[studentIndex].booksCount++;
					return;
				}else {
					System.out.println("Student Can not Borrow more than 3 Books.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}
	// Check in book on returning to library
	public void checkInBook(books book){
		int studentIndex = this.isStudent();
		if (studentIndex != -1){
			System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
			student s = students_array[studentIndex];
			for (int i = 0; i < s.booksCount; i++){
				System.out.println(s.borrowedBooks[i].serialNumber + "\t\t\t"+ s.borrowedBooks[i].bookName + "\t\t\t"
					+ s.borrowedBooks[i].authorName);
			}
			System.out.println("Enter Serial Number of Book to be Checked In:");
			int serialNumber = input.nextInt();
			for (int i = 0; i < s.booksCount; i++) {
				if (serialNumber == s.borrowedBooks[i].serialNumber) {
					book.checkInBook(s.borrowedBooks[i]);
					s.borrowedBooks[i] = null;
					return;
				}
			}
			System.out.println("Book of Serial No " + serialNumber+ "not Found");
		}
	}
}
