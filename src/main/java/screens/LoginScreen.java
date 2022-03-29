package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement  emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email){
        should(emailEditText,15);
        type(emailEditText,email);
        return this;
    }

public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
}

public WizardScreen clickLoginButton(){
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
}

public WizardScreen complexLogin(User user){
        should(emailEditText,15);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new WizardScreen(driver);
}


public boolean isLoginButtonPresent(){
        should(loginButton,5);
        return loginButton.isDisplayed();
}


    public LoginScreen loginButtonPresent(){
        should(loginButton,5);
        Assert.assertTrue(loginButton.isDisplayed());
        return this;
    }
}
