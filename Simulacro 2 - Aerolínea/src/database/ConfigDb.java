package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDb {

    private static ConfigDb instance = null; //El parametro que define la instancia de la clase
    private Connection objConnection = null; //La conexion es una interface de JAVA
    private final String url = "jdbc:mysql://bbcplxncxjuufnxw1dn9-mysql.services.clever-cloud.com:3306/bbcplxncxjuufnxw1dn9";
    private final String user = "u31lf5yjgw2xqubb";
    private final String password = "6XhWfNwbdGOp28lver6P";

    private ConfigDb() { //El constructor privado lo usamos para evitar que haya mas de una instancia
    }

    public static ConfigDb getInstance() { //Este metodo nos sirve para obtener la instancia
        if (instance == null) {
            instance = new ConfigDb();
        }
        instance.conexionAbierta();
        return instance;
    }

    private void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Esta es la clase que tiene el controlador
            objConnection = DriverManager.getConnection(url, user, password);

        } catch (SQLException excepcion) { //Los errores que devuelve SQL ... la base de datos
            throw new RuntimeException(excepcion);  //RuntimeException -> Error en tiempo de ejecucion
        } catch (ClassNotFoundException excepcion) { //No encuentro la clase
            throw new RuntimeException(excepcion);
        }
    }

    private void conexionAbierta() {
        try {
            if (objConnection == null || objConnection.isClosed()) {
                openConnection();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return objConnection;
    }

    public void closeConnection() {
        try {
            if (objConnection != null) {
                objConnection.close();
                System.out.println("La conexión esta cerrada");
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
