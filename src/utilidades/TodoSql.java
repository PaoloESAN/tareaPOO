package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
