package ElBell.CocktailSpringBoot.services;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.entities.Glass;
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

    public Drink findDrinkByName(String searchDrink) {
        return drinkRepository.findByName(searchDrink);
    }

    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Drink updateDrink(Integer drinkId, Drink drinkRequest) {
        drinkRepository.deleteById(drinkId);
        return drinkRepository.save(drinkRequest);
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

    public Set<Drink> findByIngredient_Limit(List<String> ingredentNames) {
        return StreamSupport.stream(drinkRepository.findAll().spliterator(), false)
                .filter(drink -> drink.containsAll(ingredentNames)).collect(Collectors.toCollection(HashSet::new));
    }

    public Set<String> findAllIngredients() {
        Set<String> ingredients = new TreeSet<>();
        for (Drink drink : drinkRepository.findAll()) {
            drink.getIngredients().forEach(ingredient -> ingredients.add(ingredient.getName().toLowerCase()));
        }
        return ingredients;
    }

    public Set<Glass> findAllGlasses() {
        Set<Glass> glasses = new HashSet<>();
        drinkRepository.findAll().forEach(drink -> glasses.add(drink.getGlass()));
        return glasses;
    }

    public void deleteDrink(String name) {
        if (drinkRepository.findByName(name) != null) {
            drinkRepository.delete(drinkRepository.findByName(name));
        }
    }
}
