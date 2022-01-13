package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.Objects.isNull;

public final class WebDriverHandler {

    private static WebDriver chromeDriver;

    public static WebDriver getChromeDriver() {
        if (isNull(chromeDriver)) {
            WebDriverManager.chromedriver().setup();
            chromeDriver = new ChromeDriver();
        }
        return chromeDriver;
    }

}
