package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bbcplxncxjuufnxw1dn9-mysql.services.clever-cloud.com:3306/bbcplxncxjuufnxw1dn9";
            String user = "u31lf5yjgw2xqubb";
            String password = "6XhWfNwbdGOp28lver6P";

            //Establecer la conexión
            objConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexión exitosa.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error > Driver no instalado" + e.getMessage());
        }catch (SQLException e){
            System.out.println("Error > Al conectar a la base de datos" + e.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection(){
        try{
            if(objConnection != null){
                objConnection.close();
                System.out.println("Se finalizo la conexión");
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
