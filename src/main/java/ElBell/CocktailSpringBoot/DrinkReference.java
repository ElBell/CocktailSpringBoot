package ElBell.CocktailSpringBoot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Id;
import java.net.URL;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DrinkReference {

    private Long id;
    private URL thumb;
    private String name;

    public DrinkReference(@JsonProperty("strDrink") String name,
                          @JsonProperty("strDrinkThumb") URL thumb,
                          @JsonProperty("idDrink") Long id) {
        this.name = name;
        this.thumb = thumb;
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
