package charles.spring.springpetcliniccharles.services.map;

import charles.spring.springpetcliniccharles.model.Owner;
import charles.spring.springpetcliniccharles.model.Pet;
import charles.spring.springpetcliniccharles.services.OwnerService;
import charles.spring.springpetcliniccharles.services.PetService;
import charles.spring.springpetcliniccharles.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){

                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                        if(pet.getId() == null){
                            Pet savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());
                        }

                    }else{
                        throw new RuntimeException("Pet Type is Required");
                    }
                });
            }

            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
