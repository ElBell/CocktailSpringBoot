package ElBell.CocktailSpringBoot.scripts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Id;
import java.net.URL;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DrinkReference {

    private Integer id;
    private URL thumb;
    private String name;

    public DrinkReference(@JsonProperty("strDrink") String name,
                          @JsonProperty("strDrinkThumb") URL thumb,
                          @JsonProperty("idDrink") Integer id) {
        this.name = name;
        this.thumb = thumb;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
