package ElBell.CocktailSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.net.URL;
import java.util.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink implements Comparable<Drink> {

    @Id
    private Long id;
    private String name;
    private URL image;
    private boolean alcoholic;
    @Column(name = "instructions", columnDefinition="BLOB")
    private String instructions;
    @OneToMany(mappedBy = "contain_drink", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    @ManyToOne(cascade=CascadeType.ALL)
    private Glass glass;

    public Drink() { }

    public Drink(@JsonProperty("strDrink") String name,
                 @JsonProperty("strDrinkThumb") URL image,
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
        System.out.println(new Ingredient(strIngredient2, strMeasure2));
        this.name = name;
        this.image = image;
        this.id = id;
        this.alcoholic = alcoholic == null || alcoholic.equals("Alcoholic");
        this.glass = Glass.getGlass(glass);
        this.instructions = instructions;
        ingredients = new ArrayList<>();
        try {
            ingredients.add(new Ingredient(strIngredient1, strMeasure1));
            ingredients.add(new Ingredient(strIngredient2, strMeasure2));
            ingredients.add(new Ingredient(strIngredient3, strMeasure3));
            ingredients.add(new Ingredient(strIngredient4, strMeasure4));
            ingredients.add(new Ingredient(strIngredient5, strMeasure5));
            ingredients.add(new Ingredient(strIngredient6, strMeasure6));
            ingredients.add(new Ingredient(strIngredient7, strMeasure7));
            ingredients.add(new Ingredient(strIngredient8, strMeasure8));
            ingredients.add(new Ingredient(strIngredient9, strMeasure9));
            ingredients.add(new Ingredient(strIngredient10, strMeasure10));
            ingredients.add(new Ingredient(strIngredient11, strMeasure11));
            ingredients.add(new Ingredient(strIngredient12, strMeasure12));
            ingredients.add(new Ingredient(strIngredient13, strMeasure13));
            ingredients.add(new Ingredient(strIngredient14, strMeasure14));
            ingredients.add(new Ingredient(strIngredient15, strMeasure15));
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(this);
            //e.printStackTrace();
            //This NullPointerException is purposefully suppressed because some of the ingredients
            //in the API are serialized to null. We just want to ignore those nulls.
            //Drink that's affected is printed to visually ensure it entered correctly.
        } catch (OptimisticLockException e) {
            System.out.println(this);
        } catch (Exception e) {
            System.out.println(this);
        }
        this.ingredients.forEach(x -> x.setContain_drink(this));
        Collections.sort(ingredients);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public URL getImage() {
        return image;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }


    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int compareTo(Drink drink) {
        return getName().compareTo(drink.getName());
    }

    @Override
    public String toString() {
        return "FullDrink{" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' +"\n" +
                ", image=" + image +"\n" +
                ", alcoholic=" + alcoholic +"\n" +
                //", ingredients=" + ingredients +"\n" +
                ", glass='" + glass + '\'' +"\n" +
                ", instructions='" + instructions + '\'' +"\n" +
                ", ingredients" + ingredients + '\'' +"\n" +
                '}';
    }

}
