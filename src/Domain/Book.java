package Domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;

    public Book(int bookId, String name, int author, int library) {
        this.BookId = bookId;
        this.title = name;
        this.AuthorId = author;
        this.LibraryId = library;
    }

    @Override
    public String toString() {
        return
                "Title='" + title + '\'' +
                ", BookId=" + BookId +
                ", LibraryId=" + LibraryId +
                ", AuthorId=" + AuthorId ;
    }

    private List<Author> authors = new ArrayList<>();

    private int BookId;
    private int LibraryId;

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    private int AuthorId;

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId){
        this.BookId = BookId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addAuthor(Author author)
    {
        authors.add(author);
    }

    public List<Author> getAuthors() {
            return authors;
    }
    public void printAuthors(){
        for (Author author : authors){
            System.out.println(author.getName());
        }
    }
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

private List<Genre> genres = new ArrayList<>();
    private List<Events> events = new ArrayList<>();

    public void addGenre(Genre genre) {
        genres.add(genre);
        genre.addBook(this);
    }


    public void addEvents(Events event) {
        events.add(event);
        //event.addBook(this);
    }

}
