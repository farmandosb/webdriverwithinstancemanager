package webdriverdemo.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigureExternalProperties {
    public static Properties prop;

    public static void getProperties(){
        try (InputStream input = new FileInputStream("C:/Users/fsuarez/IdeaProjects/webdriverjavademo/config.properties")) {
            // load a properties file
            Properties props = new Properties();
            props.load(input);
            prop = props;

            // get the property value and print it out
            System.out.println("props: " + prop.getProperty("chromedriver.location"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
