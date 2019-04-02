package ElBell.CocktailSpringBoot.entities;

import ElBell.CocktailSpringBoot.utilities.CocktailsFetcher;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DrinkTest {

    private Drink drink;
    @Before
    public void setUp() {
        CocktailsFetcher.initJsonConfig();
        drink = new Drink();

    }

    @Test
    public void testNullaryConstructor() {
        //When
        String actual = drink.getName();

        //Then
        Assert.assertNull(actual);
    }

    @Test
    public void testJsonConstructor() {
        //Given
        String expectedName = "Oatmeal Cookie";
        boolean expectedAlcoholic = true;
        int expectedNumIngredients = 5;


        //When
        String raw =  "{\"drinks\":[{\"idDrink\":\"17266\",\"strDrink\":\"Oatmeal Cookie\",\"strDrinkAlternate\":null,\"strDrinkES\":null,\"strDrinkDE\":null,\"strDrinkFR\":null,\"strDrinkZH-HANS\":null,\"strDrinkZH-HANT\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Mason jar\",\"strInstructions\":\"Just mix it all together.\\r\\nIt's meant to be a shot, but it works just fine as a proper adult-sized drink over lots of ice.\\r\\n\\r\\nTastes like an oatmeal cookie.\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/bsvmlg1515792693.jpg\",\"strIngredient1\":\"Kahlua\",\"strIngredient2\":\"Bailey\",\"strIngredient3\":\"Butterscotch schnapps\",\"strIngredient4\":\"Jagermeister\",\"strIngredient5\":\"Goldschlager\",\"strIngredient6\":\"\",\"strIngredient7\":\"\",\"strIngredient8\":null,\"strIngredient9\":null,\"strIngredient10\":null,\"strIngredient11\":null,\"strIngredient12\":null,\"strIngredient13\":null,\"strIngredient14\":null,\"strIngredient15\":null,\"strMeasure1\":\"2 parts\",\"strMeasure2\":\"2 parts\",\"strMeasure3\":\"4 parts\",\"strMeasure4\":\"1 part\",\"strMeasure5\":\"1\\/2 part\",\"strMeasure6\":\"\",\"strMeasure7\":\"\",\"strMeasure8\":null,\"strMeasure9\":null,\"strMeasure10\":null,\"strMeasure11\":null,\"strMeasure12\":null,\"strMeasure13\":null,\"strMeasure14\":null,\"strMeasure15\":null,\"dateModified\":\"2018-01-12 21:31:33\"}]}";
        Drink drink = JsonPath.parse(raw).read( "$.drinks[0]", Drink.class);

        //Then
        String actualName = drink.getName();
        boolean actualAlcoholic = drink.isAlcoholic();
        int actualNumIngredients = drink.getIngredients().size();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAlcoholic, actualAlcoholic);
        Assert.assertEquals(expectedNumIngredients, actualNumIngredients);
    }

    @Test
    public void testSetId() {
        //Given
        Drink drink = new Drink();
        long expected = 12433564768L;

        //When
        drink.setId(expected);

        //Then
        Long actual = drink.getId();
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void testSetIdNull() {
        //Given
        Drink drink = new Drink();
        Long expected = null;

        //When
        drink.setId(expected);

        //Then
        Long actual = drink.getId();
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSetName() {
        //Given
        Drink drink = new Drink();
        String expected = "testDrinkasdf";

        //When
        drink.setName(expected);

        //Then
        String actual = drink.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetNameNull() {
        //Given
        Drink drink = new Drink();
        String expected = null;

        //When
        drink.setName(expected);

        //Then
        String actual = drink.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetImage() throws MalformedURLException {
        //Given
        Drink drink = new Drink();
        URL expected = new URL("https://www.thecocktaildb.com/images/media/drink/bsvmlg1515792693.jpg");

        //When
        drink.setImage(expected);

        //Then
        URL actual = drink.getImage();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetAlcoholicTrue() {
        //Given
        Drink drink = new Drink();

        //When
        drink.setAlcoholic(true);

        //Then
        Assert.assertTrue(drink.isAlcoholic());
    }

    @Test
    public void testSetAlcoholicFalse() {
        //Given
        Drink drink = new Drink();

        //When
        drink.setAlcoholic(false);

        //Then
        Assert.assertFalse(drink.isAlcoholic());
    }

    @Test
    public void testSetGlass() {
        //Given
        Glass expected = new Glass();
        Drink drink = new Drink();

        //When
        drink.setGlass(expected);

        //Then
        Glass actual = drink.getGlass();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetInstructions() {
    }

    @Test
    public void testSetIngredients() {
    }

    @Test
    public void testCompareTo() {
    }

    @Test
    public void testToString() {
    }
}
