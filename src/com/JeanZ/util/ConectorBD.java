package com.JeanZ.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConectorBD {
    public  static  Connection connection = null;
    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }else {

            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("bd.properties "));

                String driver = properties.getProperty("Driver");
                String url = properties.getProperty("url");
                String user  = properties.getProperty("user");
                String password = properties.getProperty("password");

                Class.forName(driver);//cargar el driver

                connection = DriverManager.getConnection(url, user, password);

            } catch (IOException e) {
                System.out.println("Error en el archivo propeties : " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error al cargar el driver : " + e.getMessage());
            } catch (SQLException throwables) {
                System.out.println("Eror en la conexion de la BD : " + throwables.getMessage());
            }
        }
        return connection;
    }
}









































