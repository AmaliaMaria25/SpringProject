package elysian.training.spring.models;

import java.util.List;
import java.util.Optional;

public class Section extends AbstractEntity{
    private final int id;
    private final String name;
    private final List<Product> products;

    public Section(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public List<Product> getProducts() { return products; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        sb.append(" (id= ").append(id).append(") with products: ");
        for (Product product: products) {
            sb.append("\n   ").append(product);
        }

        return sb.toString();
    }
}
