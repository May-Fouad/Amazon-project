import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public static WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.eg/?language=en_AE");



    }

    @AfterClass
    public void close()
    {
        driver.quit();
    }
}
