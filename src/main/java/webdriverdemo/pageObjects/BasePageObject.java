package webdriverdemo.pageObjects;

import org.openqa.selenium.WebElement;
import webdriverdemo.controls.BaseControl;
import webdriverdemo.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class BasePageObject {
    protected WebDriver driver;
    protected By by;
    private WebElement container;

    public BasePageObject() {
    }

    public BasePageObject(By locator){
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
        this.by = locator;
        this.container = this.driver.findElement(locator);
    }

    public void setLocator(By newLocator){
        this.by = newLocator;
    }

    public void setContainer(WebElement webElement){
        this.container = webElement;
    }

    public boolean isDisplayed()
    {
        try {
            return this.driver.findElement(this.by).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean waitUntil(Callable<Boolean> func, long timeout){
        try{
            WebDriverWait waiter = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
            return waiter.until(x -> {
                try {
                    return func.call();
                } catch (Exception e) {
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitUntil(Callable<Boolean> func){
        return this.waitUntil(func, 10);
    }

    public <T extends BaseControl > T newControl(String xpath, Class<T> type){
        try {
            T newControl = type.newInstance();
            newControl.setContainer(this.container.findElement(By.xpath(xpath)));
            newControl.setLocator(By.xpath(xpath));
            return newControl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public <T extends BaseControl> Iterable<T> createListOfControls(String xpath, Class<T> type){
        List<T> listOfControls = new ArrayList<T>();
        long count = this.driver.findElements(By.xpath(xpath)).stream().count();

        for (int i = 1; i <= count; i++)
        {
            By locator = By.xpath(String.format("(%s)[%d]", xpath, i));
            try {
                T newControl = type.newInstance();
                newControl.setContainer(this.container.findElement(locator));
                listOfControls.add(newControl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listOfControls;
    }
}
