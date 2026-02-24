package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createPage_loadsCorrectly(ChromeDriver driver) {

        driver.get(baseUrl + "/product/create");

        assertEquals("Create New Product", driver.getTitle());

        String heading = driver.findElement(By.tagName("h3")).getText();
        assertEquals("Create New Product", heading);

        assertTrue(driver.findElements(By.id("nameInput")).size() > 0);
        assertTrue(driver.findElements(By.id("quantityInput")).size() > 0);
    }

    @Test
    void createProduct_isSuccessful(ChromeDriver driver) {

        driver.get(baseUrl + "/product/create");

        driver.findElement(By.id("nameInput")).sendKeys("Laptop Gaming");
        driver.findElement(By.id("quantityInput")).sendKeys("5");

        driver.findElement(By.tagName("button")).click();

        assertTrue(driver.getCurrentUrl().contains("/product/list"));

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Laptop Gaming"));
        assertTrue(pageSource.contains("5"));
    }
}