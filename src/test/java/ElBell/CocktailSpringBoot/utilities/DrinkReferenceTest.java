package ElBell.CocktailSpringBoot.utilities;

import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static ElBell.CocktailSpringBoot.utilities.CocktailsFetcher.initJsonConfig;

public class DrinkReferenceTest {

    @Before
    public void setUp() {
        initJsonConfig();
    }

    @Test
    public void testJsonConstructor() {
        //Given

        Integer expected = 14029;
        Integer expected2 = 15346;


        //When
        String raw = "{\"drinks\":[{\"strDrink\":\"'57 Chevy with a White License Plate\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qyyvtu1468878544.jpg\",\"idDrink\":\"14029\"},{\"strDrink\":\"155 Belmont\",\"strDrinkThumb\":\"https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/yqvvqs1475667388.jpg\",\"idDrink\":\"15346\"}]}";
        DrinkReference[] drinks = JsonPath.parse(raw).read("$.drinks", DrinkReference[].class);

        //Then
        Integer actual = drinks[0].getId();
        Integer actual2 = drinks[1].getId();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }
}