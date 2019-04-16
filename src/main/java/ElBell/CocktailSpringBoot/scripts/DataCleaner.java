package ElBell.CocktailSpringBoot.scripts;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.entities.Glass;
import ElBell.CocktailSpringBoot.entities.Ingredient;
import ElBell.CocktailSpringBoot.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

@Component

public class DataCleaner {
    @Autowired
    private DrinkService drinkService;
    private SortedSet<Ingredient> ingredients = new TreeSet<>();
    private Drink current;

    //@EventListener
    public void cleanData(ContextRefreshedEvent event) {
        current = drinkService.findDrinkByName("3-Mile Long Island Iced Tea");
        current.addIngredient(new Ingredient("Cola", "2/3 glass"));
        current.setGlass(Glass.getGlass("Highball glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("410 Gone");
        current.setInstructions("Fill glass with ice and pour in vodka. Fill 2/3 glass with Cola");
        current.addIngredient(new Ingredient("Cola", "2/3 Glass"));
        current.setGlass(Glass.getGlass("Old-fashioned glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("50/50");
        current.setInstructions("Fill glass with crushed ice. Add vodka. Add a splash of grand-marnier. Fill with o.j.");
        current.setGlass(Glass.getGlass("Martini Glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("501 Blue");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Blueberry Schnapps", "1oz"), new Ingredient("Vodka", "1oz"), new Ingredient("Blue Curacao", "1oz"), new Ingredient("Sour Mix", "1 dash"), new Ingredient("7-Up", "2 dashes")));
        current.setIngredients(ingredients);
        current.setInstructions("Mix ingredients besides 7-Up in shaker with ice. Pour into glass, top with 7-Up");
        current.setGlass(Glass.getGlass("Hurricane glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("69 Special");
        current.setGlass(Glass.getGlass("Old-fashioned glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("A midsummernight dream");
        current.setGlass(Glass.getGlass("Highball glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("Absolut Stress #2");
        current.setGlass(Glass.getGlass("Collins glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("Pink Panty Pulldowns");
        current.setGlass(Glass.getGlass("Highball glass"));
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Pink Lemonade", "2oz"), new Ingredient("Vodka", "1oz"), new Ingredient("7-Up", "3oz")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("Cuba Libre");
        current.addIngredient(new Ingredient("Cola", "2/3 glass"));
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("Arise My Love");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Champagne", "3 parts"), new Ingredient("Creme de Menthe", "2/3 Part")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("Champagne Cocktail");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Sugar", "1 cube"), new Ingredient("Angostura bitter", "1 dash"), new Ingredient("Cognac", "1oz"), new Ingredient("Champagne", "1/2 cup"), new Ingredient("Orange", "1 twist")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);
        current = drinkService.findDrinkByName("Lone Tree Cooler");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Powdered sugar", "1/2 oz"),
                new Ingredient("Club soda", "2 oz"),
                new Ingredient("Gin", "2 oz"),
                new Ingredient("Dry vermouth", "1/2 oz"),
                new Ingredient("Ginger ale", "1 oz"),
                new Ingredient("Orange", "1 twist"),
                new Ingredient("Lemon", "1 twist")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Quarter Deck Cocktail");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Light Rum", "1 1/2 oz"),
                new Ingredient("Cream sherry", "1/2 oz"),
                new Ingredient("Fresh Lime Juice", "1/2 oz")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Caipirinha");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Lime", "4 wedges"),
                new Ingredient("Brown sugar", "2 teaspoons"),
                new Ingredient("Cachaça", "1 2/3 oz")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Caipirissima");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Lime", "4 wedges"),
                new Ingredient("Brown sugar", "2 teaspoons"),
                new Ingredient("White rum", "1 2/3 oz")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Adam Sunrise");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Frozen Lemonade Concentrate", "8 ounce"),
                new Ingredient("Ice", "1 cup"),
                new Ingredient("Vodka", "750ml")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Ipamena");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Lime", "4 wedges"),
                new Ingredient("Passion fruit juice", "1/4 cup"),
                new Ingredient("Ice", "1 cup"),
                new Ingredient("Ginger Ale", "1/4 cup"),
                new Ingredient("sugar", "1 teaspoon")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Mimosa");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Champagne", "2 parts"),
                new Ingredient("Orange juice", "1 part")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        current = drinkService.findDrinkByName("Corn n Oil");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Rum", "2 oz"),
                new Ingredient("Falernum", "1/2 oz"),
                new Ingredient("Fresh lime juice", "1/2 oz"),
                new Ingredient("Angostura bitters", "3 dashes")));
        current.setIngredients(ingredients);
        drinkService.updateDrink(current.getId(), current);

        //New Drinks
        current = new Drink();
        current.setName("Princeton");
        current.setGlass(Glass.getGlass("Coupe Glass"));
        current.setInstructions("Stir the ingredients together with plenty of ice in a pitcher, then strain into a rocks or cocktail glass.  Squeeze a piece of lemon rind over the top to release a spray of oils, then drop into the glass.\n");
        current.setAlcoholic(true);
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Gin", "1.5 measure"), new Ingredient("Ruby Port", ".75 measure"), new Ingredient("Orange Bitters", ".25 measure")));
        current.setIngredients(ingredients);
        current.setImage("2015-05-02-20-54-15.jpg");
        current.setId(4000);
        drinkService.createDrink(current);
        current = new Drink();
        current.setName("Cilantro Jalapeño Margarita");
        current.setInstructions("Vigorously shake all ingredients in a shaker.\n" +
                "Muddle 3 sprigs of cilantro in the bottom of a glass.  Add ice.\n" +
                "Strain shaker ingredients over ice.");
        ingredients.clear();
        ingredients.addAll(Arrays.asList(new Ingredient("Sauza Signature Blue Silver Tequila", "1.5 oz"), new Ingredient("Triple Sec", "1.5 oz"), new Ingredient("Lime Juice", ".5 oz"), new Ingredient("Fresh Jalapeño", "1 slice")));
        current.setIngredients(ingredients);
        current.setAlcoholic(true);
        current.setImage("japapeno.jpeg");
        current.setId(4001);
        drinkService.createDrink(current);


        //Delete drinks
        drinkService.deleteDrink("Cuba Libra");
        drinkService.deleteDrink("After Supper Cocktail");


        //Check for missing ingredients
        for (Drink drink : drinkService.findAllDrinks()) {
            if (drink.getIngredients().size() == 0) {
                System.out.println(drink);
            }
        }
    }
}
