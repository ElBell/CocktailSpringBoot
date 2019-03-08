package ElBell.CocktailSpringBoot;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CocktailsFetcher {
    @Autowired
    private DrinkRepository drinkRepository;
    private static Bar bar = Bar.getInstance();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //private static MainController mainController = new MainController();

    private static void initJsonConfig() {
        Configuration.setDefaults(new Configuration.Defaults() {

            private final JsonProvider jsonProvider = new JacksonJsonProvider();
            private final MappingProvider mappingProvider = new JacksonMappingProvider();

            @Override
            public JsonProvider jsonProvider() {
                return jsonProvider;
            }

            @Override
            public MappingProvider mappingProvider() {
                return mappingProvider;
            }

            @Override
            public Set<Option> options() {
                return EnumSet.noneOf(Option.class);
            }
        });
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initJsonConfig();
        fetchOrdinaryDrinks();
        fetchCocktails();
        saveAllDrinks();
    }

    private void saveAllDrinks() {
        for(Drink drink : Bar.getDrinks()) {
            drinkRepository.save(drink);
            Bar.addToMap(drink.getId(), drink.getName());
        }
    }

    public void fetchCocktails() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail");
        Drink[] drinks = JsonPath.parse(raw).read("$.drinks", Drink[].class);
        Bar.addDrinks(drinks);
    }

    public void fetchOrdinaryDrinks() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Ordinary_Drink");
        Drink[] drinks = JsonPath.parse(raw).read("$.drinks", Drink[].class);
        Bar.addDrinks(drinks);
    }

    public void fetchGlasses() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/list.php?g=list");
        String[] glasses = JsonPath.parse(raw).read("$.drinks[*].strGlass", String[].class);
        Bar.addGlasses(glasses);
    }

    public void fetchIngredients() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/list.php?i=list");
        String[] ingredients = JsonPath.parse(raw).read("$.drinks", String[].class);
        Bar.addIngredients(ingredients);
    }

    public void fetchCategories() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list");
        String[] categories = JsonPath.parse(raw).read("$.drinks", String[].class);
        Bar.addCategories(categories);
    }


    public String fetchRaw(String StringUrl) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        String webpage = "";

        try {
            url = new URL(StringUrl);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                webpage += line;
            }
        } catch (
                MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return webpage;
    }
}
