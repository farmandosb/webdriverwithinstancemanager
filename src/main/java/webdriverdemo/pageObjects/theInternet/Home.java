package webdriverdemo.pageObjects.theInternet;

import org.openqa.selenium.By;
import webdriverdemo.controls.Link;
import webdriverdemo.pageObjects.BasePageObject;

public class Home extends BasePageObject {
    public Home(){
        super(By.id("content"));
    }

    public Iterable<Link> links() {
        return this.createListOfControls(".//a", Link.class);
    }
}
