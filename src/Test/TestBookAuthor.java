package Test;

import Controller.AuthorController;
import Controller.BookController;
import Domain.Author;
import Domain.Book;
import Repo.AuthorRepository;
import Repo.BookRepository;

import static org.junit.Assert.*;
public class TestBookAuthor {
    public static void test_books(){
        BookRepository bookRepo = new BookRepository();
        BookController bookController = new BookController(bookRepo);
        Book book = new Book();
        book.setTitle("Sample Domain.Book");
        bookController.addBook(book);
        assertNotNull(book.getBookId());
        System.out.println("Add Domain.Book Test Completed");

        Book book2 = new Book();
        book2.setTitle("Sample Book1");
        bookController.addBook(book2);
        Book foundBook = bookController.findBookByTitle("Sample Book1");
        assertNotNull(foundBook);
        assertEquals("Sample Book1", foundBook.getTitle());
        System.out.println("Find Domain.Book By Title Test Completed");

        Book book3 = new Book();
        book3.setTitle("Sample Book2");
        bookController.addBook(book3);
        int bookId = book3.getBookId();
        bookController.removeBook(bookId);
        assertNull(bookController.findBookByTitle("Sample Book2"));
        System.out.println("Remove Domain.Book Test Completed");

        Author author = new Author("sample author");
        author.setName("Domain.Author Name");
        Book book4 = new Book();
        book4.addAuthor(author);
        assertEquals(1, book4.getAuthors().size());
        book4.removeAuthor(author);
        assertEquals(0, book4.getAuthors().size());
        System.out.println("Add New Domain.Author To Domain.Book Test Completed");
    }
    public static void test_authors(){
        Author author = new Author("John Doe");
        assertEquals("John Doe", author.getName());
        System.out.println("Add Domain.Author Test Completed");

        Book book = new Book();
        author.writeBook(book);
        assertEquals(1, book.getAuthors().size());
        assertEquals(author, book.getAuthors().get(0));
        System.out.println("Write Domain.Book Test Completed");

        author.setAuthorId(42);
        assertEquals(42, author.getAuthorId());
        AuthorRepository authorRepo = new AuthorRepository();
        AuthorController authorController = new AuthorController(authorRepo);
        Author author2 = new Author("Jane Smith");
        authorController.addAuthor(author2);
        assertEquals(1, authorController.getAllAuthors().size());
        System.out.println("Domain.Author Repo test Completed");

        Author author3 = new Author("Alice Johnson");
        authorController.addAuthor(author3);
        Author foundAuthor = authorController.findAuthorByName("Alice Johnson");
        assertNotNull(foundAuthor);
        assertEquals("Alice Johnson", foundAuthor.getName());
        System.out.println("Find Domain.Author By Name Test Completed");

        Author author4 = new Author("Mary Brown");
        authorController.addAuthor(author4);
        int authorId = author4.getAuthorId();
        authorController.removeAuthor(authorId);
        assertNull(authorController.findAuthorByName("Mary Brown"));
        System.out.println("Remove Domain.Author Test Completed");
    }
}
