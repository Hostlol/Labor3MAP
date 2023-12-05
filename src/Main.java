import Domain.Author;
import Repo.AuthorRepository;
import Test.TestLibrary;
//import UI.PersistentConsoleUI;

import java.sql.SQLException;

import static Test.TestLibrary.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //PersistentConsoleUI.startConsole();
//        testLibrarian();
//        testLibrary();
//        testFactory();
//        LibraryTest();
        AuthorRepository authorrepo = new AuthorRepository();
        authorrepo.viewAuthors();
        Author newAuthor = new Author(16, "John Doe");
        authorrepo.addAuthor(newAuthor);
        authorrepo.viewAuthors();
    }
    //test


}