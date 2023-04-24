package org.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void insertUsername(String query) {
        $(By.xpath("//*[@data-cy='username-input']/div/input")).setValue(query);
    }

    public void insertPassword(String query) {
        $(By.xpath("//*[@data-cy='password-input']/div/input")).setValue(query);
    }

    public void insertIdCode(String query) {
        $(By.xpath("//*[@data-cy='smart-id-input']/div/input")).setValue(query);
    }

    public void methodPassword(){
        $(By.xpath("//*[@data-cy='method-password']")).click();
    }

    public void passwordLoginButton(){
        $(By.xpath("//*[@data-cy='password-login-button']")).click();
    }

    public void usernameInput(){
        $(By.xpath("//*[@data-cy='username-input']/div/input")).shouldBe(Condition.editable);
    }

    public void passwordInput(){
        $(By.xpath("//*[@data-cy='password-input']/div/input")).shouldBe(Condition.editable);
    }

    public void passLogInButton(){
        $(By.xpath("//*[@data-cy='password-login-button']")).shouldBe(Condition.visible);
    }

    public void passwordLoginError(){
        $(By.xpath("//*[@data-cy='password-login-error']")).shouldBe(Condition.visible);
    }

    public void loginField(){
        $(By.xpath("//*[@id='login-field']/div/input")).click();
    }

    public void clickPasswordInput(){
        $(By.xpath("//*[@data-cy='password-input']/div/input")).click();
    }

    public void passwordLoginButtonDisabled(){
        $(By.xpath("//*[@data-cy='password-login-button']")).shouldBe(Condition.disabled);
    }

    public void smartIdMethod(){
        $(By.xpath("//*[@data-cy='method-smart-id']")).click();
    }

    public void smartIdLoginButton(){
        $(By.xpath("//*[@data-cy='smart-id-login-button']")).click();
    }

    public void smartIdInput(){
        $(By.xpath("//*[@data-cy='smart-id-input']/div/input")).shouldBe(Condition.editable);
    }

    public void smartIdLoginButtonVisible(){
        $(By.xpath("//*[@data-cy='smart-id-login-button']")).shouldBe(Condition.visible);
    }

    public void editableSmartIdMethod(){
        $(By.xpath("//*[@data-cy='method-smart-id']")).shouldBe(Condition.editable);
    }

    public void editableLoginField(){
        $(By.xpath("//*[@id='login-field']/div/input")).shouldBe(Condition.editable);
    }

    public void editablePasswordField(){
        $(By.xpath("//*[@id='password-field']/div/input")).shouldBe(Condition.editable);
    }

    public void mobileIdMethod(){
        $(By.xpath("//*[@data-cy='method-mobile-id']")).click();
    }

    public void mobileIdPhoneInput(){
        $(By.xpath("//*[@data-cy='mobile-id-phone-input']")).shouldBe(Condition.editable);
    }
    public void mobileIdPinField(){
        $(By.xpath("//*[@id='pin-field']/div/input")).shouldBe(Condition.editable);
    }

    public void mobileIdLoginButton(){
        $(By.xpath("//*[@data-cy='mobile-id-login-button']")).shouldBe(Condition.visible);
    }
}