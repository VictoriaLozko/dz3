package myprojects.dz2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage {
    private EventFiringWebDriver driver;
    private By logoutImage = By.cssSelector("span.employee_avatar_small");
    private By logoutButton = By.id("header_logout");
    private By catalogTab = By.id("subtab-AdminCatalog");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void clickLogoutButtonWithJS(){
        WebElement element = driver.findElement(logoutButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }


    public void selectCategory(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutImage));

        WebElement categoryTabElement = driver.findElement(catalogTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryTabElement).build().perform();

        categoryTabElement.findElements(By.cssSelector("li")).get(1).click();
    }

}