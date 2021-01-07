import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Driver_Capabilities {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        HashMap<String, Object> browserPrefs = new HashMap<>();
        browserPrefs.put("download.default_directory", "path of directory");
        browserPrefs.put("download.prompt_for_download", false);
        browserPrefs.put("profile.default_content_setting.popups", 0);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", browserPrefs);


        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new ChromeDriver(cap);


        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id(""));

        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
    }
}
