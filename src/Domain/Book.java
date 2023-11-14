package Domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;

    @Override
    public String toString() {
        return "Domain.Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", BookId=" + BookId +
                '}';
    }

    private List<Author> authors = new ArrayList<>();

    private int BookId;

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
        event.addBook(this);
    }

}
