package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class WebAppTest {

    @BeforeEach
    public void setUp(){

        open ( "https://profile.esto.ee/login");

    }

    @AfterEach
    public void tearDown(){

        closeWebDriver();

    }

    @Test
    public void checkLoginPasswordMethodOption() {

        Configuration.holdBrowserOpen = true;

        $(By.xpath("//*[@data-cy='method-password']")).click();

        $(By.xpath("//*[@id='login-field']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@id='password-field']/div/input")).shouldBe(Condition.editable);


    }

    @Test
    public void checkLoginSmardIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        $(By.xpath("//*[@data-cy='method-smart-id']")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='smart-id-login-button']")).shouldBe(Condition.visible);

    }

    @Test
    public void checkLoginMobileIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        $(By.xpath("//*[@data-cy='method-mobile-id']")).click();

        $(By.xpath("//*[@data-cy='mobile-id-phone-input']")).shouldBe(Condition.editable);

        $(By.xpath("//*[@id='pin-field']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='mobile-id-login-button']")).shouldBe(Condition.visible);



    }

    @Test
    public void incorrectSmartIdLogin() {
        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();


        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        loginPage.insertIdCode("123");

        $(By.xpath("//*[@data-cy='smart-id-login-button']")).click();

        $(By.xpath("//*[@data-cy='smart-id-input']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='smart-id-login-button']")).shouldBe(Condition.visible);



    }

    @Test

    public void incorrectLogin() {

        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();


        $(By.xpath("//*[@data-cy='method-password']")).click();

        $(By.xpath("//*[@data-cy='password-login-button']")).click();

        loginPage.insertUsername("serafims");
        loginPage.insertPassword("hellouser123");

        $(By.xpath("//*[@data-cy='username-input']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='password-input']/div/input")).shouldBe(Condition.editable);

        $(By.xpath("//*[@data-cy='password-login-button']")).shouldBe(Condition.visible);

        $(By.xpath("//*[@data-cy='password-login-error']")).shouldBe(Condition.visible);



    }

    @Test
    public void emptyLoginPassword() {


        $(By.xpath("//*[@data-cy='method-password']")).click();

        $(By.xpath("//*[@id='login-field']/div/input")).click();

        $(By.xpath("//*[@data-cy='password-input']/div/input")).click();

        $(By.xpath("//*[@data-cy='password-login-button']")).shouldBe(Condition.disabled);

    }


}