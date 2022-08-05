import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    //static WebDriver driver;
    //AndroidDriver driver;
    AppiumDriver<MobileElement> driver;


    @BeforeMethod
    public void setCondition() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities(); //JSON-объект (набор пар ключ-значение), отправленный клиентом серверу
        capabilities.setCapability("deviceName", "sdk_gphone_x86"); // имя устройства
        capabilities.setCapability("udid", "emulator-5554"); // уникальный идентификатор подключенного устройства
        capabilities.setCapability("platformName", "Android"); // ОС
        capabilities.setCapability("platformVersion", "11"); // версия ОС
        capabilities.setCapability("appPackage", "com.google.android.calculator"); // java-пакет Android приложения, которое мы хотим запустить
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // имя activity, которое мы хотим запустить

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void additionTest() {

        MobileElement nine = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        nine.click();
        MobileElement plus= driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        plus.click();
        MobileElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        three.click();
        MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equals.click();
        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        Assert.assertEquals("12", result.getText(), "Result should be equals 12");

    }

    @Test
    public void subtractionTest() {

        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        Assert.assertEquals("6", result.getText(), "Result should be equals 6");

    }

    @Test
    public void multiplicationTest() {

        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        Assert.assertEquals("27", result.getText(), "Result should be equals 27");

    }

    @Test
    public void divisionTest() {

        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        Assert.assertEquals("3", result.getText(), "Result should be equals 3");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
