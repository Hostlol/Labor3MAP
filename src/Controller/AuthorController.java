package Controller;

import Domain.Author;
import Repo.AuthorRepository;

import java.sql.SQLException;
import java.util.List;

public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) throws SQLException {
        authorRepository.addAuthor(author);
    }

    public void printAllAuthors() throws SQLException {
        authorRepository.viewAuthors();
    }
    public void removeAuthor(int authorId) throws SQLException {
        authorRepository.deleteAuthor(authorId);
    }
}
