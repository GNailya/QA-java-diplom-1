import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    String name = "Test bun";
    float price = 100;

    Bun bun = new Bun(name, price);

    @Test
    public void getBunNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
       assertEquals(price, bun.getPrice(), 0);
    }
}
