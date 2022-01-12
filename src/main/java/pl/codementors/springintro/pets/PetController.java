package pl.codementors.springintro.pets;

import org.springframework.web.bind.annotation.*;
import pl.codementors.springintro.pets.model.Pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class PetController {

    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final Map<Integer, Pet> pets = new HashMap<>();

    @GetMapping("/api/pets")
    public Collection<Pet> getPets(@RequestParam(defaultValue = "") String q) {
        return pets.values()
                .stream()
                .filter(p -> p.getName().toUpperCase().contains(q.toUpperCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/pets/{id}")
    public Pet getPet(@PathVariable int id) {
        return pets.get(id);
    }

    @PostMapping("/api/pets")
    public void createPet(@RequestBody Pet pet) {
        var id = idGenerator.getAndIncrement();
        pets.put(id, pet.withId(id));
    }
}
