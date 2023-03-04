import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasketPageTest {
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void discountItemTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var buttonAddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[1]");
        driver.findElement(buttonAddingToCartLocator).click();
        var buttonAddedLocator = By.cssSelector(".added_to_cart");
        Assert.assertEquals("Добавление в корзину не произошло", "ПОДРОБНЕЕ", driver.findElement(buttonAddedLocator).getText());
        var button2AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[2]");
        driver.findElement(button2AddingToCartLocator).click();
        var basketLocator = By.cssSelector("li#menu-item-29>a");
        driver.findElement(basketLocator).click();
        var catalogLocator = By.cssSelector("li#menu-item-46>a");
        driver.findElement(catalogLocator).click();
        var button3AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[3]");
        driver.findElement(button3AddingToCartLocator).click();
        driver.findElement(basketLocator).click();
        var quantityInCartLocator = By.xpath("//a[@class='remove']");
        Assert.assertEquals("Неверное количество товара в корзине", 3, driver.findElements(quantityInCartLocator).size());
        var checkoutLocator = By.cssSelector(".checkout-button");
        driver.findElement(checkoutLocator).click();
        Assert.assertEquals("Нет просьбы авторизоваться", "Авторизуйтесь", driver.findElement(By.cssSelector(".showlogin")).getText());
    }

    @Test
    public void removalFromCartTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var buttonAddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[1]");
        driver.findElement(buttonAddingToCartLocator).click();
        var button2AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[2]");
        driver.findElement(button2AddingToCartLocator).click();
        var button3AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[3]");
        driver.findElement(button3AddingToCartLocator).click();
        var buttonAddedLocator = By.cssSelector(".added_to_cart");
        Assert.assertEquals("Добавление в корзину не произошло", "ПОДРОБНЕЕ", driver.findElement(buttonAddedLocator).getText());
        var basketLocator = By.cssSelector("li#menu-item-29>a");
        driver.findElement(basketLocator).click();
        var quantityInCartLocator = By.xpath("//a[@class='remove']");
        driver.findElement(quantityInCartLocator).click();
        Assert.assertEquals("Неверное количество товара после удаления из корзины", 2, driver.findElements(quantityInCartLocator).size());
    }

    @Test
    public void couponAddTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var buttonAddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[1]");
        driver.findElement(buttonAddingToCartLocator).click();
        var buttonAddedLocator = By.cssSelector(".added_to_cart");
        Assert.assertEquals("Добавление в корзину не произошло", "ПОДРОБНЕЕ", driver.findElement(buttonAddedLocator).getText());
        var button2AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[2]");
        driver.findElement(button2AddingToCartLocator).click();
        var basketLocator = By.cssSelector("li#menu-item-29>a");
        driver.findElement(basketLocator).click();
        var couponLocator = By.cssSelector("#coupon_code");
        driver.findElement(couponLocator).sendKeys("sert500");
        var buttonLocator = By.cssSelector(".button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Купон не применился", "Купон успешно добавлен.", driver.findElement(By.cssSelector(".woocommerce-message")).getText());
    }

    @Test
    public void couponNegativeTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var buttonAddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[1]");
        driver.findElement(buttonAddingToCartLocator).click();
        var buttonAddedLocator = By.cssSelector(".added_to_cart");
        Assert.assertEquals("Добавление в корзину не произошло", "ПОДРОБНЕЕ", driver.findElement(buttonAddedLocator).getText());
        var button2AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[2]");
        driver.findElement(button2AddingToCartLocator).click();
        var basketLocator = By.cssSelector("li#menu-item-29>a");
        driver.findElement(basketLocator).click();
        var couponLocator = By.cssSelector("#coupon_code");
        driver.findElement(couponLocator).sendKeys("sert500");
        var buttonLocator = By.cssSelector(".button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Купон не применился", "Купон успешно добавлен.", driver.findElement(By.cssSelector(".woocommerce-message")).getText());
        driver.navigate().to("http://intershop5.skillbox.ru/cart/");
        driver.findElement(By.cssSelector(".woocommerce-remove-coupon")).click();
        Assert.assertEquals("Купон не удалился", "Купон удален.", driver.findElement(By.cssSelector(".woocommerce-message")).getText());
    }

    @Test
    public void couponErrorTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var buttonAddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[1]");
        driver.findElement(buttonAddingToCartLocator).click();
        var buttonAddedLocator = By.cssSelector(".added_to_cart");
        Assert.assertEquals("Добавление в корзину не произошло", "ПОДРОБНЕЕ", driver.findElement(buttonAddedLocator).getText());
        var button2AddingToCartLocator = By.xpath("(//a[contains(@class, 'add_to_cart_button')])[2]");
        driver.findElement(button2AddingToCartLocator).click();
        var basketLocator = By.cssSelector("li#menu-item-29>a");
        driver.findElement(basketLocator).click();
        var couponLocator = By.cssSelector("#coupon_code");
        driver.findElement(couponLocator).sendKeys("sert5000");
        var buttonLocator = By.cssSelector(".button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Купон не применился", "Неверный купон.", driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
    }
}
