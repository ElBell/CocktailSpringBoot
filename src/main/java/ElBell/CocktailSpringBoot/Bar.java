//sudo mysql --password
//Opensaysme!
package ElBell.CocktailSpringBoot;

import java.net.URL;
import java.util.*;

//
public class Bar {
    private static Map<Long, String> idToNameMap = new HashMap<>();
    private static Bar bar = null;
    private static List<Drink> drinks = new ArrayList<>();
    private static List<String> categories = new ArrayList<>();
    private static List<String> ingredients = new ArrayList<>();
    private static List<String> glasses = new ArrayList<>();

    private Bar() {

    }
    public static Bar getInstance()
    {
        if (bar == null)
            bar = new Bar();

        return bar;
    }

    public static Map<Long, String> getIdToNameMap() {
        return idToNameMap;
    }

    public static void addToMap(Long id, String name) {
        idToNameMap.put(id, name);
    }

    public static List<Drink> getDrinks() {
        return drinks;
    }

    public static void addDrink(String name, URL url, Long id) {
        Drink drink = new Drink(name, url, id);
        drinks.add(drink);
    }

    public static void addDrinks(Drink[] newDrinks) {
        drinks.addAll(Arrays.asList(newDrinks));
    }


    public static void addCategories(String[] newCategories) {
        categories.addAll(Arrays.asList(newCategories));
    }

    public static void addIngredients(String[]  newIngredients) {
        ingredients.addAll(Arrays.asList(newIngredients));
    }

    public static void addGlasses(String[] newGlasses) {
        glasses.addAll(Arrays.asList(newGlasses));
    }

    public static String getMenu() {
        Collections.sort(drinks);
        StringBuilder allDrinks = new StringBuilder("We offer:\n");
        for(Drink drink : drinks) {
            allDrinks.append(drink.getName() + "\n");
        }
        return allDrinks.toString();
    }

    public static int getNumberOfDrinks() {
        return drinks.size();
    }

    public static String getDrinkOptions() {
        Collections.sort(glasses);
        StringBuilder allDrinks = new StringBuilder("Drinks are served in:\n");
        for(String glass : glasses) {
            allDrinks.append(glass + "\n");
        }
        return allDrinks.toString();
    }
}
