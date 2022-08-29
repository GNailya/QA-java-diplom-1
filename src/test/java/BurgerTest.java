import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveBurgerIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Sausage", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Spicy", 50));
        burger.moveIngredient(0, 1);
        assertEquals("Sausage", burger.ingredients.get(1).name);
    }

    @Test
    public void getCorrectPrice() {

        Burger burger = new Burger();
        float price = 100;

        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = price * 2 + price;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("bunTest");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("sausage");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== bunTest ====)\r\n= filling sausage =\r\n(==== bunTest ====)\r\n\r\nPrice: 300,000000\r\n";
        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}
