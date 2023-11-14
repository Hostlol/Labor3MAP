public class BookEvent {
    private Book book;
    private Events event;


    public BookEvent(Book book, Events event){
        this.book = book;
        this.event = event;

        //book.addEvents(event);
        event.addBook(book);
    }
}
