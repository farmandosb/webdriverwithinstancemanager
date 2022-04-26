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
    private WebElement webElement;

    public BaseControl(){
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
    }
    public BaseControl(By locator){
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
        this.by = locator;
        this.webElement = this.driver.findElement(locator);
    }

    protected WebElement webElement(){
        try{
            if(this.by != null){
                this.webElement = this.driver.findElement(this.by);
            }

            return this.webElement;
        }
        catch (Exception e){
            return null;
        }
    }

    public void setLocator(By newLocator){
        this.by = newLocator;
    }

    public void setWebElement(WebElement webElement){
        this.webElement = webElement;
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
