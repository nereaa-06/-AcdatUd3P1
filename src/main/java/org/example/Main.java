package org.example;

public class Main {
    public static void main(String[] args) {

        ConexionSingleton.conectar();
        EjecucionDDL.createTable();
        EjecucionDML.consulta();
        EjecucionDDL.insert();
        EjecucionDML.consulta();
        EjecucionDML.update();
        EjecucionDML.consulta();
        EjecucionDDL.delete();
        EjecucionDML.consulta();

        EjecucionDDL.dropTable();
        ConexionSingleton.desconectar();


    }
}