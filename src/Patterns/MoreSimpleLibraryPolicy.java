package Patterns;

import Domain.Book;
import Domain.Customer;

public class MoreSimpleLibraryPolicy implements LibraryPolicy {

    @Override
    public void borrowBook(Customer customer, Book book) {
        System.out.println("Customer " + customer.getName() + " borrowed " + book.getTitle() +  " Type 2 ");
    }
}