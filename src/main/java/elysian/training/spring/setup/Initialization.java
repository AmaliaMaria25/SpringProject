package elysian.training.spring.setup;

import elysian.training.spring.models.Discount;
import elysian.training.spring.models.Product;
import elysian.training.spring.models.Section;
import elysian.training.spring.models.Store;

import java.util.*;

public class Initialization {
    private static final Random RANDOM = new Random(1000);

    private Store initializationStore;

    public Initialization() {
        initializationStore = initializeStore();
    }

    public Store getInitializationStore() { return initializationStore; }

    private static Store initializeStore(){
        return new Store(1, "AmiStore", "Paris", initializeSections());
    }

    private static Set<Section> initializeSections(){
        Set<Section> sections = new HashSet<>();
        sections.add(new Section(1, "Dresses section", initializeProducts(1) ));
        sections.add(new Section(2, "Trousers section", initializeProducts(2) ));
        sections.add(new Section(3, "Shoes section", initializeProducts(3) ));
        return sections;
    }

    private static List<Product> initializeProducts(final int sectionId) {
        List<Product> products = new ArrayList<>();
        switch (sectionId){
            case 1: {    //Dresses section
                products = Arrays.asList(
                        new Product(1, "Maxi Dress", getRandomPrice(150), new Discount(50, Discount.Type.Value)),
                        new Product(2, "Flowers Midi Dress", getRandomPrice(300), new Discount(10, Discount.Type.Percent)),
                        new Product(3, "No Straps Attached Dress", getRandomPrice(200)),
                        new Product(4, "Blue Tulle Dress", getRandomPrice(230))
                );
                break;
            }
            case 2: {    //Trousers section
                products = Arrays.asList(
                        new Product(5, "Wide leg black jeans", getRandomPrice(700)),
                        new Product(6, "Short jeans", getRandomPrice(600)),
                        new Product(7, "Beige office trausers", getRandomPrice(900))
                );
                break;
            }
            case 3: {    //Shoes section
                products = Arrays.asList(
                        new Product(8, "Nike black and white shoes", getRandomPrice(1000)),
                        new Product(9, "Musette Stiletto Pink", getRandomPrice(1500)),
                        new Product(10, "Purple Air Max Nike", getRandomPrice(2000))
                );
                break;
            }
            default:{
                System.out.println("Initialized products");
            }
        }
        return products;
    }


    private static double getRandomPrice(final int multiplier) {
        return RANDOM.nextDouble() * multiplier;
    }

}
