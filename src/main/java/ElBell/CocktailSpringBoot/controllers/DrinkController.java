package ElBell.CocktailSpringBoot.controllers;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/cocktail")
public class DrinkController {
    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/drinks")
    public @ResponseBody
    Iterable<Drink> getAllDrinks() {
        return drinkService.findAllDrinks();
    }

    @GetMapping("/drinks/{drinkId}")
    public @ResponseBody
    Drink getDrinkById(@PathVariable(value = "drinkId") Integer searchDrink) {
        return drinkService.findDrinkById(searchDrink);
    }

    @PostMapping("/drinks")
    public Drink createDrink(@Valid @RequestBody Drink drink) {
            return drinkService.createDrink(drink);
    }

    @PutMapping("/drinks/{drinkId}")
    public Drink updateDrink(@PathVariable Integer drinkId, @Valid @RequestBody Drink drinkRequest) {
        return drinkService.updateDrink(drinkId, drinkRequest);
    }

    @DeleteMapping("/drinks/{drinkId}")
    public void deleteDrink(@PathVariable Integer drinkId) {
         drinkService.deleteDrink(drinkId);
    }

    @GetMapping(value = "/ingredients/limit/{ingredientNames}")
    public Iterable<Drink> findByIngredient_Limit(@PathVariable List<String> ingredientNames) {
        return drinkService.findByIngredient_Limit(ingredientNames);
    }

    @GetMapping(value = "/ingredients/include/{ingredientNames}")
    public Iterable<Drink> findByIngredient_Include(@PathVariable List<String> ingredientNames) {
        return drinkService.findByIngredient_Include(ingredientNames);
    }

    @GetMapping(value="/ingredients")
    public Iterable<String> findAllIngredients() {
        return drinkService.findAllIngredients();
    }

}
