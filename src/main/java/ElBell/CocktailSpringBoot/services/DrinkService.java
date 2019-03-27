package ElBell.CocktailSpringBoot.services;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.repositories.DrinkRepository;
import ElBell.CocktailSpringBoot.utilities.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    public Iterable<Drink> findAllDrinks() {
        // This returns a JSON with the drinks
        return drinkRepository.findAll();
    }

    public Drink findDrinkById(Long searchDrink) {
        return drinkRepository.findById(searchDrink)
                .orElseThrow(() -> new ResourceNotFoundException("Drink", "id", searchDrink));
    }

    public Drink createDrink(Drink drink) {
        try {
            return drinkRepository.save(drink);
        }catch (NullPointerException e) {
            System.out.println(drink);
            return null;
        }
    }

    public Drink updateDrink(Long drinkId, Drink drinkRequest) {
        return drinkRepository.findById(drinkId).map(drink -> {
            drink.setName(drinkRequest.getName());
            drink.setAlcoholic(drinkRequest.isAlcoholic());
            drink.setGlass(drinkRequest.getGlass());
            drink.setId(drinkRequest.getId());
            drink.setImage(drinkRequest.getImage());
            drink.setInstructions(drinkRequest.getInstructions());
            drink.setIngredients(drinkRequest.getIngredients());
            return drinkRepository.save(drink);
        }).orElseThrow(() -> new ResourceNotFoundException("Drink", "id", drinkId));
    }

    public void deleteDrink(Long drinkId) {
        drinkRepository.deleteById(drinkId);
    }

}
