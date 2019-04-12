package ElBell.CocktailSpringBoot.controllers;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.entities.Glass;
import ElBell.CocktailSpringBoot.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public @ResponseBody ResponseEntity<Iterable<Drink>> findAllDrinks() {
        return new ResponseEntity<>(drinkService.findAllDrinks(), HttpStatus.OK);
    }

    @GetMapping("/drinks/{drinkId}")
    public @ResponseBody ResponseEntity<Drink> findDrinkById(@PathVariable(value = "drinkId") Integer searchDrink) {
        return new ResponseEntity<>(drinkService.findDrinkById(searchDrink), HttpStatus.OK);
    }

    @PostMapping("/drinks")
    public @ResponseBody ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
            return new ResponseEntity<>(drinkService.createDrink(drink), HttpStatus.CREATED);
    }

    @PutMapping("/drinks/{drinkId}")
    public @ResponseBody ResponseEntity<Drink> updateDrink(@PathVariable Integer drinkId,  @RequestBody Drink drinkRequest) {
        return new ResponseEntity<>(drinkService.updateDrink(drinkId, drinkRequest), HttpStatus.OK);
    }

    @DeleteMapping("/drinks/{drinkId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrink(@PathVariable Integer drinkId) {
        drinkService.deleteDrink(drinkId);
    }

    @GetMapping(value = "/ingredients/limit/{ingredientNames}")
    public @ResponseBody ResponseEntity<Iterable<Drink>> findByIngredient_Limit(@PathVariable List<String> ingredientNames) {
        return new ResponseEntity<>(drinkService.findByIngredient_Limit(ingredientNames), HttpStatus.OK);
    }

    @GetMapping(value = "/ingredients/include/{ingredientNames}")
    public @ResponseBody ResponseEntity<Iterable<Drink>> findByIngredient_Include(@PathVariable List<String> ingredientNames) {
        return new ResponseEntity<>(drinkService.findByIngredient_Include(ingredientNames), HttpStatus.OK);
    }

    @GetMapping(value="/ingredients")
    public @ResponseBody ResponseEntity<Iterable<String>> findAllIngredients() {
        return new ResponseEntity<>(drinkService.findAllIngredients(), HttpStatus.OK);
    }

}
