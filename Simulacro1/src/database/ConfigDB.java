package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://boejgq55w88up73sj8rk-mysql.services.clever-cloud.com:3306/boejgq55w88up73sj8rk";
            String user = "u9z1krya3ijmprfo";
            String password = "aNC3SueZnoksFP3s3DXw";

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
