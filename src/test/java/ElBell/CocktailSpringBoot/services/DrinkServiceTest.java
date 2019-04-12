package ElBell.CocktailSpringBoot.services;

import ElBell.CocktailSpringBoot.CocktailApplication;
import ElBell.CocktailSpringBoot.controllers.DrinkController;
import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.entities.Ingredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CocktailApplication.class)
public class DrinkServiceTest {

    @MockBean
    private DrinkService service;

    private DrinkController controller;

    @Before
    public void setup(){
        this.controller = new DrinkController(service);
    }


    @Test
    public void testCreate() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        Drink expectedDrink = new Drink();
        BDDMockito
                .given(service.createDrink(expectedDrink))
                .willReturn(expectedDrink);

        // When
        ResponseEntity<Drink> response = controller.createDrink(expectedDrink);
        HttpStatus actual = response.getStatusCode();
        Drink actualDrink = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedDrink, actualDrink);
    }


    @Test
    public void testShow() {
        // Given
        HttpStatus expected = HttpStatus.OK;
        Drink expectedDrink = new Drink();
        BDDMockito.
                given(service.findDrinkById(1))
                .willReturn(expectedDrink);

        // When
        ResponseEntity<Drink> response = controller.findDrinkById(1);
        HttpStatus actual = response.getStatusCode();
        Drink actualDrink = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedDrink, actualDrink);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Drink> expectedDrinks = new ArrayList<>();
        expectedDrinks.add(new Drink());
        expectedDrinks.add(new Drink());
        expectedDrinks.add(new Drink());

        HttpStatus expected = HttpStatus.OK;

        BDDMockito.
                given(service.findAllDrinks())
                .willReturn(expectedDrinks);

        // When
        ResponseEntity<Iterable<Drink>> response = controller.findAllDrinks();
        HttpStatus actual = response.getStatusCode();
        List<Drink> actualDrinks = (List<Drink>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedDrinks, actualDrinks);
    }


    @Test
    public void testFindAllIngredients() {
        // Given
        Drink drink = new Drink();
        Drink drink1 = new Drink();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("something");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("somethingelse");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("somethingthethird");
        SortedSet<Ingredient> ingredients = new TreeSet<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient1);
        SortedSet<Ingredient> ingredients1 = new TreeSet<>();
        ingredients1.add(ingredient);
        ingredients1.add(ingredient2);
        drink.setIngredients(ingredients);
        drink1.setIngredients(ingredients1);

        Set<String> expectedIngredients = new HashSet<>();
        ingredients.forEach(i -> expectedIngredients.add(i.getName()));
        ingredients1.forEach(i -> expectedIngredients.add(i.getName()));

        HttpStatus expected = HttpStatus.OK;

        BDDMockito.
                given(service.findAllIngredients())
                .willReturn(expectedIngredients);

        // When
        ResponseEntity<Iterable<String>> response = controller.findAllIngredients();
        HttpStatus actual = response.getStatusCode();
        Set<String> actualIngredients = (Set<String>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void testFindByIngredientsLimit() {
        // Given
        Drink drink = new Drink();
        Drink drink1 = new Drink();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("something");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("somethingelse");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("somethingthethird");
        SortedSet<Ingredient> ingredients = new TreeSet<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient1);
        SortedSet<Ingredient> ingredients1 = new TreeSet<>();
        ingredients1.add(ingredient);
        ingredients1.add(ingredient2);
        drink.setIngredients(ingredients);
        drink1.setIngredients(ingredients1);

        List<String> drinkRequest = new ArrayList<>();
        drinkRequest.add("something");
        drinkRequest.add("somethingelse");
        Set<Drink> expectedDrink = new HashSet<>();
        expectedDrink.add(drink);

        HttpStatus expected = HttpStatus.OK;

        BDDMockito.
                given(service.findByIngredient_Limit(drinkRequest))
                .willReturn(expectedDrink);

        // When
        ResponseEntity<Iterable<Drink>> response = controller.findByIngredient_Limit(drinkRequest);
        HttpStatus actual = response.getStatusCode();
        Set<Drink> actualDrink = (Set<Drink>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedDrink, actualDrink);
    }


    @Test
    public void testFindByIngredientsInclude() {
        // Given
        Drink drink = new Drink();
        Drink drink1 = new Drink();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("something");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("somethingelse");
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("somethingthethird");
        SortedSet<Ingredient> ingredients = new TreeSet<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient1);
        SortedSet<Ingredient> ingredients1 = new TreeSet<>();
        ingredients1.add(ingredient);
        ingredients1.add(ingredient2);
        drink.setIngredients(ingredients);
        drink1.setIngredients(ingredients1);

        List<String> drinkRequest = new ArrayList<>();
        drinkRequest.add("something");
        drinkRequest.add("somethingelse");
        HashSet<Drink> expectedDrink = new HashSet<>();
        expectedDrink.add(drink);
        expectedDrink.add(drink1);

        HttpStatus expected = HttpStatus.OK;

        BDDMockito.
                given(service.findByIngredient_Include(drinkRequest))
                .willReturn(expectedDrink);

        // When
        ResponseEntity<Iterable<Drink>> response = controller.findByIngredient_Include(drinkRequest);
        HttpStatus actual = response.getStatusCode();
        Set<Drink> actualDrink = (Set<Drink>) response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedDrink, actualDrink);
    }
}
