package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    private volatile static ConfigFileReader configFileReader = null;

    private final Properties properties;

    private static final String PROPERTY_FILE_PATH = "src/test/resources/configuration.properties";

    public ConfigFileReader() {

        properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(PROPERTY_FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getToolsQAUrl() {
        String toolsQA = properties.getProperty("toolsQA");
        if (toolsQA != null)
            return toolsQA;
        else
            throw new RuntimeException("url is not specified in the configuration.properties file.");
    }

    public String getDefaultBrowserName() {
        return this.properties.getProperty("application.default.browser");
    }

    public static ConfigFileReader createOrGetInstance() {
        if (configFileReader == null) {
            synchronized (ConfigFileReader.class) {
                if (configFileReader == null) {
                    configFileReader = new ConfigFileReader();
                }
            }
        }
        return configFileReader;
    }

}
