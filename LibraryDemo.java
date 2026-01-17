import java.util.*;

class Book{
	int id;
    String title;

    Book(int id, String title){
        this.id = id;
        this.title = title;
    }
    @Override
	public boolean equals(Object o) {
    	if (this == o) return true; 
    	if (o == null || getClass() != o.getClass()) return false; 
    	Book book = (Book) o; 
    	return id == book.id && title.equals(book.title); 
	}

    void display() {
        System.out.println("ID: " + id + " | Book Name " + title);
    }
}
class Admin{
	Scanner ac = new Scanner(System.in);
	private String UserName = "Admin";
	private String Passward = "Nitin@library";
	Library al = new Library(); 
	int AdminChoice;
	Admin(String user , String Pass){
		if(user.equals(this.UserName) && Pass.equals(this.Passward)){
			System.out.println("\n \n========== Admin Menu ==========");
			System.out.println(" 1. Add new Books \t 2. Remove 3. Exit \n\n choose an option : ");
			AdminChoice = ac.nextInt();
ac.nextLine();
			if(AdminChoice == 1){
				System.out.print("Enter the book name : ");
				String BookName = ac.nextLine();
				System.out.print("Enter the book Id");
				int id = ac.nextInt();
				ac.nextLine();
				Book AddBook = new Book(id, BookName);

				if(al.AvailableBooks.contains(AddBook)){
					System.out.println("Book allready available in library.");
				}
				else{
					al.AvailableBooks.add(new Book(id , BookName));
					System.out.println("Book havebeen add in library .");
					}
				}

		else if(AdminChoice == 2){
				System.out.print("Enter the book name : ");
				String BookName = ac.nextLine();
				System.out.print("Enter the book Id");
				int id = ac.nextInt();
				ac.nextLine();
				Book AddBook = new Book(id, BookName);

				if(al.AvailableBooks.contains(AddBook)){
					al.AvailableBooks.remove(AddBook);
					System.out.println("Book has been removed successfully.");
				}
				else{
					al.AvailableBooks.add(new Book(id , BookName));
					System.out.println("Book not Available");
					}
			}
		}
		else{
			System.out.println("Worng Details");
		}
	}
}

class Library{
	public static ArrayList<Book>AvailableBooks = new ArrayList<>();
	public static ArrayList<Book>IssueBooks = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	Library(){
        AvailableBooks.add(new Book(101 , "Python Programing"));
        AvailableBooks.add(new Book(102 , "Network Security"));
        AvailableBooks.add(new Book(103 , "Java Programing"));
        AvailableBooks.add(new Book(104 , "Cyber Security"));
        AvailableBooks.add(new Book(105 , "C++ Programing"));
        AvailableBooks.add(new Book(106 , " Data Science"));
        AvailableBooks.add(new Book(107 , "C Programing"));
        AvailableBooks.add(new Book(108 , " Javascript"));
        AvailableBooks.add(new Book(109 , "Ethical Hacking"));
        AvailableBooks.add(new Book(110 , "AI "));
        AvailableBooks.add(new Book(111 , "Machine Learning"));

    }
    void SearchBook() {
    System.out.print("Enter the book name / Id ");
    String userInput = in.nextLine().toLowerCase(); // इनपुट को छोटा करें
    boolean isFound = false;

    
    for (Book b : AvailableBooks) {
       
        boolean matchName = b.title.toLowerCase().contains(userInput);
        String bookIdStr = String.valueOf(b.id);
        boolean matchId = bookIdStr.contains(userInput);

        if (matchName || matchId) {
            System.out.println("ID: " + b.id + ", Name " + b.title + "]");
            isFound = true;
        }
    }

    if (!isFound) {
        System.out.println(" Sorry Book not found");
    }
}
    public void IssueBooks(){
		
    	System.out.println("Enter the book id");
    	int id = in.nextInt();
    	in.nextLine();
		System.out.print("Enter the book name to issue \t");
		String book = in.nextLine();
		Book issueBook = new Book(id, book);

		if(AvailableBooks.contains(issueBook)){
			System.out.println("Book issued successful");
			IssueBooks.add(issueBook);
			AvailableBooks.remove(issueBook);
		}
		else{
			System.out.println("Book not Available");
		}
	}

	public void ReturnBook(){
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the book id");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter the book name");
		String book = in.nextLine();
		Book returnBook = new Book(id,book);

		if(IssueBooks.contains(returnBook)){
			System.out.println("Book are return");
			IssueBooks.remove(returnBook);
			AvailableBooks.add(returnBook);
		}
		else{
			System.out.println(" This book was not issue");
		}

	}
}

class LibraryDemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		System.out.println("1. for Admin Panel \t 2. for Students");
		int MenuChoice = sc.nextInt();
		String name , password;
		Library l = new Library();
		switch(MenuChoice){
		case 1: {
			sc.nextLine();
			System.out.print("Enter the UserName : ");
			name = sc.nextLine();
			System.out.print("Enter the Passward : ");
			password = sc.nextLine();
			//sc.nextLine();
			Admin admin = new Admin(name , password);
			break;
		}

		case 2:{
			System.out.println("================== Library Management System ==================");

			while(true){
				System.out.println(" \n \n 1. Search Books \n2.AvailableBooks \n3.Issue a book \n4.Return Book \n5. Show Issue Books \n6.for Exit");
				int choice = sc.nextInt();

				switch(choice){
				case 1: l.SearchBook(); break;
				case 2:
					System.out.println("Number of AvailableBooks is :" + l.AvailableBooks.size());
					for (Book e :l.AvailableBooks){
	   					e.display();
	    			}
					break;
				case 3: 
					l.IssueBooks();
					break;
				case 4: 
					l.ReturnBook();
					break;
				case 5:
					for (Book e :l.IssueBooks){
	   					e.display();
	    			}
					break;
				case 6: 
					System.out.println("Thanks & Enjoy !");
					System.exit(0);
					break;
				default :
					System.out.println("Invailed choice");
					break;
				}
			}
		
		}
		default :{
			System.out.println("Enter the valid choice");
			}
		}
	}

												   }				String BookName = ac.nextLine();
				System.out.print("Enter the book Id");
				int id = ac.nextInt();
				ac.nextLine();
				Book AddBook = new Book(id, BookName);

				if(al.AvailableBooks.contains(AddBook)){
					System.out.println("Book allready available in library.");
				}
				else{
					al.AvailableBooks.add(new Book(id , BookName));
					System.out.println("Book havebeen add in library .");
					}
				}

		else if(AdminChoice == "2"){
				System.out.print("Enter the book name : ");
				String BookName = ac.nextLine();
				System.out.print("Enter the book Id");
				int id = ac.nextInt();
				ac.nextLine();
				Book AddBook = new Book(id, BookName);

				if(al.AvailableBooks.contains(AddBook)){
					al.AvailableBooks.remove(AddBook);
					System.out.println("Book has been removed successfully.");
				}
				else{
					al.AvailableBooks.add(new Book(id , BookName));
					System.out.println("Book not Available");
					}
			}
		}
		else{
			System.out.println("Worng Details");
		}
	}
}

class Library{
	public static ArrayList<Book>AvailableBooks = new ArrayList<>();
	public static ArrayList<Book>IssueBooks = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	Library(){
        AvailableBooks.add(new Book(101 , "Python Programing"));
        AvailableBooks.add(new Book(102 , "Network Security"));
        AvailableBooks.add(new Book(103 , "Java Programing"));
        AvailableBooks.add(new Book(104 , "Cyber Security"));
        AvailableBooks.add(new Book(105 , "C++ Programing"));
        AvailableBooks.add(new Book(106 , " Data Science"));
        AvailableBooks.add(new Book(107 , "C Programing"));
        AvailableBooks.add(new Book(108 , " Javascript"));
        AvailableBooks.add(new Book(109 , "Ethical Hacking"));
        AvailableBooks.add(new Book(110 , "AI "));
        AvailableBooks.add(new Book(111 , "Machine Learning"));

    }
    void SearchBook() {
    System.out.print("Enter the book name / Id ");
    String userInput = in.nextLine().toLowerCase(); // इनपुट को छोटा करें
    boolean isFound = false;

    
    for (Book b : AvailableBooks) {
       
        boolean matchName = b.title.toLowerCase().contains(userInput);
        String bookIdStr = String.valueOf(b.id);
        boolean matchId = bookIdStr.contains(userInput);

        if (matchName || matchId) {
            System.out.println("ID: " + b.id + ", Name " + b.title + "]");
            isFound = true;
        }
    }

    if (!isFound) {
        System.out.println(" Sorry Book not found");
    }
}
    public void IssueBooks(){
		
    	System.out.println("Enter the book id");
    	int id = in.nextInt();
    	in.nextLine();
		System.out.print("Enter the book name to issue \t");
		String book = in.nextLine();
		Book issueBook = new Book(id, book);

		if(AvailableBooks.contains(issueBook)){
			System.out.println("Book issued successful");
			IssueBooks.add(issueBook);
			AvailableBooks.remove(issueBook);
		}
		else{
			System.out.println("Book not Available");
		}
	}

	public void ReturnBook(){
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the book id");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter the book name");
		String book = in.nextLine();
		Book returnBook = new Book(id,book);

		if(IssueBooks.contains(returnBook)){
			System.out.println("Book are return");
			IssueBooks.remove(returnBook);
			AvailableBooks.add(returnBook);
		}
		else{
			System.out.println(" This book was not issue");
		}

	}
}

class LibraryDemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		System.out.println("1. for Admin Panel \t 2. for Students");
		int MenuChoice = sc.nextInt();
		String name , password;
		Library l = new Library();
		switch(MenuChoice){
		case 1: {
			sc.nextLine();
			System.out.print("Enter the UserName : ");
			name = sc.nextLine();
			System.out.print("Enter the Passward : ");
			password = sc.nextLine();
			//sc.nextLine();
			Admin admin = new Admin(name , password);
			break;
		}

		case 2:{
			System.out.println("================== Library Management System ==================");

			while(true){
				System.out.println(" \n \n 1. Search Books \n2.AvailableBooks \n3.Issue a book \n4.Return Book \n5. Show Issue Books \n6.for Exit");
				int choice = sc.nextInt();

				switch(choice){
				case 1: l.SearchBook(); break;
				case 2:
					System.out.println("Number of AvailableBooks is :" + l.AvailableBooks.size());
					for (Book e :l.AvailableBooks){
	   					e.display();
	    			}
					break;
				case 3: 
					l.IssueBooks();
					break;
				case 4: 
					l.ReturnBook();
					break;
				case 5:
					for (Book e :l.IssueBooks){
	   					e.display();
	    			}
					break;
				case 6: 
					System.out.println("Thanks & Enjoy !");
					System.exit(0);
					break;
				default :
					System.out.println("Invailed choice");
					break;
				}
			}
		
		}
		default :{
			System.out.println("Enter the valid choice");
			}
		}
	}

}

