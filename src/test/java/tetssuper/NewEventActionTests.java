package tetssuper;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class NewEventActionTests extends Configuration {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(User.builder().email("wick@gmail.com").password("Ww12345$").build())
                .skipWizard();
    }
    @Test
    public void addEventAction(){
       boolean plusButtonPresent = new HomeScreen(driver)
                .initCreationEvent()
                .actionData()
                .createNewEvent(Event.builder().title("Title").type("Type").breaks(2).wage(50).build())
                .isPlusButtonPresent();
        Assert.assertTrue(plusButtonPresent);
    }
}

