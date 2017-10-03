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
    private By ordersTab = By.id("subtab-AdminParentOrders");
    private By menuLocator = By.cssSelector("ul.menu");
    private By menuItemsLocator = By.cssSelector("ul.menu > li");
    private By titleLocator = By.cssSelector("h2.title");
    private By page_titleLocator = By.cssSelector("h2.page-title");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void clickLogoutImage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions. elementToBeClickable(logoutImage));

        driver.findElement(logoutImage).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

    public void clickLogoutButtonWithJS(){
        WebElement element = driver.findElement(logoutButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }


    public void selectOrdersItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutImage));

        WebElement orderTabElement = driver.findElement(ordersTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(orderTabElement).build().perform();

        orderTabElement.findElements(By.cssSelector("li")).get(0).click();
    }

    public void checkMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutImage));

        WebElement element = driver.findElement(By.id("tab-AdminDashboard"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminParentOrders"));
        printInfo(element);
        //element = driver.findElement(By.id("subtab-AdminCatalog"));
        //printInfo(element);
        element = driver.findElement(By.id("subtab-AdminParentCustomer"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminStats"));
        printInfo(element);
        //element = driver.findElement(By.id("subtab-AdminParentModulesSf"));
        //printInfo(element);
        element = driver.findElement(By.id("subtab-AdminParentThemes"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminParentShipping"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminParentPayment"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminInternational"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-ShopParameters"));
        printInfo(element);
        element = driver.findElement(By.id("subtab-AdminAdvancedParameters"));
        printInfo(element);

        return;
    }

    public void printInfo(WebElement item){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String title;
        String newTitle;
        String id = item.getAttribute("id").toString();
        if (!id.equals("tab-SELL") && !id.equals("tab-IMPROVE") && !id.equals("tab-CONFIGURE")){
//Нажатие на каждый видимый пункт главного меню
            item.click();

            if (id.equals("subtab-AdminCatalog") || id.equals("subtab-AdminParentModulesSf")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#quick-access")));
            }else{
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#quick_select")));
            }
// Вывод заголовка
            if (id.equals("subtab-AdminCatalog") || id.equals("subtab-AdminParentModulesSf")) {
                title = driver.findElement(titleLocator).getText().toString();
            }else{
                title = driver.findElement(page_titleLocator).getText().toString();
            }
            System.out.println(title);
// Обновление страницы
            driver.navigate().refresh();

            if (id.equals("subtab-AdminCatalog") || id.equals("subtab-AdminParentModulesSf")) {
                newTitle = driver.findElement(titleLocator).getText().toString();
            }else{
                newTitle = driver.findElement(page_titleLocator).getText().toString();
            }
//Проверка, что пользователь остается в том же разделе после перезагрузки страницы
            if (title.equals(newTitle)){
                System.out.println("После перезагрузки раздел не поменялся");
            }else {
                System.out.println("После перезагрузки раздел поменялся");
            }
        }

        return;
    }
}