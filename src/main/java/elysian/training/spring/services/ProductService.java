package elysian.training.spring.services;

import elysian.training.spring.models.Product;
import elysian.training.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional()
    public void createProduct(final Product product) {
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Product getProduct(final int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("404 NOT FOUND!!"));
    }

    @Transactional(readOnly = true)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateProduct(final int id, final Product product) {
        getProduct(id).setName(product.getName());
        productRepository.save(product);
    }

    public void deleteProduct(final int id) {
        productRepository.deleteById(id);
    }
}
