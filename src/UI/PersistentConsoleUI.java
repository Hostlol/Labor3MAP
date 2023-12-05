package UI;

import Controller.AuthorController;
import Controller.BookController;
import Domain.*;
import Patterns.EventsFactory;
import Patterns.LibraryObserver;
import Patterns.MoreSimpleLibraryPolicy;
import Patterns.SimpleLibraryPolicy;
import Repo.AuthorRepository;
import Repo.BookRepository;
import Test.TestBookAuthor;
//import Test.TestLibrary;

import java.sql.SQLException;
import java.util.Scanner;
public class PersistentConsoleUI {
    public static void startConsole() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int library_id = 1;
        BookRepository bookRepo = new BookRepository();
        BookController bookController = new BookController(bookRepo);
        AuthorRepository authorRepo = new AuthorRepository();
        AuthorController authorController = new AuthorController(authorRepo);
        Librarian librarian = Librarian.getInstance("John Doe");
        Library library = new Library(librarian);

        SimpleLibraryPolicy testLibraryPolicy = new SimpleLibraryPolicy();
        library.setLibraryPolicy(testLibraryPolicy);
        MoreSimpleLibraryPolicy moreLibraryPolicy = new MoreSimpleLibraryPolicy();
        // Display a welcome message
        System.out.println("Welcome to the Library");

        while (isRunning) {
            // Display menu options
            System.out.println("Select an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Show Books");
            System.out.println("4. Add Author");
            System.out.println("5. Remove Author");
            System.out.println("6. Show Authors");
            System.out.println("7. Tests");
            System.out.println("8. Borrow Book");
            System.out.println("9. Create Event");
            System.out.println("10. Choose borrow type");
            System.out.println("11. Quit");

            // Prompt the user to select an option
            System.out.print("Enter the option number: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("What is the id of the book?");
                    int book_id = scanner.nextInt();
                    System.out.println("What is the name of the book?");
                    String book_name = scanner.nextLine();
                    System.out.println("Who is the Author?");
                    int temp_name2 = scanner.nextInt();
                    Book temp_book = new Book(book_id,book_name,temp_name2,library_id);
                    bookController.addBook(temp_book);

                    break;
                case 2:
                    System.out.println("Which Book-id to remove?");
                    bookController.printAllBooks();
                    int bookToRemove = scanner.nextInt();
                    bookController.removeBook(bookToRemove);
                    System.out.println("Book removed");
                    break;
                case 3:
                    System.out.println("The books are:");
                    bookController.printAllBooks();
                    break;
                case 4:
                    System.out.println("What is the name of the Author?");
                    String temp_name = scanner.nextLine();
                    System.out.println("What is the id of the Author?");
                    int temp_int = scanner.nextInt();
                    authorRepo.addAuthor(new Author(temp_int, temp_name));
                    System.out.println("Author added");
                    break;
                case 5:
                    System.out.println("Which Author-id to remove?");
                    authorController.printAllAuthors();
                    int authorToRemove = scanner.nextInt();
                    authorController.removeAuthor(authorToRemove);
                    System.out.println("Author Removed");
                    break;
                case 6:
                    System.out.println("The Authors are:");
                    authorController.printAllAuthors();
                    break;
                case 7:
                    TestBookAuthor.test_books();
                    TestBookAuthor.test_authors();
                    System.out.println("All Tests Completed");
                    break;
                case 8:
                    System.out.println("Choose which book to borrow");
                    //bookController.printAllBooks();
                    int bookToBorrowID = scanner.nextInt();
                    //Book bookToBorrow = bookController.getBookById(bookToBorrowID);
                    library.printAllCustomers();
                    int customerToBorrowID = scanner.nextInt();
                    Customer customerToBorrow = library.getCustomerById(customerToBorrowID);
                    //library.borrowBook(customerToBorrow,bookToBorrow);

                    break;
                case 9:
                    System.out.println("What kind of event would you like?");
                    System.out.println("1.Book");

                    int eventTypeChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (eventTypeChoice) {
                        case 1:
                            System.out.println("Enter the name of the book for the event:");
                            String bookNameForEvent = scanner.nextLine();
                            System.out.println("Enter the type of event for the book:");
                            String eventTypeForBook = scanner.nextLine();


                            Events event = EventsFactory.createEvent(eventTypeForBook, bookNameForEvent);

                            // Find the book in the library
                            Book bookForEvent = library.findBookByName(bookNameForEvent);

                            // Associate the event with the book
                            if (bookForEvent != null) {
                                bookForEvent.addEvents(event);
                                System.out.println("Event created and associated with the book.");
                            } else {
                                System.out.println("Book not found. Event not created.");
                            }
                            break;
                        default:
                            System.out.println("Invalid event type.");
                            break;
                    }
                    break;
                case 10:
                    System.out.println("Select an option:");
                    System.out.println("1. Borrow type 1");
                    System.out.println("2. Borrow type 2");
                    System.out.println("3. Quit");

                    System.out.print("Enter the option number: ");
                    int subOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (subOption) {
                        case 1:
                            library.setLibraryPolicy(testLibraryPolicy);
                            System.out.println("policy 1");
                            break;
                        case 2:
                            library.setLibraryPolicy(moreLibraryPolicy);
                            System.out.println("policy 2");
                            break;
                        case 3:
                            System.out.println("Goodbye!");
                            isRunning = false; // Exit the loop
                            break;
                        default:
                            System.out.println("Invalid sub-option. Please select a valid sub-option.");
                    }
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    isRunning = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
        scanner.close();
    }
}
