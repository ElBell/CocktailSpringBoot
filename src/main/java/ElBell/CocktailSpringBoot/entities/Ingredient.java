package ElBell.CocktailSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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
        //try {
            return parseNumber(measurement) * getConversionRate(measurement);
//        } catch (NumberFormatException e) {
//            System.out.println(measurement);
//        }
//        return 0;
    }

    private double getConversionRate(String inputMeasurement) throws NumberFormatException{
        String measurement = inputMeasurement.toLowerCase();
        if (measurement.contains("oz") || measurement.contains("part") || measurement.contains("measure")) {
            return 1;
        } if(measurement.contains("tblsp") || measurement.contains("chunk") || measurement.contains("tbsp")) {
            return 0.5;
        } if(measurement.contains("can")) {
            return 12;
        } if(measurement.contains("tsp") || measurement.contains("cube")) {
            return 0.166667;
        } if(measurement.contains("dash")) {
            return 0.03125;
        } if(measurement.contains("splash") || measurement.contains("fresh")) {
            return 0.2;
        } if(measurement.contains("juice") || measurement.contains("whole")) {
            return 2;
        } if(measurement.contains("cl")) {
            return 0.33814;
        } if(measurement.contains("shot") || measurement.contains("jigger")) {
            return 1.5;
        } if(measurement.contains("scoop")) {
            return 4;
        } if(measurement.contains("twist") || measurement.contains("slice")) {
            return 0.00000001;
        } if(measurement.contains("ml")) {
            return 0.033814;
        } if(measurement.contains("dl")) {
            return 3.3814;
        } if (measurement.contains("cup")) {
            return 8;
        } if (measurement.contains("glass")) {
            return 16;
        }
        if (isNumeric(measurement.replaceAll("[-+.^:,/ ]", ""))) {
            return getIngredientSize();
        }
        else {
//            System.out.println("---------------------------------------");
//            System.out.println(measurement);
//            throw new OptimisticLockException();
            return 0;
            //throw new NumberFormatException();
        }
    }

    private double getIngredientSize() {
        String lowerName = name.toLowerCase();
        if(lowerName.contains("strawberries")) {
            return 0.4F;
        } if(lowerName.contains("cherry") || lowerName.contains("olive")) {
            return 0.2F;
        } if(lowerName.contains("blackberries")) {
            return 0.1;
        } if(lowerName.contains("egg") || lowerName.contains("vodka")) {
            return 1F;
        } if(lowerName.contains("lime") || lowerName.contains("orange") || lowerName.contains("lemon")) {
            return 0.75;
        } if(lowerName.contains("banana")) {
            return 4;
        } if(lowerName.contains("mint")) {
            return 0.00000001;
        } if(lowerName.contains("pineapple")) {
            return 2;
        } if(lowerName.contains("cube") || lowerName.contains("sugar")) {
            return 0.166667;
        } if(lowerName.contains("oreo")) {
            return 0.3985958;
        } else {
//            System.out.println("///////////////////////////////////////");
//            System.out.println(name);
            return 1;
        }
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
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
        return (int) ((ounces - o.ounces) * 100);
    }
}
