package webdriverdemo;

import org.junit.jupiter.api.Test;
import webdriverdemo.controls.Link;
import webdriverdemo.pageObjects.theInternet.Home;

import java.util.ArrayList;
import java.util.List;

public class TheInternetTests extends BaseTest{
    private Home home = new Home();

    @Test
    public void Test01(){
        this.goTo("https://the-internet.herokuapp.com/");
        List<Link> linksList = new ArrayList<>();
        this.home.links().forEach(linksList::add);
        linksList.get(2).click();

    }

}
