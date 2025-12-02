

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest {

    @Test
    public void openGoogleAndCheckTitle() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // headless for CI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle().toLowerCase();
            assertTrue(title.contains("google"));
        } finally {
            driver.quit();
        }
    }
}
