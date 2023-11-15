package Patterns;

import Domain.Book;
import Domain.Customer;

public interface LibraryPolicy {
    void borrowBook(Customer customer, Book book);
}
