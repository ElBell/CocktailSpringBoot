package ElBell.CocktailSpringBoot.services;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.entities.Ingredient;
import ElBell.CocktailSpringBoot.repositories.DrinkRepository;
import ElBell.CocktailSpringBoot.utilities.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Iterable<Drink> findAllDrinks() {
        // This returns a JSON with the drinks
        return drinkRepository.findAll();
    }

    public Drink findDrinkById(Integer searchDrink) {
        return drinkRepository.findById(searchDrink)
                .orElseThrow(() -> new ResourceNotFoundException("Drink", "id", searchDrink));
    }

    public Drink createDrink(Drink drink) {
        try {
            return drinkRepository.save(drink);
        } catch (NullPointerException e) {
            System.out.println(drink);
            return null;
        }
    }

    public Drink updateDrink(Integer drinkId, Drink drinkRequest) {
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

    public void deleteDrink(Integer drinkId) {
        drinkRepository.deleteById(drinkId);
    }

    public Set<Drink> findByIngredient_Include(List<String> ingredientNames) {
        Set<Drink> drinks = new HashSet<>();
        for (Drink drink : drinkRepository.findAll()) {
            for (String ingredientName : ingredientNames) {
                if (drink.containsIngredient(ingredientName)) {
                    drinks.add(drink);
                }
            }
        }
        return drinks;
    }

    public List<Drink> findByIngredient_Limit(List<String> ingredentNames) {
        return StreamSupport.stream(drinkRepository.findAll().spliterator(), false)
                .filter(drink -> drink.containsAll(ingredentNames)).collect(Collectors.toCollection(ArrayList::new));
    }

    public Set<String> findAllIngredients() {
        Set<String> ingredients = new TreeSet<>();
        for (Drink drink : drinkRepository.findAll()) {
            drink.getIngredients().forEach(ingredient -> ingredients.add(ingredient.getName().toLowerCase()));
        }
        return ingredients;
    }

}
