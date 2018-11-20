package us.jzuehlke.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetShop
{
    @RequestMapping("/petshop")
    public List<Pet> getAllPets()
    {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Yo Quiero Taco Bell Dog", "Dog"));
        pets.add(new Pet("Citizen Snips", "Crab"));
        pets.add(new Pet("Stampy", "Elephant"));

        return pets;
    }
}
