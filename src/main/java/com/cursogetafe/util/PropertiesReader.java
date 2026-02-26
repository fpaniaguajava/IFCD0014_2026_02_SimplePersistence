package com.cursogetafe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Lector de properties de un fichero ubicado en la raíz del proyecto
 */
public class PropertiesReader {
    public static String readProperty(String fileName, String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(fileName)));
            String value = properties.getProperty(key);
            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
