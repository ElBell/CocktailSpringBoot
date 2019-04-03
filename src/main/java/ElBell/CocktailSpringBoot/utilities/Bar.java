//sudo mysql --password
//Opensaysme!
package ElBell.CocktailSpringBoot.utilities;

import ElBell.CocktailSpringBoot.entities.Drink;

import java.util.*;

//
public class Bar {
    private static Bar bar = null;
    private static List<Drink> drinks = new ArrayList<>();

    private Bar() {

    }
    public static Bar getInstance()
    {
        if (bar == null)
            bar = new Bar();

        return bar;
    }

    public static List<Drink> getDrinks() {
        return drinks;
    }

    public static void addDrink(Drink newDrink) { drinks.add(newDrink); }

}
