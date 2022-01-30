import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
    public static void main(String[] args){

//        System.setProperty("webdriver.gecko.driver","/Users/sriregula/Desktop/demoTest/drivers/geckodriver");
//        System.setProperty(" webdriver.chrome.driver","/Users/sriregula/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.demo.bnz.co.nz/client/");
    }
}
