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
}