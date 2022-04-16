package elysian.training.spring;

import elysian.training.spring.models.Product;
import elysian.training.spring.models.Store;
import elysian.training.spring.repositories.ProductRepository;
import elysian.training.spring.services.ProductService;
import elysian.training.spring.setup.Initialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

    private static final Random RANDOM = new Random(1000);

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        Initialization initialization = new Initialization();
        Store amiStore = initialization.getInitializationStore();

        System.out.println(amiStore);



    }

    @Bean
    ApplicationRunner applicationRunner(final ProductService productService) {
        return args -> {
            IntStream.range(0, 50)
                    .forEach(id ->  productService.createProduct(new Product(id, "Product #" + id, RANDOM.nextDouble() * 100)));
            LOGGER.info("The default products were successfully created!");
        };
    }

}
