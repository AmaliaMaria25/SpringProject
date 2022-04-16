package elysian.training.spring;

import elysian.training.spring.models.Store;
import elysian.training.spring.setup.Initialization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        Initialization initialization = new Initialization();
        Store amiStore = initialization.getInitializationStore();

        System.out.println(amiStore);
    }

}
