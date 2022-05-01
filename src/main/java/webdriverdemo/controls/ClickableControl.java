package webdriverdemo.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickableControl extends BaseControl{
    public ClickableControl (){
        super();
    }
    public ClickableControl(By locator) {
        super(locator);
    }
    public boolean isClickable(){
        try {
            return ExpectedConditions.elementToBeClickable(this.by).apply(this.driver).isEnabled();
        }
        catch (Exception e){
            return false;
        }
    }

    public void click(){
        try {
            this.whenClickable(10).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WebElement whenClickable(long timeout){
        if (this.waitUntil(this::isClickable, timeout)){
            return this.webElement();
        }
        else{
            return null;
        }
    }
}
