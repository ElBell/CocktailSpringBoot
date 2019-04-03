package ElBell.CocktailSpringBoot.utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingFormatWidthException;

public class Parser {


    public static double parseMeasurement(String measurement, String name) throws NumberFormatException{
        return Parser.parseNumber(measurement) * getConversionRate(measurement, name);
    }

    private static double getConversionRate(String inputMeasurement, String name){
        String measurement = getUnits(inputMeasurement);
        // If there are no units of measurement, parse the ingredient
        // Otherwise, parse the units of measurement
        return measurement.length() == 0 ? getIngredientSize(name) :
                convertToOunces.containsKey(measurement) ? convertToOunces.get(measurement) : 0;
    }

    private static String getUnits(String inputMeasurement) {
        if (inputMeasurement.contains("oz")) return "oz";
        String units = inputMeasurement.toLowerCase()
                .replaceAll("add", "")
                .replaceAll("superfine", "")
                .replaceAll("crushed", "")
                .replaceAll("grated", "")
                .replaceAll("of", "").replaceAll("[-+.^:,/ 0-9]", "");
        units = removePlurality(units).replaceAll("bacardi", "").replaceAll("smirnf", "");
        return units;
    }

    private static String removePlurality(String units) {
        if (units.endsWith("es")) {
            units = units.equals("cubes") ? "cube" : units.substring(0,units.length()-2);
        } else if (units.endsWith("s")) {
            units = units.equals("glass") ? units : units.substring(0,units.length()-1);
        }
        return units;
    }

    private static double getIngredientSize(String name) {
        if(!ingredientOunces.containsKey(name)) {
            throw new NumberFormatException();
        }
        return ingredientOunces.containsKey(name) ? ingredientOunces.get(name) : 1;
    }

    private static double parseNumber(String measurement) {
        String number = measurement.replaceAll("([a-zA-Z])\\w+", "").trim();
        return number.contains("-") ? parseRange(number.split("-")) : parsePossibleFraction(number);
    }

    private static double parsePossibleFraction(String number) {
        return number.contains("/") ? parseFraction(number) : Double.parseDouble(number);
    }

    private static double parseRange(String[] numbers) {
        double firstNum = parsePossibleFraction(numbers[0]);
        double secondNum = parsePossibleFraction(numbers[1]);
        return (firstNum + secondNum) / 2;
    }

    private static double parseFraction(String num) {
        String fraction = num.contains(" ") ? num.split(" ")[1] : num;
        String[] fractionNumbers = fraction.split("/");
        Double fractionResult =  Double.parseDouble(fractionNumbers[0]) / Double.parseDouble(fractionNumbers[1]);
        return fractionResult + (num.contains(" ") ? Double.parseDouble(num.split(" ")[0]) : 0);
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
