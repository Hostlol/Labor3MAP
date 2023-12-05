package Controller;

import Domain.Book;
import Repo.BookRepository;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) throws SQLException {
        bookRepository.addBook(book);
    }
    public void printAllBooks() throws SQLException {
        bookRepository.viewBooks();
    }

    public void removeBook(int bookId) throws SQLException {
        bookRepository.deleteBook(bookId);
    }

}