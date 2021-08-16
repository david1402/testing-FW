package workademy.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import workademy.pages.WASignInPage;
import workademy.pages.WAUserAccountPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static workademy.pages.WASignInPage.validEmail;
import static workademy.pages.WASignInPage.validPwd;
import static workademy.pages.WAStagingPage.basicURL;
import static workademy.utils.ExcelDataLoader.getExcelData;

public class WASignInTest {
    String signInUrl = basicURL + "/signin";
    WASignInPage waSignInPage = new WASignInPage();
    WAUserAccountPage waUserAccountPage = new WAUserAccountPage();

    @DataProvider(name="excel-data")
    public Object[][] loginData() throws IOException {
        return getExcelData("TestData/invalidSignInData.xlsx","Sheet1");
    }

    @BeforeMethod
    public void setUp() {
        open(signInUrl);
    }

    @Test
    public void positiveSignInTest() {
        waSignInPage.signInInput(validEmail, validPwd);
        waSignInPage.clickSignInBtn();
        waUserAccountPage.assertUserName();
    }

    @Test(dataProvider="excel-data")
    public void negativeSignInTest(String invalidEmail, String invalidPwd) {
        waSignInPage.signInInput(invalidEmail, invalidPwd);
        waSignInPage.clickSignInBtn();
        waSignInPage.displayValidationMsg();
    }
}
