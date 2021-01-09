package com.petra.controwell.model.data.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase Proper para leer datos de archivos con extension.conf
 * @author Angello Morales
 */
public class Proper {

    private Properties prop = new Properties();

    public Proper() {
        InputStream is = getClass().getResourceAsStream("/config/conf.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public Properties getProp() {
        return prop;
    }

}
