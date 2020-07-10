package charles.spring.springpetcliniccharles.services;

import charles.spring.springpetcliniccharles.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
