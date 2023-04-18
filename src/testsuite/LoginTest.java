package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest  extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.id("login-button")).click();
        //verify the text products
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class = 'title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // enter password
        driver.findElement(By.id("password")).sendKeys("“secret_sauce”");
        // click on login button
        driver.findElement(By.id("login-button")).click();
        // verify the 6 products

        List<WebElement>totalProducts = driver.findElements(By.className("inventory_item"));
        System.out.println("Total Numbers of Products" + totalProducts.size());


    }
    @After
    public void tearDown(){
        // closeBrowser(); //from base test
    }


}