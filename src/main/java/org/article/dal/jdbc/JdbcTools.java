package org.article.dal.jdbc;

import org.article.dal.DalException;
import java.sql.*;
public class JdbcTools {

    public static Connection getConenction() throws DalException {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mariadb://");
        sb.append(Settings.getProperty("server")).append(":");
        sb.append(Settings.getProperty("port")).append("/");
        sb.append(Settings.getProperty("db")).append("?");
        sb.append("user=").append(Settings.getProperty("user"));
        sb.append("&").append("password=").append(Settings.getProperty("mdp"));

        Connection cnx = null;

        try {
            cnx = DriverManager.getConnection(sb.toString());
        } catch (SQLException e) {

            throw new DalException(" Erreur de connexion à la base de données ", e.getCause());
        }

        return cnx;

    }
}
