package workademy.pages;

import org.openqa.selenium.By;
import workademy.utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WAUserAccountPage {

    /* Properties */
    private static String validUserName = PropertiesLoader.loadProperty("valid.username");

    /* Elements */
    private static By title = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[6]/button[2]/span[1]/span[1]");
    /* Methods */
    public void assertUserName(){
        $(title).shouldHave(text(validUserName));
    }
}
