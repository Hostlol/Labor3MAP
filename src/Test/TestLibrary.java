package Test;

import Domain.Librarian;
import Domain.Library;
import Patterns.LibraryPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TestLibrary {

    public static void testLibrarian() {

        Librarian.reset();
        Librarian librarian = Librarian.getInstance("John Doe");
        Librarian librarian2 = Librarian.getInstance("Jane");

        String name = librarian.getName();
        String name2 = librarian2.getName();
        System.out.println("Librarian Name: " + name);
        System.out.println("Librarian Name: " + name2);
    }
}