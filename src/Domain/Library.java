package Domain;

import Patterns.LibraryObserver;
import Patterns.LibraryPolicy;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Librarian librarian;
    private LibraryPolicy libraryPolicy;

    private static Library instance;

    public Library(Librarian librarian) {
        this.librarian = librarian;
    }

    public void setLibraryPolicy(LibraryPolicy libraryPolicy) {
        this.libraryPolicy = libraryPolicy;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook(Customer customer, Book book) {
        libraryPolicy.borrowBook(customer, book);
    }

    private List<LibraryObserver> observers = new ArrayList<>();

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (LibraryObserver observer : observers) {
            observer.update(this);
        }
    }
    public void printAllCustomers() {
        System.out.println("All Customers:");

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

    }
    public Book findBookByName(String bookNameForEvent) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookNameForEvent)) {
                return book;
            }
        }
        return null; // Book not found
    }
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null; // Customer not found
    }
}
