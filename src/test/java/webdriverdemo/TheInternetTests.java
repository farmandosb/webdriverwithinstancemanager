package webdriverdemo;

import org.junit.jupiter.api.Test;
import webdriverdemo.controls.Link;
import webdriverdemo.pageObjects.theInternet.Home;

import java.util.ArrayList;
import java.util.List;

public class TheInternetTests extends BaseTest{

    @Test
    public void Test01(){
        this.goTo("https://the-internet.herokuapp.com/");
        //this.driver.navigate().to("https://the-internet.herokuapp.com/");
        List<Link> linksList = new ArrayList<>();
        Home home = new Home();
        home.links().forEach(linksList::add);
        linksList.get(4).click();

    }

}
