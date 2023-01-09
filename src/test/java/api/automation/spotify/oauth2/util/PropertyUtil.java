package api.automation.spotify.oauth2.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties file " + filePath, e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at " + filePath, e);
        }
        return properties;
    }
}
