package by.academy.melnichenko.leonid.ui.baskettest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends BaseBasketTest {

    @Test
    public void testBasket() {
        step.fillBasket();
        Assert.assertEquals("Холодильник с морозильником Beko CNMV5335E20VS",
                page.getFoundRefrigeInBasket());
    }
}
