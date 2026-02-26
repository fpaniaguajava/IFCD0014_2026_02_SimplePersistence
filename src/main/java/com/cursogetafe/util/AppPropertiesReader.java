package com.cursogetafe.util;

import com.cursogetafe.Main;

import java.io.*;
import java.util.Properties;

/**
 * Lector de properties de un fichero ubicado en el classpath del proyecto
 */
public class AppPropertiesReader {
    public static String readProperty(String fileName, String key) {
        Properties props = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(input);
            String value = props.getProperty(key);
            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
