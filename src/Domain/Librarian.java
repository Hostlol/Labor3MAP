package Domain;

public class Librarian implements Person {
    private static Librarian instance; // Singleton instance
    private Library library;
    private String name;

    // Private constructor to prevent direct instantiation
    private Librarian(String name) {
        this.name = name;
    }

    // Singleton getInstance method
    public static Librarian getInstance(String name) {
        if (instance == null) {
            instance = new Librarian(name);
        }
        return instance;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public static void reset() {
        instance = null;
    }
    @Override
    public String getName() {
        return name;
    }
}
