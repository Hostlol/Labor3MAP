import java.util.ArrayList;
import java.util.List;

public class Genre {
    private String name;
    private List<Book> books = new ArrayList<>();

    public Genre(String name) {
        this.name = name;
    }


    public void addBook(Book book) {
        books.add(book);
        //book.addGenre(this);


    }
}
