//Highball-Glass by Renee Ramsey-Passmore from the Noun Project

package ElBell.CocktailSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Glass {
    @Id
    @JsonIgnore
    @GeneratedValue
    private int id;
    private String name;
    private URI image;
    @OneToMany(mappedBy = "glass", cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Drink> drinks;

    public Glass(String name, String location) {
        this.name = name;
        try {
            this.image = new URI(String.format("https://static.thenounproject.com/png/%s-200.png", location));
        } catch (URISyntaxException e) {
            System.out.println(name);
            e.printStackTrace();
        }
    }

    public Glass() {
    }

    public static Glass getGlass(String name) {
        return images.get(name);
    }


    private static Map<String, Glass> images= new HashMap<>();
    static {
            images.put("Highball glass", new Glass("Highball glass", "59406"));
            images.put("Cocktail glass", new Glass("Cocktail glass", "100531"));
            images.put("Old-fashioned glass", new Glass("Old-fashioned glass", "1642272"));
            images.put("Collins glass", new Glass("Collins glass", "485037"));
            images.put("Champagne flute", new Glass("Champagne flute", "244518"));
            images.put("Whiskey sour glass", new Glass("Whiskey sour glass", "9241"));
            images.put("Brandy snifter", new Glass("Brandy snifter", "206073"));
            images.put("White wine glass", new Glass("White wine glass", "30567"));
            images.put("Nick and Nora Glass", new Glass("Nick and Nora Glass", "1861819"));
            images.put("Hurricane glass", new Glass("Hurricane glass", "206076"));
            images.put("Coffee mug", new Glass("Coffee mug", "62396"));
            images.put("Shot glass", new Glass("Shot glass", "13495"));
            images.put("Jar", new Glass("Jar", "358634"));
            images.put("Irish coffee cup", new Glass("Irish coffee cup", "1190986"));
            images.put("Punch bowl", new Glass("Punch bowl", "1036349"));
            images.put("Pitcher", new Glass("Pitcher", "1040385"));
            images.put("Pint glass", new Glass("Pint glass", "13499"));
            images.put("Copper Mug", new Glass("Copper Mug", "813163"));
            images.put("Wine Glass", new Glass("Wine Glass", "30567"));
            images.put("Cordial glass", new Glass("Cordial glass", "206067"));
            images.put("Beer mug", new Glass("Beer mug", "218309"));
            images.put("Margarita\\/Coupette glass", new Glass("Margarita\\/Coupette glass", "59413"));
            images.put("Beer pilsner", new Glass("Beer pilsner", "30565"));
            images.put("Beer Glass", new Glass("Beer Glass", "201216"));
            images.put("Parfait glass", new Glass("Parfait glass", "200140"));
            images.put("Mason jar", new Glass("Mason jar", "30644"));
            images.put("Margarita glass", new Glass("Margarita glass", "206083"));
            images.put("Martini Glass", new Glass("Martini Glass", "753671"));
            images.put("Balloon Glass", new Glass("Balloon Glass", "72954"));
            images.put("Coupe Glass", new Glass("Coupe Glass", "30561"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getImage() {
        return image;
    }

    public void setImage(URI image) {
        this.image = image;
    }

    public Set<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<Drink> drinks) {
        this.drinks = drinks;
    }
}
