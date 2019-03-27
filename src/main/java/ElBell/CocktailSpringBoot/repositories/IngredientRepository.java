package ElBell.CocktailSpringBoot.repositories;


import ElBell.CocktailSpringBoot.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
