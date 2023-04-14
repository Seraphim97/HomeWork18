
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

        $(By.xpath("//*[@data-cy='method-password']")).click();

        $(By.xpath("//*[@id='login-field']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@id='password-field']/div/input")).shouldBe(Condition.editable);


    }

    @Test
    public void checkLoginSmardIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        $(By.xpath("//*[@data-cy='method-smart-id']")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='smart-id-login-button']")).shouldBe(Condition.visible);

    }

    @Test
    public void checkLoginMobileIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy='method-mobile-id']")).click();

        $(By.xpath("//*[@data-cy='mobile-id-phone-input']")).shouldBe(Condition.editable);

        $(By.xpath("//*[@id='pin-field']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='mobile-id-login-button']")).shouldBe(Condition.visible);



    }

    @Test
    public void incorrectSmartIdLogin() {
        Configuration.holdBrowserOpen = true;

        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        SelenideElement idCodeInput = $(By.xpath("//*[@data-cy='smart-id-input']/div/input"));

        idCodeInput.setValue("123");

        $(By.xpath("//*[@data-cy='smart-id-login-button']")).click();

        $(By.xpath("//*[@data-cy='smart-id-input']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='smart-id-login-button']")).shouldBe(Condition.visible);



    }

    @Test

    public void incorrectLogin() {

        Configuration.holdBrowserOpen = true;


        open("https://profile.esto.ee/login");

        $(By.xpath("//*[@data-cy='method-password']")).click();


        SelenideElement usernameInput = $(By.xpath("//*[@data-cy='username-input']/div/input"));

        SelenideElement passwordInput = $(By.xpath("//*[@data-cy='password-input']/div/input"));


        usernameInput.setValue("serafims");
        passwordInput.setValue("hellouser123");

        $(By.xpath("//*[@data-cy='password-login-button']")).click();

        $(By.xpath("//*[@data-cy='username-input']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='password-input']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='password-login-button']")).shouldBe(Condition.visible);

        $(By.xpath("//*[@data-cy='password-login-error']")).shouldBe(Condition.hidden);



    }

    @Test
    public void emptyLoginPassword() {

        open("https://profile.esto.ee/login/password");

        $(By.xpath("//*[@data-cy='method-password']")).click();

        $(By.xpath("//*[@id='login-field']/div/input")).click();

        $(By.xpath("//*[@data-cy='password-input']/div/input")).click();

        $(By.xpath("//*[@data-cy='password-login-button']")).shouldBe(Condition.disabled);

    }


}