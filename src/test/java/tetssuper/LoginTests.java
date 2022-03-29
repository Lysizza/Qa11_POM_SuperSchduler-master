package tetssuper;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTests extends Configuration {

    @Test
    public void registrationSuccess(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;


//        boolean isRegistrationSuccess = new SplashScreen(driver)
//                .checkVersion("0.0.3")

        boolean isRegistrationSuccess = new LoginScreen(driver)
                .fillEmail("wick" + index + "@mail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton()
                .skipWizard()
                .isPlusButtonPresent();

        Assert.assertTrue(isRegistrationSuccess);
    }

    @Test
    public void registrationSuccessModel(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        User user = User.builder().email("wick"+index+"@mail.com").password("Ww12345$").build();
       // logger.info ("This test run with user " + user.toString());
        boolean plusButtonPresent = new LoginScreen(driver)
                .complexLogin(user)
                .skipWizard()
                .isPlusButtonPresent();

        Assert.assertTrue(plusButtonPresent);

    }



    @Test
    public void loginSuccess(){

//        boolean isLoginSuccess = new SplashScreen(driver)
//                .checkVersion("0.0.3")

        boolean isLoginSuccess = new LoginScreen(driver)
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton()
                .skipWizard()
                .isPlusButtonPresent();

        Assert.assertTrue(isLoginSuccess);


    }

    @AfterMethod
    public void postCondition(){
//        boolean logOutSuccess = new HomeScreen(driver)
//                .openMenu()
//                .logOut()
//                .isLoginButtonPresent();
//Assert.assertTrue(logOutSuccess);

        new HomeScreen(driver)
                .openMenu()
                .logOut().
                loginButtonPresent();

    }
}
