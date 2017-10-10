package myprojects.dz2.tests;

import myprojects.dz2.BaseTest;
import myprojects.dz2.pages.AddCategoryPage;
import myprojects.dz2.pages.CategoryPage;
import myprojects.dz2.pages.LoginPage;
import myprojects.dz2.pages.DashboardPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyTest extends BaseTest {

    public static void main(String[] args) {
        EventFiringWebDriver driver = getConfiguredDriver();

        login(driver);
        selectCategory(driver);
        addCategory(driver, "qwerty");

        quitDriver(driver);
    }

    private static void login(EventFiringWebDriver driver){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

    }

    private static void selectCategory(EventFiringWebDriver driver){
        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.selectCategory();

        //dashboardPage.clickLogoutButtonWithJS();
    }

    private static void addCategory(EventFiringWebDriver driver, String name){
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickAddCategoryIcon();
        AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
        addCategoryPage.addCategory(name);
        if (categoryPage.isMessageShown()){
            System.out.println("Сообщение об успешном добавлении категории отобразилось");
        } else {
            System.out.println("Сообщение об успешном добавлении категории не отобразилось");
        }
        if (categoryPage.isCategoryAdd(name)){
            System.out.println("Категория " + name + " добавлена");
        }else {
            System.out.println("Категория " + name + " не добавлена");
        }

    }

    private static void logout(EventFiringWebDriver driver){
        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.clickLogoutButtonWithJS();
    }
}
