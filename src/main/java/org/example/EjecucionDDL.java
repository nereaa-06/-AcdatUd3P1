package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EjecucionDDL {
    public static void createTable() {
        String sql = "CREATE TABLE persona ("
                + "id SERIAL PRIMARY KEY, \n"
                + "nombre VARCHAR(100) NOT NULL, \n"
                + "apellido VARCHAR(100) NOT NULL"
                + ");";

        try {
            Connection conn = ConexionSingleton.getConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            System.out.println("Tabla PERSONA creada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insert() {
        String sql = "INSERT INTO persona (nombre, apellido) VALUES "
                + "('Juan', 'Pérez'), "
                + "('María', 'Gómez'), "
                + "('Luis', 'Rodríguez');";

        try {
            Connection conn = ConexionSingleton.getConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            System.out.println(" filas insertadas en la tabla PERSONA.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete () {
        System.out.println("Que registro desea eliminar (ID)?");
        Scanner scanner = new Scanner(System.in);
        int registro = scanner.nextInt();
        String sql = "DELETE FROM persona WHERE ID = " + registro + ";";

        try {
            Connection conn = ConexionSingleton.getConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            System.out.println("Registro eliminado de la tabla PERSONA.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        String sql = "DROP TABLE persona;";

        try {
            Connection conn = ConexionSingleton.getConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            System.out.println("Tabla PERSONA eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
