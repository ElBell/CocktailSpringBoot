package ElBell.CocktailSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(path="/cocktail")
public class MainController {
    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping("/drinks")
    public @ResponseBody
    Iterable<Drink> getAllDrinks() {
        // This returns a JSON with the drinks
        return drinkRepository.findAll();
    }

    @GetMapping("/anything")
    public @ResponseBody
    Drink getTrialDrink() {
        return Bar.getDrinks().get(0);
    }

    @GetMapping("/drinks/{id}")
    public @ResponseBody
    Drink getDrinksById(@PathVariable(value = "id") Long searchDrink) {
        return drinkRepository.findById(searchDrink)
                .orElseThrow(() -> new ResourceNotFoundException("Drink", "id", searchDrink));
    }

}
