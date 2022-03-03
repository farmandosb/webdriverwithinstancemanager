package webdriverdemo;

import webdriverdemo.controls.Button;
import webdriverdemo.pageObjects.Home;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class Tests1 extends BaseTest{
    @Test
    public void Test(){
        Home home = new Home();
        int linksCount = home.getLinks().size();

        for(int i = 0; i < linksCount; i++){
            home.getLinks().get(i).click();
            this.goBack();
        }
    }

    @Test
    public void ListOfControlsTest() throws InterruptedException {
        Home home = new Home();
        home.waitUntil(()->home.isDisplayed());
        Button btn1 = home.btnPrimero();
        boolean displayed = btn1.isDisplayed();
        boolean isClickable = btn1.isClickable();
        btn1.click();
        Thread.sleep(15000);



    }
}
