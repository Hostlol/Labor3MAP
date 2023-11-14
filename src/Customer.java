public class Customer implements Person, LibraryObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(Library library) {
        System.out.println("Customer " + name + " received a library update.");
    }
}
