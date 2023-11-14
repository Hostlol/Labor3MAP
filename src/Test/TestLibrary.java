package Test;

import Domain.Book;
import Domain.Customer;
import Domain.Librarian;
import Domain.Library;
import Patterns.LibraryObserver;
import Patterns.LibraryPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TestLibrary {

    public static void testLibrarian() {

        Librarian.reset();
        Librarian librarian = Librarian.getInstance("John Doe");
        Librarian librarian2 = Librarian.getInstance("Jane");

        String name = librarian.getName();
        String name2 = librarian2.getName();
        System.out.println("Librarian Name: " + name);
        System.out.println("Librarian Name: " + name2);
    }
    public static void testLibrary() {
        // Create a Library instance
        Librarian librarian = Librarian.getInstance("John Doe");
        Library library = new Library(librarian);

        // Create a simple library observer for testing
        LibraryObserver testObserver = new LibraryObserver() {
            @Override
            public void update(Library library) {
                System.out.println("Library updated!");
            }
        };

        // Add the observer to the library
        library.addObserver(testObserver);

        // Add a book to the library and check if the observer is notified
        Book book1 = new Book();
        book1.setTitle("123");
        Book book2 = new Book();
        book2.setTitle("321");
        library.addBook(book1);
        library.addBook(book2);

        // Add a customer to the library
        library.addCustomer(new Customer("TestCustomer"));

        // Test borrowing a book
        //library.borrowBook(new Customer("TestCustomer"), new Book("TestBook", 11));

        // Get the list of books in the library
        List<Book> books = library.getBooks();

        // Print the list of books
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}