package elysian.training.spring.dataTransferObjects;

import elysian.training.spring.models.Discount;

import java.util.Objects;

@SuppressWarnings("unused")
public class ProductTransferObject extends AbstractTransferObject {

    private static final long serialVersionUID = 1L;

    private int productId;
    private String productName;
    private double productPrice;
    private Discount productDiscount;

    public ProductTransferObject(int productId, String productName, double productPrice, Discount productDiscount) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
    }

    public int getProductId() { return productId; }

    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public double getProductPrice() { return productPrice; }

    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }

    public Discount getProductDiscount() { return productDiscount; }

    public void setProductDiscount(Discount productDiscount) { this.productDiscount = productDiscount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTransferObject that = (ProductTransferObject) o;
        return productId == that.productId &&
                Double.compare(that.productPrice, productPrice) == 0 &&
                productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice);
    }
}
