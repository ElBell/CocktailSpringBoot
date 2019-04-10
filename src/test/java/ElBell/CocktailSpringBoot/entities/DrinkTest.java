package ElBell.CocktailSpringBoot.entities;

import ElBell.CocktailSpringBoot.utilities.CocktailsFetcher;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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
        Drink trialDrink = JsonPath.parse(raw).read( "$.drinks[0]", Drink.class);

        //Then
        String actualName = trialDrink.getName();
        boolean actualAlcoholic = trialDrink.isAlcoholic();
        int actualNumIngredients = trialDrink.getIngredients().size();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAlcoholic, actualAlcoholic);
        Assert.assertEquals(expectedNumIngredients, actualNumIngredients);
    }

    @Test
    public void testJsonConstructor2() {
        //Given
        String expectedName = "Applejack";
        Integer expectedId = 16311;
        String expectedGlassName = "Cocktail glass";
        String expectedInstructions = "Add all ingredients into mixing glass, chill and strain into cocktail glass";
        int expectedNumIngredients = 3;


        //When
        String raw =  "{\"drinks\":[{\"idDrink\":\"16311\",\"strDrink\":\"Applejack\",\"strDrinkAlternate\":null,\"strDrinkES\":null,\"strDrinkDE\":null,\"strDrinkFR\":null,\"strDrinkZH-HANS\":null,\"strDrinkZH-HANT\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Cocktail glass\",\"strInstructions\":\"Add all ingredients into mixing glass, chill and strain into cocktail glass\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/sutyqp1479209062.jpg\",\"strIngredient1\":\"Jack Daniels\",\"strIngredient2\":\"Midori melon liqueur\",\"strIngredient3\":\"Sour mix\",\"strIngredient4\":\"\",\"strIngredient5\":\"\",\"strIngredient6\":\"\",\"strIngredient7\":\"\",\"strIngredient8\":\"\",\"strIngredient9\":\"\",\"strIngredient10\":\"\",\"strIngredient11\":\"\",\"strIngredient12\":\"\",\"strIngredient13\":\"\",\"strIngredient14\":\"\",\"strIngredient15\":\"\",\"strMeasure1\":\"1 oz \",\"strMeasure2\":\"1\\/2 oz \",\"strMeasure3\":\"2 oz \",\"strMeasure4\":\" \",\"strMeasure5\":\" \",\"strMeasure6\":\" \",\"strMeasure7\":\" \",\"strMeasure8\":\" \",\"strMeasure9\":\"\",\"strMeasure10\":\"\",\"strMeasure11\":\"\",\"strMeasure12\":\"\",\"strMeasure13\":\"\",\"strMeasure14\":\"\",\"strMeasure15\":\"\",\"dateModified\":\"2016-11-15 11:24:22\"}]}";
        Drink trialDrink = JsonPath.parse(raw).read( "$.drinks[0]", Drink.class);

        //Then
        String actualName = trialDrink.getName();
        Integer actualId = trialDrink.getId();
        String actualGlassName = trialDrink.getGlass().getName();
        String actualInstructions = trialDrink.getInstructions();
        int actualNumIngredients = trialDrink.getIngredients().size();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedId, actualId);
        Assert.assertEquals(expectedGlassName, actualGlassName);
        Assert.assertEquals(expectedInstructions, actualInstructions);
        Assert.assertEquals(expectedNumIngredients, actualNumIngredients);
    }


    @Test
    public void testJsonConstructorFullIngredients() {
        //Given
        String expectedName = "Oatmeal Cookie";
        boolean expectedAlcoholic = true;
        int expectedNumIngredients = 15;


        //When
        String raw =  "{\"drinks\":[{\"idDrink\":\"0\",\"strDrink\":\"Oatmeal Cookie\",\"strDrinkAlternate\":null,\"strDrinkES\":null,\"strDrinkDE\":null,\"strDrinkFR\":null,\"strDrinkZH-HANS\":null,\"strDrinkZH-HANT\":null,\"strTags\":null,\"strVideo\":null,\"strCategory\":\"Cocktail\",\"strIBA\":null,\"strAlcoholic\":\"Alcoholic\",\"strGlass\":\"Mason jar\",\"strInstructions\":\"Just mix it all together.\\r\\nIt's meant to be a shot, but it works just fine as a proper adult-sized drink over lots of ice.\\r\\n\\r\\nTastes like an oatmeal cookie.\",\"strInstructionsES\":null,\"strInstructionsDE\":null,\"strInstructionsFR\":null,\"strInstructionsZH-HANS\":null,\"strInstructionsZH-HANT\":null,\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/bsvmlg1515792693.jpg\",\"strIngredient1\":\"Kahlua\",\"strIngredient2\":\"Bailey\",\"strIngredient3\":\"Butterscotch schnapps\",\"strIngredient4\":\"Jagermeister\",\"strIngredient5\":\"Goldschlager\",\"strIngredient6\":\"MacandChesse\",\"strIngredient7\":\"potato\",\"strIngredient8\":\"love\",\"strIngredient9\":\"heart\",\"strIngredient10\":\"marshmallow\",\"strIngredient11\":\"shoes\",\"strIngredient12\":\"boot\",\"strIngredient13\":\"table\",\"strIngredient14\":\"lolly\",\"strIngredient15\":\"cheese\",\"strMeasure1\":\"2 parts\",\"strMeasure2\":\"2 parts\",\"strMeasure3\":\"4 parts\",\"strMeasure4\":\"1 part\",\"strMeasure5\":\"1\\/2 part\",\"strMeasure6\":\"1 part\",\"strMeasure7\":\"1 part\",\"strMeasure8\":\"1 part\",\"strMeasure9\":\"1 part\",\"strMeasure10\":\"1 part\",\"strMeasure11\":\"1 part\",\"strMeasure12\":\"1 part\",\"strMeasure13\":\"1 part\",\"strMeasure14\":\"1 part\",\"strMeasure15\":\"1 part\",\"dateModified\":\"2018-01-12 21:31:33\"}]}";
        Drink trialDrink = JsonPath.parse(raw).read( "$.drinks[0]", Drink.class);

        //Then
        String actualName = trialDrink.getName();
        boolean actualAlcoholic = trialDrink.isAlcoholic();
        int actualNumIngredients = trialDrink.getIngredients().size();
        System.out.println(trialDrink);

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAlcoholic, actualAlcoholic);
        Assert.assertEquals(expectedNumIngredients, actualNumIngredients);
    }

    @Test
    public void testSetId() {
        //Given
        Drink drink = new Drink();
        Integer expected = 124768;

        //When
        drink.setId(expected);

        //Then
        Integer actual = drink.getId();
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void testSetIdNull() {
        //Given
        Drink drink = new Drink();
        Integer expected = null;

        //When
        drink.setId(expected);

        //Then
        Integer actual = drink.getId();
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
        String expected = "bsvmlg1515792693.jpg";

        //When
        drink.setImage(expected);

        //Then
        String actual = drink.getImage();
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
        //Given
        String expected = "drink";

        //When
        drink.setInstructions(expected);

        //Then
        String actual = drink.getInstructions();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetIngredients() {
        //Given
        SortedSet<Ingredient> expected = new TreeSet<>();
        expected.add(new Ingredient());
        expected.add(new Ingredient());

        //When
        drink.setIngredients(expected);

        //Then
        SortedSet<Ingredient> actual = drink.getIngredients();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo() {
        //Given
        Drink firstDrink = new Drink();
        firstDrink.setName("Alpha");
        Drink secondDrink = new Drink();
        secondDrink.setName("Gamma");
        Drink[] drinks = new Drink[]{secondDrink, firstDrink};

        //When
        Arrays.sort(drinks);

        //Then
        Assert.assertEquals(drinks[0], firstDrink);
        Assert.assertEquals(drinks[1], secondDrink);
    }

    @Test
    public void testToString() {
        //Given
        String expected = "FullDrink{id=null\n" +
                ", name='null'\n" +
                ", image=null\n" +
                ", alcoholic=false\n" +
                ", glass='null'\n" +
                ", instructions='null'\n" +
                ", ingredientsnull'\n" +
                "}";

        //When
        String actual = drink.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }
}
