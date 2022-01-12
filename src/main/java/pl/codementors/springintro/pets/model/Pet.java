package pl.codementors.springintro.pets.model;

import lombok.Value;
import lombok.With;

import java.time.LocalDate;

@Value
public class Pet {

    @With
    Integer id;
    String name;
    LocalDate birthdate;
    PetType type;
}
