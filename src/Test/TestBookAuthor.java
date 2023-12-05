package Test;

import Controller.AuthorController;
import Controller.BookController;
import Domain.Author;
import Domain.Book;
import Repo.AuthorRepository;
import Repo.BookRepository;

import java.sql.SQLException;

import static org.junit.Assert.*;
public class TestBookAuthor {
    public static void test_authors() throws SQLException {
        AuthorRepository authorRepository = new AuthorRepository();
        Author author = new Author(99, "Test Author");

        authorRepository.addAuthor(author);

        Author addedAuthor = authorRepository.getAuthorById(99);
        assertEquals(author.getAuthorId(), addedAuthor.getAuthorId());
        assertEquals(author.getName(), addedAuthor.getName());
        System.out.println("New Author Added");
        int authorId = 99;

        authorRepository.deleteAuthor(authorId);

        Author removedAuthor = authorRepository.getAuthorById(99);

        assertTrue(removedAuthor == null);
        System.out.println("Author Deleted");
    }
    public static void test_books() throws SQLException {
        BookRepository bookRepository = new BookRepository();
        Book book = new Book(99, "Test Book",1,1);

        bookRepository.addBook(book);

        Book addedBook = bookRepository.getBookbyId(99);
        assertEquals(book.getBookId(), addedBook.getBookId());
        assertEquals(book.getTitle(), addedBook.getTitle());
        assertEquals(book.getAuthorId(), addedBook.getAuthorId());
        System.out.println("New Book Added");
        int bookId = 99;

        bookRepository.deleteBook(bookId);

        Book removedBook = bookRepository.getBookbyId(99);

        assertTrue(removedBook == null);
        System.out.println("Author Deleted");
    }

}
