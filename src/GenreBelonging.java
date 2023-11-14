public class GenreBelonging {
    private Book book;
    private Genre genre;

    public GenreBelonging(Book book, Genre genre){
        this.book = book;
        this.genre = genre;

        //book.addGenre(genre);
        genre.addBook(book);
    }
}
