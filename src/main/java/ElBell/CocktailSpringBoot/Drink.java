package ElBell.CocktailSpringBoot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.MappingException;
import org.hibernate.annotations.SortComparator;
import org.hibernate.validator.constraints.UniqueElements;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.*;

@Entity
@Table(name = "drinks")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink implements Comparable<Drink> {

    @Id
    private Long id;
    private String name;
    private URL thumb;
    private boolean alcoholic;
    //private Map<String, String> ingredients;
    private String glass;
    private URL glassImage;
    @Column(columnDefinition = "LONGBLOB")
    private String instructions;


    /*public Drink(CustomType custom) {
        //constructor Code
    }*/

    public Drink() {

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public URL getThumb() {
        return thumb;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public String getGlass() {
        return glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public int compareTo(Drink drink) {
        return getName().compareTo(drink.getName());
    }


//    private Long id;
//    private String name;
//    private URL thumb;
//    private boolean alcoholic;
//    private Map<String, Float> ingredients;
//    private String glass;
//    private String instructions;



    public Drink(@JsonProperty("strDrink") String name,
                     @JsonProperty("strDrinkThumb") URL thumb,
                     @JsonProperty("idDrink") Long id,
                     @JsonProperty("strAlcoholic") String alcoholic,
                     @JsonProperty("strGlass") String glass,
                     @JsonProperty("strInstructions") String instructions,
                     @JsonProperty("strIngredient1") String strIngredient1,
                     @JsonProperty("strIngredient2") String strIngredient2,
                     @JsonProperty("strIngredient3") String strIngredient3,
                     @JsonProperty("strIngredient4") String strIngredient4,
                     @JsonProperty("strIngredient5") String strIngredient5,
                     @JsonProperty("strIngredient6") String strIngredient6,
                     @JsonProperty("strIngredient7") String strIngredient7,
                     @JsonProperty("strIngredient8") String strIngredient8,
                     @JsonProperty("strIngredient9") String strIngredient9,
                     @JsonProperty("strIngredient10") String strIngredient10,
                     @JsonProperty("strIngredient11") String strIngredient11,
                     @JsonProperty("strIngredient12") String strIngredient12,
                     @JsonProperty("strIngredient13") String strIngredient13,
                     @JsonProperty("strIngredient14") String strIngredient14,
                     @JsonProperty("strIngredient15") String strIngredient15,
                     @JsonProperty("strMeasure1") String strMeasure1,
                     @JsonProperty("strMeasure2") String strMeasure2,
                     @JsonProperty("strMeasure3") String strMeasure3,
                     @JsonProperty("strMeasure4") String strMeasure4,
                     @JsonProperty("strMeasure5") String strMeasure5,
                     @JsonProperty("strMeasure6") String strMeasure6,
                     @JsonProperty("strMeasure7") String strMeasure7,
                     @JsonProperty("strMeasure8") String strMeasure8,
                     @JsonProperty("strMeasure9") String strMeasure9,
                     @JsonProperty("strMeasure10") String strMeasure10,
                     @JsonProperty("strMeasure11") String strMeasure11,
                     @JsonProperty("strMeasure12") String strMeasure12,
                     @JsonProperty("strMeasure13") String strMeasure13,
                     @JsonProperty("strMeasure14") String strMeasure14,
                     @JsonProperty("strMeasure15") String strMeasure15)
    {
        this.name = name;
        this.thumb = thumb;
        this.id = id;
        this.alcoholic = alcoholic.equals("Alcoholic");
        this.glass = glass;
//        if (instructions.length() < 65535) {
            this.instructions = instructions;
        //}
        Map<String, String> ingredients = new TreeMap<>();
        try {
            ingredients.put(strIngredient1, strMeasure1);
            ingredients.put(strIngredient2, strMeasure2);
            ingredients.put(strIngredient3, strMeasure3);
            ingredients.put(strIngredient4, strMeasure4);
            ingredients.put(strIngredient5, strMeasure5);
            ingredients.put(strIngredient6, strMeasure6);
            ingredients.put(strIngredient7, strMeasure7);
            ingredients.put(strIngredient8, strMeasure8);
            ingredients.put(strIngredient9, strMeasure9);
            ingredients.put(strIngredient10, strMeasure10);
            ingredients.put(strIngredient11, strMeasure11);
            ingredients.put(strIngredient12, strMeasure12);
            ingredients.put(strIngredient13, strMeasure13);
            ingredients.put(strIngredient14, strMeasure14);
            ingredients.put(strIngredient15, strMeasure15);
        } catch (NullPointerException e) {
            //System.out.println(this);
            //This NullPointerException is purposefully suppressed because some of the ingredients
            //in the API are serialized to null. We just want to ignore those nulls.
            //Drink that's affected is printed to visually ensure it entered correctly.
        }
    }
//
//    private Float String parseMeasurement(String measurement) throws Exception {
//        if (measurement.length() > 2)
//        switch (measurement) {
//            case "1/2 oz " :
//                return (float) 0.5;
//            case "1 oz " :
//                return (float)1.0;
//            case "1 1/2 oz " :
//                return (float)1.5;
//            case "2 oz " :
//                return (float)2;
//            default:
//                throw new Exception("New measurement:" + measurement);
//        }
//        return 0F;
//    }

    @Override
    public String toString() {
        return "FullDrink{" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' +"\n" +
                ", thumb=" + thumb +"\n" +
                ", alcoholic=" + alcoholic +"\n" +
                //", ingredients=" + ingredients +"\n" +
                ", glass='" + glass + '\'' +"\n" +
                ", instructions='" + instructions + '\'' +"\n" +
                '}';
    }

}
