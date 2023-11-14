package Patterns;

import Domain.Book;
import Domain.Customer;

public class SimpleLibraryPolicy implements LibraryPolicy {

    @Override
    public void borrowBook(Customer customer, Book book) {
        System.out.println(customer.getName() + " " + book.getTitle());
    }
}