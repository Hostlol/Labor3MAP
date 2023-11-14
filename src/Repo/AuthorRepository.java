package Repo;

import Domain.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();
    private int authorIdCounter = 1;

    public void addAuthor(Author author) {
        author.setAuthorId(authorIdCounter);
        authors.add(author);
        authorIdCounter++;
    }

    public Author findAuthorByName(String authorName) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                return author;
            }
        }
        return null;
    }

    public List<Author> getAllAuthors() {
        return authors;
    }

    public void printAllAuthors() {
        for (Author author : authors){
            System.out.println(author.toString());
        }
    }
    public void removeAuthor(int authorId) {
        Author authorToRemove = null;
        for (Author author : authors) {
            if (author.getAuthorId() == authorId) {
                authorToRemove = author;
                break;
            }
        }
        if (authorToRemove != null) {
            authors.remove(authorToRemove);
        }

    }
}

