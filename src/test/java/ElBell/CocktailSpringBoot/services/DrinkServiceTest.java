package ElBell.CocktailSpringBoot.services;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.repositories.DrinkRepository;
import ElBell.CocktailSpringBoot.utilities.CocktailsFetcher;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DrinkServiceTest {

    @Autowired
    private DrinkService drinkService;

    @Before
    public void setUp() {
        CocktailsFetcher.initJsonConfig();
    }

    @Test
    public void findAllDrinks() {
        //Given
        String raw =  "{\"drinks\":[{\"idDrink\":\"17266\",\"strDrink\":\"Oatmeal Cookie\",\"strDrinkAlternate\":null,\"strDrinkES\":null,\"strDrinkDE\":null,\"strDrinkFR\":null,\"strDrinkZH-HANS\":null,\"strDrinkZH-HANT\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Mason jar\",\"strInstructions\":\"Just mix it all together.\\r\\nIt's meant to be a shot, but it works just fine as a proper adult-sized drink over lots of ice.\\r\\n\\r\\nTastes like an oatmeal cookie.\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/bsvmlg1515792693.jpg\",\"strIngredient1\":\"Kahlua\",\"strIngredient2\":\"Bailey\",\"strIngredient3\":\"Butterscotch schnapps\",\"strIngredient4\":\"Jagermeister\",\"strIngredient5\":\"Goldschlager\",\"strIngredient6\":\"MacandChesse\",\"strIngredient7\":\"potato\",\"strIngredient8\":\"love\",\"strIngredient9\":\"heart\",\"strIngredient10\":\"marshmallow\",\"strIngredient11\":\"shoes\",\"strIngredient12\":\"boot\",\"strIngredient13\":\"table\",\"strIngredient14\":\"lolly\",\"strIngredient15\":\"cheese\",\"strMeasure1\":\"2 parts\",\"strMeasure2\":\"2 parts\",\"strMeasure3\":\"4 parts\",\"strMeasure4\":\"1 part\",\"strMeasure5\":\"1\\/2 part\",\"strMeasure6\":\"1 part\",\"strMeasure7\":\"1 part\",\"strMeasure8\":\"1 part\",\"strMeasure9\":\"1 part\",\"strMeasure10\":\"1 part\",\"strMeasure11\":\"1 part\",\"strMeasure12\":\"1 part\",\"strMeasure13\":\"1 part\",\"strMeasure14\":\"1 part\",\"strMeasure15\":\"1 part\",\"dateModified\":\"2018-01-12 21:31:33\"}]}";
        Drink trialDrink = JsonPath.parse(raw).read( "$.drinks[0]", Drink.class);
        //When
        List<Drink> drinks = (List<Drink>) drinkService.findAllDrinks();
        //Then
        Assert.assertTrue(drinks.size() > 340);
    }

    @Test
    public void findDrinkById() {
        //Given
        String expected = "Oatmeal Cookie";
        //When
        String actual = drinkService.findDrinkById(17266).getName();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createDrink() {
        //Given
        String expected = "trial";
        Drink drink = new Drink();
        drink.setId(123456789);
        drink.setName(expected);
        drinkService.createDrink(drink);
        //When
        String actual = drinkService.findDrinkById(123456789).getName();
        //Then
        drinkService.deleteDrink(123456789);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateDrink() {
    }

    @Test
    public void deleteDrink() {
    }
}