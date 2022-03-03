package webdriverdemo.controls;

import webdriverdemo.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.Callable;

public class BaseControl {
    protected WebDriver driver;
    protected By by;
    private WebElement container;

    public BaseControl(){
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
    }
    public BaseControl(By locator){
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
        this.by = locator;
        this.container = this.driver.findElement(locator);
    }

    protected WebElement webElement(){
        try{
            return this.driver.findElement(this.by);
        }
        catch (Exception e){
            return null;
        }
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
            return this.webElement().isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isEnabled(){
        try{
            return this.webElement().isEnabled();
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
}
