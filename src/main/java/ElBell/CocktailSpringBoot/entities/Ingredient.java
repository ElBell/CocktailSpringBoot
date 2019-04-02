package ElBell.CocktailSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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
    @JsonIgnore
    private Drink contain_drink;

    public Ingredient(String name, String amount) {
        if(name.replaceAll(" ", "").length() < 1 ||
                amount.replaceAll(" ", "").length() < 1) {
            throw new NullPointerException();
        }
        this.name = name;
        this.amount = amount;
        this.ounces = parseMeasurement(amount);
    }

    public Ingredient() {

    }
    private double parseMeasurement(String measurement) throws NumberFormatException{
            return parseNumber(measurement) * getConversionRate(measurement);
    }

    private double getIngredientSize() {
        return ingredientOunces.containsKey(name) ? ingredientOunces.get(name) : 1;
    }

    private double getConversionRate(String inputMeasurement) throws NumberFormatException{
        String measurement = getUnits(inputMeasurement);
        System.out.println(measurement);
        if (measurement.length() == 0) {
            return getIngredientSize();
        }
        if (convertToOunces.containsKey(measurement)) {
            return convertToOunces.get(measurement);
        }
        return 0;
    }

    private String getUnits(String inputMeasurement) {
        String units = inputMeasurement.toLowerCase().replaceAll("[-+.^:,/ 0-9]", "");
        if (units.endsWith("s")) {
            units = units.equals("glass") ? units : units.substring(0,units.length()-1);
        }
        return units;
    }

    private double parseNumber(String measurement) {
        String number = measurement.replaceAll("([a-zA-Z])\\w+", "").trim();
        if(number.contains("-")) {
            number = number.split("-")[1];
        }
        if(number.contains("/")) {
            return parseFraction(number);
        } else {
            return Double.parseDouble(number);
        }
    }

    private double parseFraction(String num) {
        String fraction = num.contains(" ") ? num.split(" ")[1] : num;
        String[] fractionNumbers = fraction.split("/");
        Double fractionResult =  Double.parseDouble(fractionNumbers[0]) / Double.parseDouble(fractionNumbers[1]);
        return fractionResult + (num.contains(" ") ? Double.parseDouble(num.split(" ")[0]) : 0);
    }

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
        return (int) ((o.ounces - ounces) * 100);
    }


    private static Map<String, Double> convertToOunces = new HashMap<>();
    private static Map<String, Double> ingredientOunces = new HashMap<>();
    static {
        convertToOunces.put("oz", 1d); convertToOunces.put("part", 1d); convertToOunces.put("measure", 1d);
        convertToOunces.put("tblsp", 0.5); convertToOunces.put("chunk", 0.5); convertToOunces.put("tbsp", 0.5);
        convertToOunces.put("can", 12d);
        convertToOunces.put("tsp", 0.166667); convertToOunces.put("cube", 0.1666667);
        convertToOunces.put("dash", 0.03125);
        convertToOunces.put("splash", 0.2); convertToOunces.put("fresh", 0.2);
        convertToOunces.put("juice", 2d); convertToOunces.put("whole", 2d);
        convertToOunces.put("cl", 0.33814);
        convertToOunces.put("shot", 1.5); convertToOunces.put("jigger", 1.5);
        convertToOunces.put("scoop", 4d);
        convertToOunces.put("twist", 0.00000001); convertToOunces.put("slice", 0.00000001);
        convertToOunces.put("ml", 0.033814);
        convertToOunces.put("dl", 3.3814);
        convertToOunces.put("cup", 8d);
        convertToOunces.put("glass", 16d);

        ingredientOunces.put("strawberries", 0.4);
        ingredientOunces.put("cherry", 0.2); ingredientOunces.put("olive", 0.2);
        ingredientOunces.put("blackberries", 0.1);
        ingredientOunces.put("egg", 1d); ingredientOunces.put("vodka", 1d);
        ingredientOunces.put("lime", 0.75); ingredientOunces.put("orange", 0.75); ingredientOunces.put("lemon", 0.75);
        ingredientOunces.put("bananas", 4d);
        ingredientOunces.put("mint", 0.00000001);
        ingredientOunces.put("pineapple", 2d);
        ingredientOunces.put("cube", 0.166667); ingredientOunces.put("sugar", 0.166667);
        ingredientOunces.put("oreo", 0.3985958);
    }
}
