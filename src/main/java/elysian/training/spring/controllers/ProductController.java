package elysian.training.spring.controllers;

import elysian.training.spring.dataTransferObjects.ProductTransferObject;
import elysian.training.spring.models.Product;
import elysian.training.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public boolean create(@RequestBody Product product) {
        productService.createProduct(product);
        return true;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable final int id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return StreamSupport.stream(productService.getAllProducts().spliterator(), false)
                .collect(Collectors.toList());
    }


    @PutMapping("/{id}")
    public boolean updateProduct(@PathVariable final int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable final int id) {
        productService.deleteProduct(id);
        return true;
    }
}
