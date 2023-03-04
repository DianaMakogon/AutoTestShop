import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class OrderingPageTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {driver.quit();}

    @Test
    public void nullOrderingTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        driver.findElement(By.cssSelector("#username")).sendKeys("k2jbfgnggiuik");
        driver.findElement(By.cssSelector("#password")).sendKeys("fa");
        driver.findElement(By.cssSelector(".woocommerce-button")).click();
        driver.findElement(By.cssSelector("li#menu-item-46>a")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'add_to_cart_button')]")).click();
        driver.findElement(By.cssSelector("li#menu-item-29>a")).click();
        driver.findElement(By.cssSelector(".wc-proceed-to-checkout>a")).click();
        var firstNameLocator = By.cssSelector("#billing_first_name");
        driver.findElement(firstNameLocator).clear();
        var lastNameLocator = By.cssSelector("#billing_last_name");
        driver.findElement(lastNameLocator).clear();
        var address1NameLocator = By.cssSelector("#billing_address_1");
        driver.findElement(address1NameLocator).clear();
        var cityLocator = By.cssSelector("#billing_city");
        driver.findElement(cityLocator).clear();
        var stateLocator = By.cssSelector("#billing_state");
        driver.findElement(stateLocator).clear();
        var postcodeLocator = By.cssSelector("#billing_postcode");
        driver.findElement(postcodeLocator).clear();
        var phoneLocator = By.cssSelector("#billing_phone");
        driver.findElement(phoneLocator).clear();
        var emailLocator = By.cssSelector("#billing_email");
        driver.findElement(emailLocator).clear();
        var buttonLocator = By.cssSelector("#place_order");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Оформление заказа не произошло",
                driver.findElement(By.cssSelector(".woocommerce-error")).isDisplayed());
        Assert.assertEquals("Неверное количество обязательных строк", 9,
                driver.findElements(By.cssSelector("ul.woocommerce-error>li")).size() );
    }

    @Test
    public void positiveOrderingTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        driver.findElement(By.cssSelector("#username")).sendKeys("k2jbfgnggiuik");
        driver.findElement(By.cssSelector("#password")).sendKeys("fa");
        driver.findElement(By.cssSelector(".woocommerce-button")).click();
        driver.findElement(By.cssSelector("li#menu-item-46>a")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'add_to_cart_button')]")).click();
        driver.findElement(By.cssSelector("li#menu-item-29>a")).click();
        driver.findElement(By.cssSelector(".wc-proceed-to-checkout>a")).click();
        var firstNameLocator = By.cssSelector("#billing_first_name");
        driver.findElement(firstNameLocator).sendKeys("Варя");
        var lastNameLocator = By.cssSelector("#billing_last_name");
        driver.findElement(lastNameLocator).sendKeys("Капустина");
        var address1NameLocator = By.cssSelector("#billing_address_1");
        driver.findElement(address1NameLocator).sendKeys("Ленина 11");
        var cityLocator = By.cssSelector("#billing_city");
        driver.findElement(cityLocator).sendKeys("Пермь");
        var stateLocator = By.cssSelector("#billing_state");
        driver.findElement(stateLocator).sendKeys("Пермская");
        var postcodeLocator = By.cssSelector("#billing_postcode");
        driver.findElement(postcodeLocator).sendKeys("614000");
        var phoneLocator = By.cssSelector("#billing_phone");
        driver.findElement(phoneLocator).sendKeys("89098889988");
        var radioLocator = By.cssSelector("#payment_method_cod");
        driver.findElement(radioLocator).click();
        var buttonLocator = By.cssSelector("#place_order");
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.woocommerce-notice")));
        var madeLocator = By.cssSelector("h2.post-title");
        Assert.assertEquals("Оформление заказа не произошло", "Заказ получен",
                driver.findElement(madeLocator).getText());
    }

    @Test
    public void negativeOrderingTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        driver.findElement(By.cssSelector("#username")).sendKeys("k2jbfgnggiuik");
        driver.findElement(By.cssSelector("#password")).sendKeys("fa");
        driver.findElement(By.cssSelector(".woocommerce-button")).click();
        driver.findElement(By.cssSelector("li#menu-item-46>a")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'add_to_cart_button')]")).click();
        driver.findElement(By.cssSelector("li#menu-item-29>a")).click();
        driver.findElement(By.cssSelector(".wc-proceed-to-checkout>a")).click();
        var firstNameLocator = By.cssSelector("#billing_first_name");
        driver.findElement(firstNameLocator).sendKeys("Варя");
        var lastNameLocator = By.cssSelector("#billing_last_name");
        driver.findElement(lastNameLocator).sendKeys("Капустина");
        var addressNameLocator = By.cssSelector("#billing_address_1");
        driver.findElement(addressNameLocator).sendKeys("Ленина 11");
        var cityLocator = By.cssSelector("#billing_city");
        driver.findElement(cityLocator).sendKeys("Пермь");
        var stateLocator = By.cssSelector("#billing_state");
        driver.findElement(stateLocator).sendKeys("Пермская");
        var postcodeLocator = By.cssSelector("#billing_postcode");
        driver.findElement(postcodeLocator).sendKeys("614000");
        var phoneLocator = By.cssSelector("#billing_phone");
        driver.findElement(phoneLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        var messageLocator1 = By.xpath("(//ul[@class='woocommerce-error']/li)[1]");
        var messageLocator2 = By.xpath("(//ul[@class='woocommerce-error']/li)[2]");
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "неверный номер телефона.",
                driver.findElement(messageLocator1).getText());
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Телефон для выставления счета обязательное поле.",
                driver.findElement(messageLocator2).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(phoneLocator).sendKeys("89898889988");
        var emailLocator = By.cssSelector("#billing_email");
        driver.findElement(emailLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Адрес почты для выставления счета обязательное поле.",
                driver.findElement(messageLocator1).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(emailLocator).sendKeys("fa@m.ru");
        driver.findElement(postcodeLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Invalid billing email address",
                driver.findElement(messageLocator1).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(postcodeLocator).sendKeys("614000");
        driver.findElement(stateLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Область для выставления счета обязательное поле.",
                driver.findElement(messageLocator1).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(stateLocator).sendKeys("Пермская");
        driver.findElement(cityLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Город / Населенный пункт для выставления счета обязательное поле.",
                driver.findElement(messageLocator1).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(cityLocator).sendKeys("Пермь");
        driver.findElement(addressNameLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Адрес для выставления счета обязательное поле.",
                driver.findElement(messageLocator1).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(addressNameLocator).sendKeys("Ленина 11");
        driver.findElement(lastNameLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Фамилия для выставления счета обязательное поле.",
                driver.findElement(messageLocator1).getText());

        driver.navigate().to("http://intershop5.skillbox.ru/checkout/");
        driver.findElement(lastNameLocator).sendKeys("Капустина");
        driver.findElement(firstNameLocator).clear();
        driver.findElement(By.cssSelector("#place_order")).click();
        Assert.assertEquals("Проблема с заполнением строки с телефоном",
                "Имя для выставления счета обязательное поле.",
                driver.findElement(messageLocator1).getText());
    }
}
