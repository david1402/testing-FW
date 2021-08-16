package workademy.pages;

import org.openqa.selenium.By;
import workademy.utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;

public class WASignInPage {

    /* Properties */
    public static String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static String validPwd = PropertiesLoader.loadProperty("valid.password");

    /* Elements */
    public static final By emailInput = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/main[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    public static final By pwdInput = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/main[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]");
    public static final By signInBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/main[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/button[1]");
    public static final By invalidSigningInMsg = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/main[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]");

    /* Methods */
    public void clickSignInBtn(){
        $(signInBtn).click();
    }

    public void displayValidationMsg () {
        $(invalidSigningInMsg).isDisplayed();
    }

    public void signInInput(String email, String pwd) {
        $(emailInput).setValue(email);
        $(pwdInput).setValue(pwd);
    }
}
