package webdriverdemo;

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
}
