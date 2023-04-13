
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;

public class WebAppTest {

    @Test
    public void checkLoginPasswordMethodOption() {

        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy=\"method-password\"]")).click();

    }

    @Test
    public void checkLoginSmardIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy=\"method-smart-id\"]")).click();

    }

    @Test
    public void checkLoginMobileIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy=\"method-mobile-id\"]")).click();

    }

    @Test
    public void incorrectSmartIdLogin() {
        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        SelenideElement idCodeInput = $(By.xpath("//*[@data-cy='smart-id-input']/div/input"));

        idCodeInput.setValue("123");

        $(By.xpath("//*[@data-cy=\"smart-id-login-button\"]")).click();

    }

    @Test

    public void incorrectLogin() {

        Configuration.holdBrowserOpen = true;


        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy=\"method-password\"]")).click();


        SelenideElement usernameInput = $(By.xpath("//*[@data-cy=\"username-input\"]/div/input"));

        SelenideElement passwordInput = $(By.xpath("//*[@data-cy=\"password-input\"]/div/input"));


        usernameInput.setValue("serafims");
        passwordInput.setValue("hellouser123");

        $(By.xpath("//*[@data-cy=\"password-login-button\"]")).click();

    }


}