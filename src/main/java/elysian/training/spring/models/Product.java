package elysian.training.spring.models;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Optional;

public class Product extends AbstractEntity {

    private final int id;
    private final String name;
    private final double price;
    private final Discount discount;

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
