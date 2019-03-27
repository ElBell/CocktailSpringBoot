package ElBell.CocktailSpringBoot.entities;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void testNullaryConstructor() {
        //When
        Ingredient ingredient = new Ingredient();

        //Then
        Assert.assertNull(ingredient.getName());
    }

    @Test
    public void testConstructor() {
        //Given
        String expected = "testName";

        //When
        Ingredient ingredient = new Ingredient( "testName", "1oz");

        //Then
        //Assert.assertEquals(ingredient.getName());
    }

    @Test
    public void testGetName() {
        //Given
        String expected = "testingredient";

        //When
        Ingredient ingredient = new Ingredient("testingredient", "1/2 oz ");

        //Then
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        //Given
        Ingredient ingredient = new Ingredient("testingredient", "1/2 oz ");
        String expected = "aDifferentName";

        //When
        ingredient.setName(expected);

        //Then
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetNameNull() {
        //Given
        Ingredient ingredient = new Ingredient("testingredient", "1/2 oz ");

        //When
        ingredient.setName(null);

        //Then
        String actual = ingredient.getName();
        Assert.assertNull(actual);
    }

    @Test
    public void testSetNameNumber() {
        //Given
        Ingredient ingredient = new Ingredient("testingredient", "1/2 oz ");
        String expected = "1000";

        //When
        ingredient.setName(expected);

        //Then
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAmount() {
        //Given
        Ingredient ingredient = new Ingredient("testingredient", "1/2 oz ");
        String expected = "1000";

        //When
        ingredient.setName(expected);

        //Then
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testGetAmountNull() {
        String expected = null;
        Ingredient ingredient = new Ingredient("testingredient", expected);

        //When
        String actual = ingredient.getAmount();

        //Then
        Assert.assertNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNameNull() {
        String expected = null;
        Ingredient ingredient = new Ingredient(expected, "1oz");

        //When
        String actual = ingredient.getAmount();

        //Then
        Assert.assertNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testGetAmountNone() {
        String expected = " ";
        Ingredient ingredient = new Ingredient("testingredient", expected);

        //When
        String actual = ingredient.getAmount();

        //Then
        Assert.assertNull(actual);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetAmountNewLine() {
        String expected = "/n";
        Ingredient ingredient = new Ingredient("testingredient", expected);

        //When
        String actual = ingredient.getAmount();

        //Then
        Assert.assertNull(actual);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetAmountInvalid() {
        String expected = "invalid";
        Ingredient ingredient = new Ingredient("testingredient", expected);

        //When
        String actual = ingredient.getAmount();

        //Then
        Assert.assertNull(actual);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNameNone() {
        String expected = " ";
        Ingredient ingredient = new Ingredient(expected, "1oz");

        //When
        String actual = ingredient.getAmount();

        //Then
        Assert.assertNull(actual);
    }

    @Test
    public void testOunces1oz() {
        String inputAmount = "1oz";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 1;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testOuncesFraction0z() {
        String inputAmount = "1 1/2oz";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 1.5;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testOuncesDecimal0z() {
        String inputAmount = "1.5oz";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 1.5;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testOuncesDecimal20z() {
        String inputAmount = ".5oz";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = .5;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }


    @Test
    public void testParts1oz() {
        String inputAmount = "1 parts";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 1;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testPartsFraction0z() {
        String inputAmount = "1 part";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 1;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testPartsDecimal0z() {
        String inputAmount = "1.5parts";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 1.5;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testPartsDecimal20z() {
        String inputAmount = ".5parts";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = .5;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testtblsp() {
        String inputAmount = "1 1/2 tblsp";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 0.75;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testcan() {
        String inputAmount = "1 1/2 can";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 18;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testtsp() {
        String inputAmount = "1 1/2 tsp";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 0.250;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testDash() {
        String inputAmount = "1 1/2 dash";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 0.046875;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSplash() {
        String inputAmount = "1 1/2 splash";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 0.3;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testJuice() {
        String inputAmount = "1 1/2 Juice";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 3;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCl() {
        String inputAmount = "1 1/2 cl";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 0.507;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testShot() {
        String inputAmount = "1 1/2 shot";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 2.25;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testJigger() {
        String inputAmount = "1 1/2 jigger";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 2.25;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testScoop() {
        String inputAmount = "1 1/2 scoop";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 6;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testTwist() {
        String inputAmount = "1 1/2 twist";
        Ingredient ingredient = new Ingredient("testingredient", inputAmount);
        double expected = 0;

        //When
        double actual = ingredient.getOunces();

        //Then
        Assert.assertEquals(expected, actual, 0.01);
    }
}