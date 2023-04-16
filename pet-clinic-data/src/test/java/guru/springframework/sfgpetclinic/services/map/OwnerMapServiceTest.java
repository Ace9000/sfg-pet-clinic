package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Smith";
    @BeforeEach
    void setUp() {

    }
    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }
    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }
    @Test
    void saveExistingId() {
    }
    @Test
    void saveNoId() {

        Owner saveOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());

    }
    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }
    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }
    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId, smith.getId());
    }
}