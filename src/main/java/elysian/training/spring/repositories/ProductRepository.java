package elysian.training.spring.repositories;

import elysian.training.spring.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

public interface ProductRepository  extends PagingAndSortingRepository<Product, Integer>{
    Optional<List<Product>> findByName(final String name);
    @Async
    Future<Product> findProductById(int id);

    @Query(value =  "SELECT product " +
            "FROM Product product " +
            "WHERE product.name LIKE :name"
    )
    List<Product> findProductsWhichIncludeName(final @Param(value = "name") String name);
}
