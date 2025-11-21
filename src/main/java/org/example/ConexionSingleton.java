package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase ...
 *
 * @Autor: Javier Raposo Huelva
 * @Autor: Nerea Pérez Sánchez
 * @Version: 2025:11
 */
public class ConexionSingleton {
    private static Connection instancia;

    private ConexionSingleton() {
        // Constructor privado para evitar instanciación externa
    }

    public static void conectar() {

        System.out.println("Conectado a la base de datos.");

        String user = "usuario";
        String clave = "password";
        String servidor = "jdbc:postgresql://localhost:5432/midb";

        try {
            instancia = DriverManager.getConnection(servidor, user, clave);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() {
        return instancia;
    }

    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.close();
                System.out.println("Desconectado de la base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

