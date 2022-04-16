package elysian.training.spring.models;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Optional;

@Entity(name = "Product")
public class Product extends AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "product_sequence_generator")
    @SequenceGenerator(name = "product_sequence_generator", sequenceName = "product_sequence", allocationSize = 1)
    private int id;
    private String name;
    private double price;
    private Discount discount;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####.##");

    public Product(int id, String name, double price, Discount discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Product(final int id, final String name, final double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = null;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public Discount getDiscount() { return discount; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }

    public void setDiscount(Discount discount) { this.discount = discount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        sb.append("(id = ").append(id).append(") has the price of ").append(DECIMAL_FORMAT.format(price)).append(" RON ");
        Optional.ofNullable(discount)
                .ifPresent(value -> sb.append(" with a discount of ")
                        .append(value.getValue())
                        .append(" ")
                        .append(value.getDiscountType().name().toLowerCase()));

        return sb.toString();
    }
}
