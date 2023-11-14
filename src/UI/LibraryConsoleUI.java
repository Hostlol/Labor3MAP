package UI;

import Controller.AuthorController;
import Controller.BookController;
import Domain.Author;
import Domain.Book;
import Repo.AuthorRepository;
import Repo.BookRepository;

import java.util.Scanner;

public class LibraryConsoleUI {
    public static void StartConsoleUI() {
        Scanner scanner = new Scanner(System.in);
        AuthorRepository authorRepo = new AuthorRepository();
        BookRepository bookRepo = new BookRepository();
        AuthorController authorController = new AuthorController(authorRepo);
        BookController bookController = new BookController(bookRepo);

        while (true) {
            System.out.println("Domain.Library Management System");
            System.out.println("1. Add Domain.Author");
            System.out.println("2. Add Domain.Book");
            System.out.println("3. List Books by Domain.Author");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter author's name: ");
                    String authorName = scanner.next();
                    Author author = new Author(authorName);
                    authorController.addAuthor(author);
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.next();
                    Book book = new Book();
                    book.setTitle(bookTitle);

                    System.out.print("Enter author's name for the book: ");
                    authorName = scanner.next();
                    Author author1 = authorController.findAuthorByName(authorName);

                    if (author1 != null) {
                        author1.writeBook(book);
                        bookController.addBook(book);
                        System.out.println("Domain.Book added successfully.");
                    } else {
                        System.out.println("Domain.Author not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter author's name: ");
                    authorName = scanner.next();
                    Author author2 = authorController.findAuthorByName(authorName);

                    if (author2 != null) {
                        System.out.println("Books by " + author2.getName() + ":");
                        for (Book b : bookController.getAllBooks()) {
                            if (b.getAuthors().contains(author2)) {
                                System.out.println("- " + b.getTitle());
                            }
                        }
                    } else {
                        System.out.println("Domain.Author not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Domain.Library Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
