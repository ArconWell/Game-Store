package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import utils.WebDriverHandler;

public class BrowseDirectorySteps {

    WebDriver driver = WebDriverHandler.getChromeDriver(); //данные состояния driver'а будут сохраняться между
    // разными классами в steps, т.к. мы WebDriver является классом - ссылочным типом данных. А также перед вызовом каждой
    // функции будет вызываться это присваивание

    public static final String SITE = "http://localhost:8080";

    @Дано("пользователь открывает сайт")
    public void пользовательОткрываетСайт() {
        driver.navigate().to(SITE);
    }

    @Когда("в базе есть игры")
    public void вБазеЕстьИгры() {
        String elementValue = driver.findElement(By.id("games_list")).getAttribute("innerText");
        Assert.assertTrue(elementValue != "");
    }

}
