package org.JavaSelenium.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;
    private final String propertyFilePath = ".//Configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFormURL() {
        String form_url = properties.getProperty("Form_URL");
        if (form_url != null)
            return form_url;
        else
            throw new RuntimeException("form_url not specified in the Configuration.properties file.");
    }

    public String getImageURL() {
        String image_url = properties.getProperty("Image_URL");
        if (image_url != null)
            return image_url;
        else
            throw new RuntimeException("image_url not specified in the Configuration.properties file.");
    }
}
