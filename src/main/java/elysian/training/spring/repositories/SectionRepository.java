package elysian.training.spring.repositories;

import elysian.training.spring.models.Section;
import org.springframework.data.repository.CrudRepository;


public interface SectionRepository extends CrudRepository<Section, Integer> {
}
