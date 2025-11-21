package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjecucionDML {

    public static void consulta ( ){
        String sql = "SELECT * FROM persona;";

        try {
            Connection conn = ConexionSingleton.getConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            System.out.println("Consulta ejecutada correctamente.");

            while (st.getResultSet().next()) {
                ResultSet rs = st.getResultSet();
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update ( ) {
        String sql = "UPDATE persona SET apellido = 'López' WHERE nombre = 'Juan';";

        try {
            Connection con = ConexionSingleton.getConnection();
            Statement st = con.createStatement();
            int filasAfectadas = st.executeUpdate(sql);
            System.out.println("Filas actualizadas: " + filasAfectadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
