package ElBell.CocktailSpringBoot.repositories;
import ElBell.CocktailSpringBoot.entities.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Integer> {

}
