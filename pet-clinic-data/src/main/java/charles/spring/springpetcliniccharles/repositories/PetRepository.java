package charles.spring.springpetcliniccharles.repositories;

import charles.spring.springpetcliniccharles.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
