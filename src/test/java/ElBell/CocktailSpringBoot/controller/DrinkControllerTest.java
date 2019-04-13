package ElBell.CocktailSpringBoot.controller;

import ElBell.CocktailSpringBoot.entities.Drink;
import ElBell.CocktailSpringBoot.services.DrinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DrinkControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DrinkService drinkService;

    @Test
    public void testShow() throws Exception {
        int givenId = 1;
        Drink drink = new Drink();
        drink.setId(givenId);
        drink.setName("testDrink");
        BDDMockito
                .given(drinkService.findDrinkById(givenId))
                .willReturn(drink);

        String expectedContent = "{\"id\":1,\"name\":\"testDrink\",\"image\":null,\"alcoholic\":false,\"instructions\":null,\"ingredients\":null,\"glass\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/cocktail/drinks/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testFindAll() throws Exception {
        int givenId = 2;
        Drink drink = new Drink();
        drink.setId(givenId);
        drink.setName("testDrink");
        Drink drink1 = new Drink();
        drink1.setId(3);
        drink1.setName("testDrink2");
        drinkService.createDrink(drink);
        drinkService.createDrink(drink1);
        List<Drink> drinks = new ArrayList<>();
        drinks.add(drink);
        Iterable<Drink> testDrinks = drinks;
        BDDMockito
                .given(drinkService.findAllDrinks())
                .willReturn(testDrinks);

        String expectedContent = "[{\"id\":2,\"name\":\"testDrink\",\"image\":null,\"alcoholic\":false,\"instructions\":null,\"ingredients\":null,\"glass\":null}]";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/cocktail/drinks/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testUpdate() throws Exception {
        int givenId = 2;
        Drink drink = new Drink();
        drink.setId(givenId);
        drink.setName("testDrink");
        BDDMockito.
                given(drinkService.createDrink(any(Drink.class)))
                .willReturn(drink);

        String input = "{\"idDrink\":2,\"strDrink\":\"Applejack\",\"strDrinkAlternate\":null,\"strDrinkES\":null,\"strDrinkDE\":null,\"strDrinkFR\":null,\"strDrinkZH-HANS\":null,\"strDrinkZH-HANT\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Add all ingredients into mixing glass, chill and strain into cocktail glass\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/sutyqp1479209062.jpg\",\"strIngredient1\":\"Jack Daniels\",\"strIngredient2\":\"Midori melon liqueur\",\"strIngredient3\":\"Sour mix\",\"strIngredient4\":\"\",\"strIngredient5\":\"\",\"strIngredient6\":\"\",\"strIngredient7\":\"\",\"strIngredient8\":\"\",\"strIngredient9\":\"\",\"strIngredient10\":\"\",\"strIngredient11\":\"\",\"strIngredient12\":\"\",\"strIngredient13\":\"\",\"strIngredient14\":\"\",\"strIngredient15\":\"\",\"strMeasure1\":\"1 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"2 oz \",\"strMeasure4\":\" \",\"strMeasure5\":\" \",\"strMeasure6\":\" \",\"strMeasure7\":\" \",\"strMeasure8\":\" \",\"strMeasure9\":\"\",\"strMeasure10\":\"\",\"strMeasure11\":\"\",\"strMeasure12\":\"\",\"strMeasure13\":\"\",\"strMeasure14\":\"\",\"strMeasure15\":\"\",\"dateModified\":\"2016-11-15 11:24:22\"}";
        this.mvc.perform(MockMvcRequestBuilders
                .put("/cocktail/drinks/" + givenId)
                .content(input)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testPostTransaction() throws Exception{
        int givenId = 2;
        Drink drink = new Drink();
        drink.setId(givenId);
        drink.setName("testDrink");
        BDDMockito.
            given(drinkService.createDrink(any(Drink.class)))
                .willReturn(drink);

        String input = "{\"idDrink\":2,\"strDrink\":\"Applejack\",\"strDrinkAlternate\":null,\"strDrinkES\":null,\"strDrinkDE\":null,\"strDrinkFR\":null,\"strDrinkZH-HANS\":null,\"strDrinkZH-HANT\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Add all ingredients into mixing glass, chill and strain into cocktail glass\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/sutyqp1479209062.jpg\",\"strIngredient1\":\"Jack Daniels\",\"strIngredient2\":\"Midori melon liqueur\",\"strIngredient3\":\"Sour mix\",\"strIngredient4\":\"\",\"strIngredient5\":\"\",\"strIngredient6\":\"\",\"strIngredient7\":\"\",\"strIngredient8\":\"\",\"strIngredient9\":\"\",\"strIngredient10\":\"\",\"strIngredient11\":\"\",\"strIngredient12\":\"\",\"strIngredient13\":\"\",\"strIngredient14\":\"\",\"strIngredient15\":\"\",\"strMeasure1\":\"1 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"2 oz \",\"strMeasure4\":\" \",\"strMeasure5\":\" \",\"strMeasure6\":\" \",\"strMeasure7\":\" \",\"strMeasure8\":\" \",\"strMeasure9\":\"\",\"strMeasure10\":\"\",\"strMeasure11\":\"\",\"strMeasure12\":\"\",\"strMeasure13\":\"\",\"strMeasure14\":\"\",\"strMeasure15\":\"\",\"dateModified\":\"2016-11-15 11:24:22\"}";
        String expectedContent = "{\"id\":2,\"name\":\"testDrink\",\"image\":null,\"alcoholic\":false,\"instructions\":null,\"ingredients\":null,\"glass\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/cocktail/drinks")
                .content(input)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent))
                .andDo(MockMvcResultHandlers.print());
    }

}
