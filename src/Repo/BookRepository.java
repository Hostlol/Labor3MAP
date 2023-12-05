package Repo;

import Domain.Author;
import Domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookRepository {
//    public List<Book> books = new ArrayList<>();
//    public int bookIdCounter = 1;

    private static Connection connection;
    public BookRepository(){
        connect();
    }
    private void connect() {

        String url = "jdbc:sqlserver://DESKTOP-THDMJIK\\SQLEXPRESS:1433;databaseName=LaborMAP;encrypt=true;trustServerCertificate=true";
        String user = "admin";
        String password = "Admin1";

        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    public void addBook(Book book) throws SQLException{
        String query = "INSERT INTO Book (BookId, Titel, AuthorId, IdLibrary) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, book.getBookId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getAuthorId());
            preparedStatement.setInt(4, 1);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) throws SQLException {
        String query = "DELETE FROM Book WHERE BookId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bookId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No author with the specified Id found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() throws SQLException{
        String query = "SELECT * FROM Book";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int BookId = resultSet.getInt("BookId");
                String name = resultSet.getString("Titel");
                int library = resultSet.getInt("IdLibrary");
                int author = resultSet.getInt("AuthorId");



                Book book = new Book(BookId, name, author, library);

                System.out.println(book.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getBookbyId(int bookId) throws SQLException{
        String query = "SELECT * FROM Book WHERE BookId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bookId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int BookId = resultSet.getInt("BookId");
                    String name = resultSet.getString("Titel");
                    int library = resultSet.getInt("IdLibrary");
                    int author = resultSet.getInt("AuthorId");

                    Book book = new Book(BookId, name, author, library);
                    return book;
                }
            }
        }

        return null;
    }
}
