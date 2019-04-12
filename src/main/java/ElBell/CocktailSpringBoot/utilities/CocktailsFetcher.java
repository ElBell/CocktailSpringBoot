package ElBell.CocktailSpringBoot.utilities;

import ElBell.CocktailSpringBoot.repositories.DrinkRepository;
import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.services.DrinkService;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingException;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CocktailsFetcher {

    @Autowired
    private DrinkService drinkService;
    private List<DrinkReference> referenceList = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void initJsonConfig() {
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

    //@EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initJsonConfig();
        fetchListOfOrdinaryDrinks();
        fetchListOfCocktails();
        fetchFullDrinks();
        saveAllDrinks();
    }

    private void saveAllDrinks() {
        for(Drink drink : Bar.getDrinks()) {
            drinkService.createDrink(drink);
        }
    }
//
//    public static void main(String[] args) throws IOException {
//        initJsonConfig();
//        CocktailsFetcher cocktailsFetcher = new CocktailsFetcher();
//        cocktailsFetcher.fetchListOfOrdinaryDrinks();
//        cocktailsFetcher.fetchListOfCocktails();
//        cocktailsFetcher.fetchFullDrinks();
//        BufferedWriter writer = new BufferedWriter(new FileWriter("url.txt", true));
//        Bar.getDrinks().forEach(drink -> {
//            try {
//                writer.append(drink.getImage().toString() + "\n");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        writer.close();
//    }

    public void fetchListOfCocktails() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail");
        DrinkReference[] drinks = JsonPath.parse(raw).read("$.drinks", DrinkReference[].class);
        referenceList.addAll(Arrays.asList(drinks));
    }

    public void fetchListOfOrdinaryDrinks() {
        String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Ordinary_Drink");
        DrinkReference[] drinks = JsonPath.parse(raw).read("$.drinks", DrinkReference[].class);
        referenceList.addAll(Arrays.asList(drinks));
    }

    public void fetchFullDrinks() {
        for (DrinkReference reference : referenceList) {
            String raw = fetchRaw("https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + reference.getId());
            try {
                Bar.addDrink(JsonPath.parse(raw).read("$.drinks[0]", Drink.class));
            } catch (IllegalArgumentException | MappingException e) {
                System.out.println(raw);
                //If something goes wrong, print the offending json
            }
        }
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

    public List<DrinkReference> getReferenceList() {
        return referenceList;
    }
}
