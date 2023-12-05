//package UI;
//
//import Controller.AuthorController;
//import Controller.BookController;
//import Domain.*;
//import Patterns.EventsFactory;
//import Patterns.LibraryObserver;
//import Patterns.MoreSimpleLibraryPolicy;
//import Patterns.SimpleLibraryPolicy;
//import Repo.AuthorRepository;
//import Repo.BookRepository;
//import Test.TestBookAuthor;
//import Test.TestLibrary;
//
//import java.util.Scanner;
//public class PersistentConsoleUI {
//    public static void startConsole(){
//        Scanner scanner = new Scanner(System.in);
//        boolean isRunning = true;
//        BookRepository bookRepo = new BookRepository();
//        BookController bookController = new BookController(bookRepo);
//        AuthorRepository authorRepo = new AuthorRepository();
//        AuthorController authorController = new AuthorController(authorRepo);
//        // Create authors
//        Librarian librarian = Librarian.getInstance("John Doe");
//        Library library = new Library(librarian);
//        Author author1 = new Author("John Smith");
//        Author author2 = new Author("Alice Johnson");
//        Author author3 = new Author("Michael Brown");
//        Customer customer1 = new Customer("Customer1",1);
//        Customer customer2 = new Customer("Customer2",2);
//        Customer customer3 = new Customer("Customer3",3);
//        library.addCustomer(customer1);
//        library.addCustomer(customer2);
//        library.addCustomer(customer3);
//
//        Book book1 = new Book();
//        book1.setTitle("The Adventure Begins");
//        book1.addAuthor(author1);
//        book1.addAuthor(author2);
//        library.addBook(book1);
//
//        Book book2 = new Book();
//        book2.setTitle("Mystery in the Woods");
//        book2.addAuthor(author1);
//
//        Book book3 = new Book();
//        book3.setTitle("Coding 101");
//        book3.addAuthor(author2);
//        book3.addAuthor(author3);
//
//        authorController.addAuthor(author1);
//        authorController.addAuthor(author2);
//        authorController.addAuthor(author3);
//
//        bookController.addBook(book1);
//        bookController.addBook(book2);
//        bookController.addBook(book3);
//        library.addBook(book2);
//        library.addBook(book3);
//
//        library.addObserver(customer1);
//        library.addObserver(customer2);
//        library.addObserver(customer3);
//        SimpleLibraryPolicy testLibraryPolicy = new SimpleLibraryPolicy();
//        library.setLibraryPolicy(testLibraryPolicy);
//        MoreSimpleLibraryPolicy moreLibraryPolicy = new MoreSimpleLibraryPolicy();
//        // Display a welcome message
//        System.out.println("Welcome to the Library");
//
//        while (isRunning) {
//            // Display menu options
//            System.out.println("Select an option:");
//            System.out.println("1. Add Book");
//            System.out.println("2. Remove Book");
//            System.out.println("3. Show Books");
//            System.out.println("4. Add Author");
//            System.out.println("5. Remove Author");
//            System.out.println("6. Show Authors");
//            System.out.println("7. Tests");
//            System.out.println("8. Borrow Book");
//            System.out.println("9. Create Event");
//            System.out.println("10. Choose borrow type");
//            System.out.println("11. Quit");
//
//            // Prompt the user to select an option
//            System.out.print("Enter the option number: ");
//            int option = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (option) {
//                case 1:
//                    System.out.println("What is the name of the book?");
//                    String book_name = scanner.nextLine();
//                    Book temp_book = new Book();
//                    temp_book.setTitle(book_name);
//                    System.out.println("Who is the Author?");
//                    String temp_name2 = scanner.nextLine();
//                    Author temp_author =new Author(temp_name2);
//                    authorRepo.addAuthor(temp_author);
//                    temp_book.addAuthor(temp_author);
//                    bookController.addBook(temp_book);
//                    library.addBook(temp_book);
//
//                    break;
//                case 2:
//                    System.out.println("Which Book-id to remove?");
//                    bookController.printAllBooks();
//                    int bookToRemove = scanner.nextInt();
//                    bookController.removeBook(bookToRemove);
//                    System.out.println("Book removed");
//                    break;
//                case 3:
//                    System.out.println("The books are:");
//                    bookController.printAllBooks();
//                    break;
//                case 4:
//                    System.out.println("What is the name of the Domain.Author?");
//                    // Add your program logic for option 1 here
//                    String temp_name = scanner.nextLine();
//                    authorRepo.addAuthor(new Author(temp_name));
//                    System.out.println("Author added");
//                    break;
//                case 5:
//                    System.out.println("Which Author-id to remove?");
//                    authorController.printAllAuthors();
//                    int authorToRemove = scanner.nextInt();
//                    authorController.removeAuthor(authorToRemove);
//                    System.out.println("Author Removed");
//                    break;
//                case 6:
//                    System.out.println("The Authors are:");
//                    authorController.printAllAuthors();
//                    break;
//                case 7:
//                    TestBookAuthor.test_books();
//                    TestBookAuthor.test_authors();
//                    System.out.println("All Tests Completed");
//                    break;
//                case 8:
//                    System.out.println("Choose which book to borrow");
//                    bookController.printAllBooks();
//                    int bookToBorrowID = scanner.nextInt();
//                    Book bookToBorrow = bookController.getBookById(bookToBorrowID);
//                    library.printAllCustomers();
//                    int customerToBorrowID = scanner.nextInt();
//                    Customer customerToBorrow = library.getCustomerById(customerToBorrowID);
//                    library.borrowBook(customerToBorrow,bookToBorrow);
//
//                    break;
//                case 9:
//                    System.out.println("What kind of event would you like?");
//                    System.out.println("1.Book");
//
//                    int eventTypeChoice = scanner.nextInt();
//                    scanner.nextLine();
//
//                    switch (eventTypeChoice) {
//                        case 1:
//                            System.out.println("Enter the name of the book for the event:");
//                            String bookNameForEvent = scanner.nextLine();
//                            System.out.println("Enter the type of event for the book:");
//                            String eventTypeForBook = scanner.nextLine();
//
//
//                            Events event = EventsFactory.createEvent(eventTypeForBook, bookNameForEvent);
//
//                            // Find the book in the library
//                            Book bookForEvent = library.findBookByName(bookNameForEvent);
//
//                            // Associate the event with the book
//                            if (bookForEvent != null) {
//                                bookForEvent.addEvents(event);
//                                System.out.println("Event created and associated with the book.");
//                            } else {
//                                System.out.println("Book not found. Event not created.");
//                            }
//                            break;
//                        default:
//                            System.out.println("Invalid event type.");
//                            break;
//                    }
//                    break;
//                case 10:
//                    System.out.println("Select an option:");
//                    System.out.println("1. Borrow type 1");
//                    System.out.println("2. Borrow type 2");
//                    System.out.println("3. Quit");
//
//                    System.out.print("Enter the option number: ");
//                    int subOption = scanner.nextInt();
//                    scanner.nextLine(); // Consume the newline character
//
//                    switch (subOption) {
//                        case 1:
//                            library.setLibraryPolicy(testLibraryPolicy);
//                            System.out.println("policy 1");
//                            break;
//                        case 2:
//                            library.setLibraryPolicy(moreLibraryPolicy);
//                            System.out.println("policy 2");
//                            break;
//                        case 3:
//                            System.out.println("Goodbye!");
//                            isRunning = false; // Exit the loop
//                            break;
//                        default:
//                            System.out.println("Invalid sub-option. Please select a valid sub-option.");
//                    }
//                    break;
//                case 11:
//                    System.out.println("Goodbye!");
//                    isRunning = false; // Exit the loop
//                    break;
//                default:
//                    System.out.println("Invalid option. Please select a valid option.");
//            }
//        }
//        scanner.close();
//    }
//}
