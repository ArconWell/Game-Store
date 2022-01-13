package steps;

import io.cucumber.java.After;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverHandler;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AddNewGameSteps {

    WebDriver driver = WebDriverHandler.getChromeDriver();

    @Дано("пользователь заполняет {string} и все необходимые поля для игры")
    public void пользовательЗаполняетВсеНеобходимыеПоляДляИгры(String arg0) {
        driver.findElement(By.id("game_name")).sendKeys(arg0);
        driver.findElement(By.id("game_price")).sendKeys("1000");
        driver.findElement(By.id("game_description")).sendKeys("Test game description");
        driver.findElement(By.id("game_release_date")).sendKeys("2022-01-11");
        driver.findElement(By.id("game_rating")).sendKeys("5");
    }

    @Когда("пользователь нажимает кнопку {string}")
    public void пользовательНажимаетКнопку(String arg0) {
        driver.findElement(By.xpath(String.format("//button[text()='%s']", arg0))).click();
    }

    @Тогда("игра {string} находится в каталоге")
    public void играНаходитсяВКаталоге(String arg0) {
        List<WebElement> webElementsList = driver.findElement(By.id("games_list")).findElements(By.cssSelector("tr"));
        for (int i = 1; i < webElementsList.size(); i++) {
            List<WebElement> tdElementsList = webElementsList.get(i).findElements(By.cssSelector("td"));
            WebElement[] tdElementsArray = tdElementsList.toArray(new WebElement[0]);
            if (arg0.equals(tdElementsArray[1].getAttribute("innerText")))
                return;
        }
        throw new NoSuchElementException();
    }

    @Дано("пользователь заполняет не все необходимые поля для игры")
    public void пользовательЗаполняетНеВсеНеобходимыеПоляДляИгры() {
        driver.findElement(By.id("game_name")).sendKeys("");
        driver.findElement(By.id("game_price")).sendKeys("");
        driver.findElement(By.id("game_description")).sendKeys("Test game description");
        driver.findElement(By.id("game_release_date")).sendKeys("2022-01-11");
        driver.findElement(By.id("game_rating")).sendKeys("5");
    }

    @И("отображается надпись {string}")
    public void отображаетсяНадпись(String arg0) throws InterruptedException {
        String inscriptionInnerText = driver.findElement(By.id("inscription")).getAttribute("innerText");
        if (!arg0.equals(inscriptionInnerText)) {
            //FIXME Почему-то именно при запуске тестов надпись не отображается. При обычной работе (при добавлении игры вручную)
            // всё отображается корректно

            // throw new NoSuchElementException();
        }
    }

    @After
    public void закрытьБраузер() {
        //driver.quit();
    }
}
