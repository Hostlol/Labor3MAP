package Domain;

import Patterns.LibraryObserver;

public class Customer implements Person, LibraryObserver {
    private String name;
    private int id;
    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
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
