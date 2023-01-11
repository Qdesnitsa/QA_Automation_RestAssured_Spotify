package api.automation.spotify.oauth2.util;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader = new ConfigLoader();

    private ConfigLoader() {
        properties = PropertyUtil.loadProperties("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        return configLoader;
    }

    public String getClientId() {
        String prop = properties.getProperty("client_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property client_id is not specified in the config.properties file.");
        }
    }

    public String getClientSecret() {
        String prop = properties.getProperty("client_secret");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property client_secret is not specified in the config.properties file.");
        }
    }

    public String getGrantType() {
        String prop = properties.getProperty("grant_type");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property grant_type is not specified in the config.properties file.");
        }
    }

    public String getRefreshToken() {
        String prop = properties.getProperty("refresh_token");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property refresh_token is not specified in the config.properties file.");
        }
    }

    public String getUserId() {
        String prop = properties.getProperty("user_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property user_id is not specified in the config.properties file.");
        }
    }
}
