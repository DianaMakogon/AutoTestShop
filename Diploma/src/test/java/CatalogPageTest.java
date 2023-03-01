import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CatalogPageTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void goToProductPageText() {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var productLocator = By.xpath("(//li[contains(@class, 'type-product')])[1]//a");
        driver.findElement(productLocator).click();
        var descriptionLocator = driver.findElement(By.cssSelector("li.description_tab>a")).getText();
        Assert.assertEquals("Переход на страницу товара не произошел", "ОПИСАНИЕ", descriptionLocator);
    }

    @Test
    public void addToCartTest() {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var buttonLocator = By.cssSelector(".add_to_cart_button");
        driver.findElement(buttonLocator).click();
        var buttonAddedLocator = By.cssSelector(".added_to_cart");
        Assert.assertEquals("Добавление в корзину не произошло", "ПОДРОБНЕЕ", driver.findElement(buttonAddedLocator).getText());
        driver.findElement(buttonAddedLocator).click();
        var descriptionLocator = driver.findElement(By.cssSelector(".current")).getText();
        Assert.assertEquals("Переход в корзину не произошел", "Корзина", descriptionLocator);
    }

    @Test
    public void goByCategoryTest() {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section1Locator = By.cssSelector(".cat-item-15>a");
        driver.findElement(section1Locator).click();
        var section1Element = By.cssSelector(".entry-title");
        var section1TextElement = driver.findElement(section1Element).getText();
        Assert.assertEquals("Переход в раздел без категории не произошел", "БЕЗ КАТЕГОРИИ", section1TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section2Locator = By.cssSelector(".cat-item-20>a");
        driver.findElement(section2Locator).click();
        var section2Element = By.cssSelector(".entry-title");
        var section2TextElement = driver.findElement(section2Element).getText();
        Assert.assertEquals("Переход в раздел бытовая техника не произошел", "БЫТОВАЯ ТЕХНИКА", section2TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section3Locator = By.cssSelector(".cat-item-19>a");
        driver.findElement(section3Locator).click();
        var section3Element = By.cssSelector(".entry-title");
        var section3TextElement = driver.findElement(section3Element).getText();
        Assert.assertEquals("Переход в раздел каталог не произошел", "КАТАЛОГ", section3TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section4Locator = By.cssSelector(".cat-item-28>a");
        driver.findElement(section4Locator).click();
        var section4Element = By.cssSelector(".entry-title");
        var section4TextElement = driver.findElement(section4Element).getText();
        Assert.assertEquals("Переход в раздел книги не произошел", "КНИГИ", section4TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section5Locator = By.cssSelector(".cat-item-17>a");
        driver.findElement(section5Locator).click();
        var section5Element = By.cssSelector(".entry-title");
        var section5TextElement = driver.findElement(section5Element).getText();
        Assert.assertEquals("Переход в раздел одежда не произошел", "ОДЕЖДА", section5TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section6Locator = By.cssSelector(".cat-item-26>a");
        driver.findElement(section6Locator).click();
        var section6Element = By.cssSelector(".entry-title");
        var section6TextElement = driver.findElement(section6Element).getText();
        Assert.assertEquals("Переход в раздел планшеты не произошел", "ПЛАНШЕТЫ", section6TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section7Locator = By.cssSelector(".cat-item-22>a");
        driver.findElement(section7Locator).click();
        var section7Element = By.cssSelector(".entry-title");
        var section7TextElement = driver.findElement(section7Element).getText();
        Assert.assertEquals("Переход в раздел стиральные машины не произошел", "СТИРАЛЬНЫЕ МАШИНЫ", section7TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section8Locator = By.cssSelector(".cat-item-25>a");
        driver.findElement(section8Locator).click();
        var section8Element = By.cssSelector(".entry-title");
        var section8TextElement = driver.findElement(section8Element).getText();
        Assert.assertEquals("Переход в раздел телевизоры не произошел", "ТЕЛЕВИЗОРЫ", section8TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section9Locator = By.cssSelector(".cat-item-24>a");
        driver.findElement(section9Locator).click();
        var section9Element = By.cssSelector(".entry-title");
        var section9TextElement = driver.findElement(section9Element).getText();
        Assert.assertEquals("Переход в раздел телефоны не произошел", "ТЕЛЕФОНЫ", section9TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section10Locator = By.cssSelector(".cat-item-27>a");
        driver.findElement(section10Locator).click();
        var section10Element = By.cssSelector(".entry-title");
        var section10TextElement = driver.findElement(section10Element).getText();
        Assert.assertEquals("Переход в раздел фото не произошел", "ФОТО/ВИДЕО", section10TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section11Locator = By.cssSelector(".cat-item-21>a");
        driver.findElement(section11Locator).click();
        var section11Element = By.cssSelector(".entry-title");
        var section11TextElement = driver.findElement(section11Element).getText();
        Assert.assertEquals("Переход в раздел холодильники не произошел", "ХОЛОДИЛЬНИКИ", section11TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section12Locator = By.cssSelector(".cat-item-23>a");
        driver.findElement(section12Locator).click();
        var section12Element = By.cssSelector(".entry-title");
        var section12TextElement = driver.findElement(section12Element).getText();
        Assert.assertEquals("Переход в раздел часы не произошел", "ЧАСЫ", section12TextElement);

        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var section13Locator = By.cssSelector(".cat-item-16>a");
        driver.findElement(section13Locator).click();
        var section13Element = By.cssSelector(".entry-title");
        var section13TextElement = driver.findElement(section13Element).getText();
        Assert.assertEquals("Переход в раздел электроника не произошел", "ЭЛЕКТРОНИКА", section13TextElement);
    }

    @Test
    public void promotionalGoodsTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var goodsLocator = By.cssSelector("#woocommerce_products-2");
        WebElement Element = driver.findElement(goodsLocator);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        var goodsElements = driver.findElements(By.cssSelector("ul.product_list_widget>li")).size();
        Assert.assertEquals("Неверное количесвот промотоваров на странице", 5, goodsElements);
    }

    @Test
    public void pageNavigationTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var numbersLocator = By.cssSelector("ul.page-numbers");
        WebElement Element = driver.findElement(numbersLocator);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        var numberLocator = By.xpath("//a[@class='page-numbers']");
        driver.findElement(numberLocator).click();
        var amountOfElements = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertEquals("Переход на вторую страницу каталога не произошло", "Page 2", driver.findElement(amountOfElements).getText());
        var numbers3Locator = By.cssSelector("ul.page-numbers");
        WebElement Element3 = driver.findElement(numbers3Locator);
        js.executeScript("arguments[0].scrollIntoView();", Element3);
        var number3Locator = By.xpath("(//a[@class='page-numbers'])[2]");
        driver.findElement(number3Locator).click();
        var amountOfElements3 = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertEquals("Переход на вторую страницу каталога не произошло", "Page 3", driver.findElement(amountOfElements3).getText());
        var numbersLastLocator = By.cssSelector("ul.page-numbers");
        WebElement ElementLast = driver.findElement(numbersLastLocator);
        js.executeScript("arguments[0].scrollIntoView();", ElementLast);
        var numberLastLocator = By.xpath("(//a[@class='page-numbers'])[last()]");
        driver.findElement(numberLastLocator).click();
        var amountOfElementsLast = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertEquals("Переход на вторую страницу каталога не произошло", "Page 11", driver.findElement(amountOfElementsLast).getText());
    }
}
