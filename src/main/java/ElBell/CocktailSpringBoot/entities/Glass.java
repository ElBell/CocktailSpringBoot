//Highball-Glass by Renee Ramsey-Passmore from the Noun Project

package ElBell.CocktailSpringBoot.entities;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Glass {
    private String glassName;
    private URL glassImage;
    @OneToMany(mappedBy = "glass")
    private Set<Drink> drinks;

    public Glass(Integer glassId, String glassName) {
        this.glassName = glassName;
        try {
            this.glassImage = new URL("https://cdn2.iconfinder.com/data/icons/picons-basic-3/57/basic3-043_drink_soda-512.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static Glass getGlass(String glass) {
        return null;
    }

    // Will eventually fetch image specific to each type of glass
//    private URL getImageURL() {
//        try {
//            switch (glassName) {
//                case "Highball glass":
//                    return new URL("https://res.cloudinary.com/dxgnylu3t/image/upload/v1553533081/noun_Highball-Glass_59406.png");
//                case "Cocktail glass":
//                    return new URL()
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

    public String getGlassName() {
        return glassName;
    }

    public void setGlassName(String glassName) {
        this.glassName = glassName;
    }

    public URL getGlassImage() {
        return glassImage;
    }

    public void setGlassImage(URL glassImage) {
        this.glassImage = glassImage;
    }
}
