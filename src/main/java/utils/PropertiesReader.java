package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readkey(String key) throws IOException {
        String file = System.getProperty("user.dir")+"/src/test/resources/data.properties";

        try {
            FileInputStream fileInputStream
                    = new FileInputStream(file);

            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
