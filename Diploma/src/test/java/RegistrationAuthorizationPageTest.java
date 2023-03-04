import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationAuthorizationPageTest {
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
    public void negativeRegistrationTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        driver.findElement(By.cssSelector(".custom-register-button")).click();
        var buttonLocator = By.cssSelector(".woocommerce-Button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Ошибка не появилась",
                "Error: Пожалуйста, введите корректный email.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
        var usernameLocator = By.cssSelector("#reg_username");
        var emailLocator = By.cssSelector("#reg_email");
        var passwordLocator = By.cssSelector("#reg_password");
        driver.findElement(usernameLocator).sendKeys("kjb;kjg;ggiuik");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Ошибка не появилась",
                "Error: Пожалуйста, введите корректный email.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());

        driver.findElement(passwordLocator).sendKeys("f");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Ошибка не появилась",
                "Error: Пожалуйста, введите корректный email.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());

        driver.findElement(emailLocator).sendKeys("f@m.ru");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Ошибка не появилась",
                "Error: Пожалуйста введите корректное имя пользователя.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
    }

    @Test
    public void positiveRegistrationTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        driver.findElement(By.cssSelector(".custom-register-button")).click();
        var usernameLocator = By.cssSelector("#reg_username");
        var emailLocator = By.cssSelector("#reg_email");
        var passwordLocator = By.cssSelector("#reg_password");
        driver.findElement(usernameLocator).sendKeys("k444jbfgnggiuik");
        driver.findElement(emailLocator).sendKeys("f4@ma.ru");
        driver.findElement(passwordLocator).sendKeys("fa4");
        var buttonLocator = By.cssSelector(".woocommerce-Button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Регистрация не произошла", "Регистрация завершена",
                driver.findElement(By.cssSelector(".content-page")).getText());
        driver.findElement(By.cssSelector(".menu-item-30>a")).click();
        driver.findElement(By.cssSelector("p>a")).click();
        Assert.assertEquals("Не выполнен выход с аккаунта", "Мой аккаунт",
                driver.findElement(By.cssSelector(".post-title")).getText());
    }

    @Test
    public void positiveAuthorizationTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        var usernameEmailLocator = By.cssSelector("#username");
        var passwordLocator = By.cssSelector("#password");
        driver.findElement(usernameEmailLocator).sendKeys("k2jbfgnggiuik");
        driver.findElement(passwordLocator).sendKeys("fa");
        var buttonLocator = By.cssSelector(".woocommerce-button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Регистрация не произошла", "Мой аккаунт",
                driver.findElement(By.cssSelector(".post-title")).getText());

        driver.findElement(By.xpath("(//li[contains(@class, 'woocommerce-MyAccount-navigation-link')])[4]//a")).click();
        driver.findElement(usernameEmailLocator).sendKeys("f2@ma.ru");
        driver.findElement(passwordLocator).sendKeys("fa");
        driver.findElement(By.cssSelector(".woocommerce-form__input")).click();
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Регистрация не произошла", "Мой аккаунт",
                driver.findElement(By.cssSelector(".post-title")).getText());
    }

    @Test
    public void negativeAuthorizationTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        var usernameEmailLocator = By.cssSelector("#username");
        var passwordLocator = By.cssSelector("#password");
        var buttonLocator = By.cssSelector(".woocommerce-button");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Нет ошибки о заполнении строк", "Error: Имя пользователя обязательно.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());

        driver.findElement(passwordLocator).sendKeys("fa");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Нет ошибки о заполнении строк", "Error: Имя пользователя обязательно.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());

        driver.findElement(usernameEmailLocator).sendKeys("k2jbfgnggiuik");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Нет ошибки о заполнении строк", "Пароль обязателен.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
    }

    @Test
    public void negativeAuthorizationUsernameTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        var usernameEmailLocator = By.cssSelector("#username");
        var passwordLocator = By.cssSelector("#password");
        var buttonLocator = By.cssSelector(".woocommerce-button");
        driver.findElement(usernameEmailLocator).sendKeys("k2jbfgnggiuik");
        driver.findElement(passwordLocator).sendKeys("fadvdv");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Нет ошибки о неверном пароле",
                "Веденный пароль для пользователя k2jbfgnggiuik неверный. Забыли пароль?",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
    }

    @Test
    public void negativeAuthorizationEmailTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        var usernameEmailLocator = By.cssSelector("#username");
        var passwordLocator = By.cssSelector("#password");
        var buttonLocator = By.cssSelector(".woocommerce-button");
        driver.findElement(usernameEmailLocator).sendKeys("f2@ma.ru");
        driver.findElement(passwordLocator).sendKeys("fadvdv");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Нет ошибки о неверном пароле",
                "Введенный пароль для почты f2@ma.ru неверный. Забыли пароль?",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
    }

    @Test
    public void forgotPasswordTest(){
        driver.navigate().to("http://intershop5.skillbox.ru/my-account/");
        driver.findElement(By.cssSelector(".woocommerce-LostPassword>a")).click();
        var passwordLocator = By.cssSelector(".woocommerce-Input");
        var button = By.cssSelector(".woocommerce-Button");
        driver.findElement(button).click();
        Assert.assertEquals("Нет ошибки о неверном пароле", "Введите имя пользователя или почту.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
        driver.findElement(passwordLocator).sendKeys("fsnblkgnblkf2@ma.ru");
        driver.findElement(button).click();
        Assert.assertEquals("Нет ошибки о неверном пароле", "Неверное имя пользователя или почта.",
                driver.findElement(By.cssSelector(".woocommerce-error>li")).getText());
        driver.findElement(passwordLocator).sendKeys("f2@ma.ru");
        driver.findElement(button).click();
        Assert.assertEquals("Нет ошибки о неверном пароле", "Password reset email has been sent.",
                driver.findElement(By.cssSelector(".woocommerce-message")).getText());
    }
}
