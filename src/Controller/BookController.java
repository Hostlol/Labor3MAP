package Controller;

import Domain.Book;
import Repo.BookRepository;

import java.util.List;

public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        book.setBookId(bookRepository.bookIdCounter);
        bookRepository.books.add(book);
        bookRepository.bookIdCounter++;
    }

    public void printAllBooks() {
        bookRepository.printAllBooks();
    }
    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void removeBook(int bookId){
        bookRepository.removeBook(bookId);
    }
    public Book getBookById(int bookId) {
        return bookRepository.getBookById(bookId);
    }
}