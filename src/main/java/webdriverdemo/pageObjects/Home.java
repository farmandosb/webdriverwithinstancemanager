package webdriverdemo.pageObjects;

import org.openqa.selenium.By;
import webdriverdemo.controls.Button;
import webdriverdemo.controls.Link;

import java.util.ArrayList;
import java.util.List;

public class Home extends BasePageObject {
    public Home() {
        super(By.id("page-container"));
    }

    public List<Link> getLinks() {
        String css = "div.et_pb_text_inner li";
        By locator = By.cssSelector(css);
        int count = this.driver.findElements(locator).size();
        List<Link> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String expression = css + ":nth-of-type(" + (i + 1) + ") > a";
            result.add(new Link(By.cssSelector(expression)));
        }

        return result;
    }

    public Iterable<Link> links() {
        return this.createListOfControls(".//a", Link.class);
    }

    public Button btnPrimero() {
        return this.newControl(".//button", Button.class);
    }
}
