import java.util.ArrayList;
import java.util.List;

public class Events {
    public String name;

    private List<Book> books = new ArrayList<>();

    public Events(String name) {
        this.name = name;
    }


    public void addBook(Book book) {
        books.add(book);
        //book.addEvents(this);
    }


}
