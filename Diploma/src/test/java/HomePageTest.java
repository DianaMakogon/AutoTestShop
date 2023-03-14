import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
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
    public void searchTest() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var searchLocator = By.cssSelector(".search-field");
        driver.findElement(searchLocator).sendKeys("телефон" + "\n");
        var searchElementLocator = By.cssSelector(".entry-title");
        Assert.assertEquals("Неверный результат поиска", "РЕЗУЛЬТАТЫ ПОИСКА: “ТЕЛЕФОН”",
                driver.findElement(searchElementLocator).getText());
    }

    @Test
    public void sectionTest() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var section1Locator = By.xpath("(//h4)[1]");
        driver.findElement(section1Locator).click();
        var section1ElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход по первому разделу",
                driver.findElement(section1ElementLocator).isDisplayed());
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var section2Locator = By.xpath("(//h4)[2]");
        driver.findElement(section2Locator).click();
        var section2ElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход по второму разделу",
                driver.findElement(section2ElementLocator).isDisplayed());
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var section3Locator = By.xpath("(//h4)[3]");
        driver.findElement(section3Locator).click();
        var section3ElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход по третьему разделу",
                driver.findElement(section3ElementLocator).isDisplayed());
    }

    @Test
    public void sectionTransitionsTest() {
        Actions builder = new Actions(driver);
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var homeLocator = By.cssSelector("li#menu-item-26>a");
        driver.findElement(homeLocator).click();
        Assert.assertTrue("Не работает переход Главная", driver.findElement(homeLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        var catalogLocator = By.cssSelector("li#menu-item-46>a");
        driver.findElement(catalogLocator).click();
        var catalogElementLocator = By.cssSelector("h1.entry-title");
        Assert.assertTrue("Не работает переход каталог", driver.findElement(catalogElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        var appliancesLocator = By.cssSelector("li#menu-item-119>a");
        driver.findElement(appliancesLocator).click();
        var appliancesElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел бытовая техника",
                driver.findElement(appliancesElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(appliancesLocator)).build().perform();
        var fridgeLocator = By.cssSelector("li#menu-item-120>a");
        driver.findElement(fridgeLocator).click();
        var fridgeElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел холодильники]",
                driver.findElement(fridgeElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(appliancesLocator)).build().perform();
        var washingMachineLocator = By.cssSelector("li#menu-item-121>a");
        driver.findElement(washingMachineLocator).click();
        var washingMachineElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел стиральные машины",
                driver.findElement(washingMachineElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        var electronicsLocator = By.cssSelector("li#menu-item-47>a");
        driver.findElement(electronicsLocator).click();
        var electronicsElementLocator = By.cssSelector("h1.entry-title");
        Assert.assertTrue("Не работает переход в раздел электроника",
                driver.findElement(electronicsElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(electronicsLocator)).build().perform();
        var phonesLocator = By.cssSelector("li#menu-item-114>a");
        driver.findElement(phonesLocator).click();
        var phonesElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел телефоны",
                driver.findElement(phonesElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(electronicsLocator)).build().perform();
        var tabletLocator = By.cssSelector("li#menu-item-116>a");
        driver.findElement(tabletLocator).click();
        var tabletElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел планшеты",
                driver.findElement(tabletElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(electronicsLocator)).build().perform();
        var tvLocator = By.cssSelector("li#menu-item-118>a");
        driver.findElement(tvLocator).click();
        var tvElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел телевизоры",
                driver.findElement(tvElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(electronicsLocator)).build().perform();
        var photoLocator = By.cssSelector("li#menu-item-117>a");
        driver.findElement(photoLocator).click();
        var photoElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел фото",
                driver.findElement(photoElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        builder.moveToElement(driver.findElement(electronicsLocator)).build().perform();
        var watchLocator = By.cssSelector("li#menu-item-115>a");
        driver.findElement(watchLocator).click();
        var watchElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход в раздел часы",
                driver.findElement(watchElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        var booksLocator = By.cssSelector("li#menu-item-180>a");
        driver.findElement(booksLocator).click();
        var booksElementLocator = By.cssSelector("h1.entry-title");
        Assert.assertTrue("Не работает переход в раздел книги",
                driver.findElement(booksElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        builder.moveToElement(driver.findElement(catalogLocator)).build().perform();
        var clothLocator = By.cssSelector("li#menu-item-48>a");
        driver.findElement(clothLocator).click();
        var clothElementLocator = By.cssSelector("h1.entry-title");
        Assert.assertTrue("Не работает переход в раздел одежда",
                driver.findElement(clothElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        var myAccountLocator = By.cssSelector("li#menu-item-30>a");
        driver.findElement(myAccountLocator).click();
        var myAccountElementLocator = By.cssSelector("h2.post-title");
        Assert.assertTrue("Не работает переход в раздел мой аккаунт",
                driver.findElement(myAccountElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        var basketLocator = By.cssSelector("li#menu-item-29>a");
        driver.findElement(basketLocator).click();
        var basketElementLocator = By.cssSelector("span");
        var basketElement = driver.findElement(basketElementLocator).getText();
        Assert.assertEquals("Не работает переход в козину", "Корзина", basketElement);

        driver.navigate().to("http://intershop5.skillbox.ru/");
        var orderingLocator = By.cssSelector("li#menu-item-31>a");
        driver.findElement(orderingLocator).click();
        Assert.assertTrue("Не работает переход к оформлению заказа",
                driver.findElement(homeLocator).isDisplayed());

        var orderingBasketElementLocator = By.cssSelector("span");
        var orderingBasketElement = driver.findElement(orderingBasketElementLocator).getText();
        Assert.assertEquals("Не работает переход", "Корзина", orderingBasketElement);
    }

    @Test
    public void promoBannerTest() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("(//img)[4]"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        var bannerLocator = By.xpath("(//span[@class='btn promo-link-btn'])[4]");
        driver.findElement(bannerLocator).click();
        var bannerElementLocator = By.cssSelector(".woocommerce-breadcrumb>span");
        Assert.assertTrue("Не работает переход через промо баннер",
                driver.findElement(bannerElementLocator).isDisplayed());
    }

    @Test
    public void footerTest() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        var allGoodsLocator = By.cssSelector(".page-item-33>a");
        driver.findElement(allGoodsLocator).click();
        var allGoodsElementLocator = By.cssSelector(".entry-title");
        Assert.assertTrue("Не работает переход все товары",
                driver.findElement(allGoodsElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        var homeLocator = By.cssSelector(".page-item-39>a");
        driver.findElement(homeLocator).click();
        var homeElementLocator = By.cssSelector(".site-text");
        Assert.assertTrue("Не работает переход главная траница",
                driver.findElement(homeElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        var basketLocator = By.cssSelector(".page-item-20>a");
        driver.findElement(basketLocator).click();
        var basketElementLocator = By.cssSelector("span");
        var basketElement = driver.findElement(basketElementLocator).getText();
        Assert.assertEquals("Не работает переход", "Корзина", basketElement);

        driver.navigate().to("http://intershop5.skillbox.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        var myAccountLocator = By.cssSelector(".page-item-22>a");
        driver.findElement(myAccountLocator).click();
        var myAccountElementLocator = By.cssSelector(".post-title");
        Assert.assertTrue("Не работает переход в мой аккаунт",
                driver.findElement(myAccountElementLocator).isDisplayed());

        driver.navigate().to("http://intershop5.skillbox.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        var orderingLocator = By.cssSelector(".page-item-24>a");
        driver.findElement(orderingLocator).click();
        var basketОrderElementLocator = By.cssSelector("span");
        var basketOrderElement = driver.findElement(basketОrderElementLocator).getText();
        Assert.assertEquals("Не работает переход", "Корзина", basketOrderElement);

        driver.navigate().to("http://intershop5.skillbox.ru/");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        var registrationLocator = By.cssSelector(".page-item-141>a");
        driver.findElement(registrationLocator).click();
        var registrationElementLocator = By.cssSelector(".post-title");
        Assert.assertTrue("Не работает переход к регистрации",
                driver.findElement(registrationElementLocator).isDisplayed());
    }

    @Test
    public void viewedProductsTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var catalogLocator = By.cssSelector("li#menu-item-46>a");
        driver.findElement(catalogLocator).click();
        driver.findElement(By.xpath("(//div[@class='inner-img'])[1]")).click();
        driver.findElement(catalogLocator).click();
        driver.findElement(By.xpath("(//div[@class='inner-img'])[2]")).click();
        driver.findElement(catalogLocator).click();
        driver.findElement(By.xpath("(//div[@class='inner-img'])[3]")).click();
        driver.findElement(catalogLocator).click();
        driver.findElement(By.xpath("(//div[@class='inner-img'])[4]")).click();
        driver.findElement(catalogLocator).click();
        WebElement ElementFirst = driver.findElement(By.xpath("(//div[@class='inner-img'])[5]"));
        js.executeScript("arguments[0].scrollIntoView();", ElementFirst);
        driver.findElement(By.xpath("(//div[@class='inner-img'])[5]")).click();
        driver.findElement(catalogLocator).click();
        var homeLocator = By.cssSelector("li#menu-item-26>a");
        driver.findElement(homeLocator).click();
        WebElement Element = driver.findElement(By.cssSelector(".cat-list-wrap"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        var viewedProductsElements = driver.findElements(By.cssSelector(".product_list_widget>li")).size();
        Assert.assertEquals("Неверное количество элементов", 5, viewedProductsElements);
    }
}
