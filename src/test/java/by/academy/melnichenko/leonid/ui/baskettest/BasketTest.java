package by.academy.melnichenko.leonid.ui.baskettest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends BaseBasketTest {

    @Test
    public void testBasket() {
        step.fillBasket();
        Assert.assertEquals("Холодильник с морозильником Renova RID-80W",
                page.getFoundRefrigeInBasket());
    }
}
