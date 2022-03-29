package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;

    @FindBy (how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logout;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;

    public boolean isPlusButtonPresent(){

        should(fabAdd,20);
        return fabAdd.isDisplayed();
    }

    public HomeScreen openMenu(){
        burgerMenu.click();
        return this;
    }
    public LoginScreen logOut(){
        logout.click();
        return new LoginScreen(driver);
    }

    public EditCreateEventScreen initCreationEvent(){
        fabAdd.click();
        fabAddEvent.click();

        return new EditCreateEventScreen(driver);
    }
}
