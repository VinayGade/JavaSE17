package beans;

import java.util.Objects;

public final class Customer { //** Note : final class CANNOT be inherited ...
    private final int id;
    private final String name;
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {  return id;}
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
