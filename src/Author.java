public class Author implements Person {
    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", AuthorId=" + AuthorId +
                '}';
    }

    private int AuthorId;

    public int getAuthorId() {
        return AuthorId;
    }

    public Author(String name){
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    public void writeBook(Book book){
        book.addAuthor(this);
    }

    public void setAuthorId(int authorIdCounter) {
        this.AuthorId = authorIdCounter;
    }
}
