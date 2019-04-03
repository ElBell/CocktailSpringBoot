package ElBell.CocktailSpringBoot.entities;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class GlassTest {

    @Test
    public void setId() {
        //Given
        Glass glass = new Glass();
        int expected = 3245;

        //When
        glass.setId(expected);

        //Then
        int actual = glass.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setName() {
        //Given
        Glass glass = new Glass();
        String expected = "testName";

        //When
        glass.setName(expected);

        //Then
        String actual = glass.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setImage() throws URISyntaxException {
        //Given
        Glass glass = new Glass();
        URI expected = new URI("");

        //When
        glass.setImage(expected);

        //Then
        URI actual = glass.getImage();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setDrinks() {
        //Given
        Glass glass = new Glass();
        Set<Drink> expected = new HashSet<>();
        expected.add(new Drink());
        expected.add(new Drink());

        //When
        glass.setDrinks(expected);

        //Then
        Set<Drink> actual = glass.getDrinks();
        Assert.assertEquals(expected, actual);
    }
}