package org.article.dal.jdbc;

import org.article.dal.DalException;

import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static Properties properties;
    private static void chargement() throws DalException {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(Settings.class.getClassLoader().getResourceAsStream("settings.properties"));
            } catch (IOException e) {
                throw new DalException("Erreur lors du chargement du fichiers contenant les informations de connection à la base de données");
            }
        }
    }
    public static String getProperty(String key) throws DalException {
        chargement();
        return properties.getProperty(key);
    }
}