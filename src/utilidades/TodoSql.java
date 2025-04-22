package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoSql {
    
    public static boolean probarConexion(String servidor, String usuario, String contraseña) {
        String url = "jdbc:sqlserver://" + servidor + ";trustServerCertificate=true";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static List<String> listaDatabases(String servidor, String usuario, String contraseña){
        
        String url = "jdbc:sqlserver://" + servidor + ";trustServerCertificate=true";
    
        List<String> listaBases = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement stmt = conn.createStatement();

            String sql = "SELECT name FROM sys.databases";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dbName = rs.getString("name");
                listaBases.add(dbName);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    return listaBases;
    }
}