package charles.spring.springpetcliniccharles.repositories;

import charles.spring.springpetcliniccharles.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
