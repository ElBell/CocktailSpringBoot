package ElBell.CocktailSpringBoot.entities;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public enum  Glasses {
    HIGHBALL("59406"),
    COCKTAIL("100531"),
    OLDFASHIONED("1642272"),
    COLLINS("485037"),
    CHAMPAGNEFLUTE("244518"),
    WHISKEYSOUR("9241"),
    BRANDYSNIFTER("206073"),
    WHITEWINE("30567"),
    NICKANDNORA("1861819"),
    HURRICANE("206076"),
    COFFEE("62396"),
    SHOT("13495"),
    JAR("358634"),
    IRISHCOFFEE("1190986"),
    PUNCHBOWL("1036349"),
    PITCHER("1040385"),
    PINT("13499"),
    COPPERMUG("813163"),
    WINE("30567"),
    CORDIAL("206067"),
    BEERMUG("218309"),
    MARGARITACOUPETTE("59413"),
    BEERPILSNER("30565"),
    BEER("201216"),
    PARFAIT("200140"),
    MASONJAR("30644"),
    MARGARITA("206083"),
    MARTINI("753671"),
    BALLOON("72954"),
    COUPE("30561");

    private URI image;

    Glasses(String location) {
        try {
            this.image = new URI(String.format("https://static.thenounproject.com/png/%s-200.png", location));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public URI getImage() {
        return image;
    }

    public void setImage(URI image) {
        this.image = image;
    }
}
