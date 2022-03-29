package tetssuper;

import manager.Configuration;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class EventCreateWithLogoutAfterTest extends Configuration {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver)
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton()
                .skipWizard();
    }



    @Test
    public void createNewEventTest(){

        boolean plusButtonPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder().title("Title").type("Type").breaks(2).wage(50).build())
                .isPlusButtonPresent();
        Assert.assertTrue(plusButtonPresent);
    }
    @Test
    public void createNewEventTest2(){

        boolean plusButtonPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder().title("Title").type("Type").breaks(2).wage(50).build())
                .isPlusButtonPresent();
        Assert.assertTrue(plusButtonPresent);
    }
@AfterMethod
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logOut()
                .loginButtonPresent();
    }

}
