package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class conReader {

    private  static Properties properties = new Properties();

    static {

        try {
            FileInputStream fis = new FileInputStream("con.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("con file is not found");
        }

    }


    public static String getProperty(String browserKey){
        return properties.getProperty(browserKey,"chrome");
    }


}
