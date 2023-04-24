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

        LoginPage loginPage = new LoginPage();

        loginPage.methodPassword();

        loginPage.editableLoginField();

        loginPage.editablePasswordField();


    }

    @Test
    public void checkLoginSmardIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();

        loginPage.smartIdMethod();

        loginPage.editableSmartIdMethod();

        loginPage.smartIdLoginButtonVisible();

    }

    @Test
    public void checkLoginMobileIdMethodOption() {
        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();

        loginPage.mobileIdMethod();

        loginPage.mobileIdPhoneInput();

        loginPage.mobileIdPinField();

        loginPage.mobileIdLoginButton();



    }

    @Test
    public void incorrectSmartIdLogin() {
        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();

        loginPage.smartIdMethod();

        loginPage.insertIdCode("123");

        loginPage.smartIdLoginButton();

        loginPage.smartIdInput();

        loginPage.smartIdLoginButtonVisible();



    }

    @Test

    public void incorrectLogin() {

        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();


        loginPage.methodPassword();

        loginPage.passwordLoginButton();

        loginPage.insertUsername("serafims");

        loginPage.insertPassword("hellouser123");

        loginPage.usernameInput();

        loginPage.passwordInput();

        loginPage.passLogInButton();

        loginPage.passwordLoginError();



    }

    @Test
    public void emptyLoginPassword() {

        LoginPage loginPage = new LoginPage();

        loginPage.methodPassword();

        loginPage.loginField();

        loginPage.clickPasswordInput();

        loginPage.passwordLoginButtonDisabled();

    }


}