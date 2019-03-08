package ElBell.CocktailSpringBoot;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.SortComparator;
import org.hibernate.validator.constraints.UniqueElements;

import java.net.URL;
import javax.persistence.*;

@Entity
//@Table(name = "drinks")
public class Drink implements Comparable<Drink> {

    @Id
    //@Column(name = "drinkId")
    private Long id;
    @UniqueElements
    //@Column(name = "drinkName")
    private String name;
    //@Column(name = "thumb")
    private URL thumb;
//    private List<String> ingredients;
//    private String glass;


    /*public Drink(CustomType custom) {
        //constructor Code
    }*/

    public Drink(@JsonProperty("strDrink") String name,
                 @JsonProperty("strDrinkThumb") URL thumb,
                 @JsonProperty("idDrink") Long id) {
        this.name = name;
        this.thumb = thumb;
        this.id = id;
    }

    public Drink() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getThumb() {
        return thumb;
    }

    public void setThumb(URL thumb) {
        this.thumb = thumb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int compareTo(Drink drink) {
        return getName().compareTo(drink.getName());
    }
}
