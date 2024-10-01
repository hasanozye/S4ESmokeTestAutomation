package readers.property;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    Properties properties = new Properties();
    FileReader fileReader;
    String filePath;


    public PropertyReader(String fileName) {

        try {
            this.filePath = "src/test/resources/datafiles/" + fileName + ".properties";
            fileReader = new FileReader(filePath);
            properties.load(fileReader);
        } catch (IOException exception) {
            throw new ConfigurationLoadException("Failed to load properties from file: " + filePath, exception);
        }
    }

    public static PropertyReader read() {
        return read("config");
    }

    public static PropertyReader read(String fileName) {
        return new PropertyReader(fileName);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void delProperty(String key) {
        properties.remove(key);
    }


}


class ConfigurationLoadException extends RuntimeException {

    public ConfigurationLoadException(String message, Throwable cause) {
        super(message, cause);
    }

}
