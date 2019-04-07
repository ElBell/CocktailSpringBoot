package ElBell.CocktailSpringBoot.entities;

import ElBell.CocktailSpringBoot.utilities.Parser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class Ingredient implements Comparable<Ingredient>{
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String name;
    private String amount;
    private double ounces;
    @ManyToOne
    @JoinColumn
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Drink contain_drink;

    public Ingredient(String name, String amount) {
        if(name.replaceAll(" ", "").length() < 1 ||
                amount.replaceAll(" ", "").length() < 1) {
            throw new NullPointerException();
        }
        this.name = name;
        this.amount = amount;
        this.ounces = Parser.parseMeasurement(amount, name);
    }

    public Ingredient() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public double getOunces() {
        return ounces;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setOunces(double ounces) {
        this.ounces = ounces;
    }

    @JsonIgnore
    public Drink getContain_drink() {
        return contain_drink;
    }

    public void setContain_drink(Drink drinkId) {
        this.contain_drink = drinkId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", ounces=" + ounces +
                '}';
    }

    @Override
    public int compareTo(Ingredient o) {
        int ouncesCompared = (int) ((o.ounces - ounces) * 100);
        if (ouncesCompared == 0 && name != null) {
            return name.compareTo(o.getName());
        }
        return ouncesCompared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
