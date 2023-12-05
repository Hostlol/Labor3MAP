package Repo;

import Domain.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
//    private List<Author> authors = new ArrayList<>();
//    private int authorIdCounter = 1;

    private static Connection connection;
    public AuthorRepository(){
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


    public void addAuthor(Author author) throws SQLException{
        String query = "INSERT INTO Author (IdAuthor, name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, author.getAuthorId());
            preparedStatement.setString(2, author.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int authorId) throws SQLException {
        String query = "DELETE FROM Author WHERE authorId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, authorId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No author with the specified Id found for deletion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewAuthors() throws SQLException{
        String query = "SELECT * FROM Author";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int AuthorId = resultSet.getInt("IdAuthor");
                String name = resultSet.getString("name");


                Author author = new Author(AuthorId, name);

                System.out.println("Author ID: " + author.getAuthorId() + ", Name: " + author.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

