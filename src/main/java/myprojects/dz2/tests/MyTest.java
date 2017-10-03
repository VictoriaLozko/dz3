package myprojects.dz2.tests;

import myprojects.dz2.BaseTest;
import myprojects.dz2.pages.LoginPage;
import myprojects.dz2.pages.DashboardPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyTest extends BaseTest {

    public static void main(String[] args) {
        EventFiringWebDriver driver = getConfiguredDriver();

        login(driver);
        checkMenu(driver);

        quitDriver(driver);
    }

    private static void login(EventFiringWebDriver driver){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.clickLogoutButtonWithJS();
    }

    private static void checkMenu(EventFiringWebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.checkMenu();

        dashboardPage.clickLogoutButtonWithJS();
    }
}
