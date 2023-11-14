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

    public Library(Librarian librarian, LibraryPolicy libraryPolicy) {
        this.librarian = librarian;
        this.libraryPolicy = libraryPolicy;
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
}
