
import org.junit.Test;

import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    IngredientType type = IngredientType.FILLING;
    String name = "Sausage";
    float price = 100;
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }
}
