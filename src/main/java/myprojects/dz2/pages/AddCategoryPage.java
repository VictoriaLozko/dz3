package myprojects.dz2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCategoryPage {

    private EventFiringWebDriver driver;
    private By saveLocator = By.id("category_form_submit_btn");
    private By inputNameLocator = By.id("name_1");

    public AddCategoryPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void addCategory(String name){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(saveLocator));

        WebElement inputNameElement = driver.findElement(inputNameLocator);
        inputNameElement.sendKeys(name);

        WebElement saveElement = driver.findElement(saveLocator);
        saveElement.click();
    }
}
