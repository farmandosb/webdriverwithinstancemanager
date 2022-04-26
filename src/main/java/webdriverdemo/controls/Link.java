package webdriverdemo.controls;

import org.openqa.selenium.By;

public class Link extends BaseControl {

    public Link(){
    }
    public Link(By locator) {
        super(locator);
    }

    public String getText(){
        try{
            return this.webElement().getText();
        }
        catch (Exception e){
            return null;
        }
    }
}