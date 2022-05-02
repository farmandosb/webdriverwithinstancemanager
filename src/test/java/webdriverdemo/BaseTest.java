package webdriverdemo;

import webdriverdemo.configuration.ConfigureExternalProperties;
import webdriverdemo.driver.WebDriverManager;
//import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected String url = "https://www.ultimateqa.com/automation/";

    public BaseTest(){
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        //this.driver.get(this.url);
    }

    public void goBack(){
        this.driver.navigate().back();
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    @AfterEach
    public void tearDown() {
        WebDriverManager.getCurrentInstance().destroy();
    }
}