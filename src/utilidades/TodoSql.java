package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import personal.Alumno;
import personal.Docente;

public class TodoSql {
    
    private static String sqlUrl(SqlDatos datos){
        return "jdbc:sqlserver://" + datos.servidor + ";databaseName=" + datos.baseDeDatos  + ";trustServerCertificate=true";
    }
    
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
    
    public static boolean tablasExisten(String servidor, String nombreBase, String usuario, String contraseña) {
        String url = "jdbc:sqlserver://" + servidor + ";databaseName=" + nombreBase  + ";trustServerCertificate=true";
        boolean alumnos = false;
        boolean docentes = false;

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement stmt = conn.createStatement();

            String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME IN ( 'Alumnos', 'Docentes')";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("TABLE_NAME");
                if (nombre.equalsIgnoreCase("Alumnos")){
                    alumnos = true;
                }
                if (nombre.equalsIgnoreCase("Docentes")){
                    docentes = true;
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumnos && docentes;
    }
    
    public static boolean crearDatabase(String servidor, String usuario, String contra, String nombreBase){
        
        boolean exitoso=false;
        String url = "jdbc:sqlserver://" + servidor + ";trustServerCertificate=true";
        
        try {
            Connection conn = DriverManager.getConnection(url, usuario, contra);
            Statement stmt = conn.createStatement();

            String crearBase = "create database "+nombreBase;
            stmt.executeUpdate(crearBase);
            stmt.close();
            conn.close();

            String baseURL = "jdbc:sqlserver://"+servidor+";databaseName="+nombreBase+";trustServerCertificate=true";
            conn = DriverManager.getConnection(baseURL, usuario, contra);
            stmt = conn.createStatement();

            String crearAlumnos ="CREATE TABLE Alumnos (" +
                                                "Dni VARCHAR(20), " +
                                                "Nombre_Completo VARCHAR(100), " +
                                                "Fecha_de_Nacimiento VARCHAR(20), " +
                                                "Telefono VARCHAR(20), " +
                                                "Direccion VARCHAR(100), " +
                                                "Sexo VARCHAR(10))";
            stmt.executeUpdate(crearAlumnos);

            String crearDocentes ="CREATE TABLE Docentes (" +
                                                "Dni VARCHAR(20), " +
                                                "Nombre_Completo VARCHAR(100), " +
                                                "Fecha_de_Nacimiento VARCHAR(20), " +
                                                "Telefono VARCHAR(20), " +
                                                "Direccion VARCHAR(100), " +
                                                "Sexo VARCHAR(10), " +
                                                "Profesion VARCHAR(50))";
            stmt.executeUpdate(crearDocentes);

            stmt.close();
            conn.close();
            exitoso = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exitoso;
    }
    public static void registrarDatosAlumno(SqlDatos datos,Alumno alum){
        String url = sqlUrl(datos);

        String sql = "INSERT INTO Alumnos (Dni, Nombre_Completo, Fecha_de_Nacimiento, Telefono, Direccion, Sexo) " +
                     "VALUES ('" +alum.getDni() + "', '" + alum.getApeNom() + "', '" + alum.getFechaNac() + "', '" + alum.getTelef() + "', '" + alum.getDireccion() + "', '" + alum.getSexo() + "')";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void registrarDatosDocente(SqlDatos datos,Docente doce){
        String url = sqlUrl(datos);

        String sql = "INSERT INTO Docentes (Dni, Nombre_Completo, Fecha_de_Nacimiento, Telefono, Direccion, Sexo, Profesion) " +
                     "VALUES ('" +doce.getDni() + "', '" + doce.getApeNom() + "', '" + doce.getFechaNac() + "', '" + doce.getTelef() + "', '" + doce.getDireccion() + "', '" + doce.getSexo() + ", " + doce.getProfesion() +"')";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Alumno> obtenerAlumnos(SqlDatos datos) {
        String url = sqlUrl(datos);

        List<Alumno> alumnos = new ArrayList<>();

        String sql = "SELECT * FROM Alumnos";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                Alumno fila = new Alumno(rs.getString("Dni"), 
                        rs.getString("Nombre_Completo"), 
                        rs.getString("Fecha_de_Nacimiento"), 
                        rs.getString("Telefono"), rs.getString("Direccion") , rs.getString("Sexo"));
                alumnos.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumnos;
    }
    public static List<Docente> obtenerDocentes(SqlDatos datos) {
        String url = sqlUrl(datos);

        List<Docente> docentes = new ArrayList<>();

        String sql = "SELECT * FROM Docentes";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                Docente fila = new Docente(rs.getString("Dni"), 
                        rs.getString("Nombre_Completo"), 
                        rs.getString("Fecha_de_Nacimiento"), 
                        rs.getString("Telefono"), rs.getString("Direccion") , rs.getString("Sexo"),rs.getString("Profesion"));
                docentes.add(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docentes;
    }
    public static void modificarAlumno(SqlDatos datos, Alumno alum){
        String url = sqlUrl(datos);

        String sql = "UPDATE Alumnos SET " +
                     "Nombre_Completo = '" + alum.getApeNom() + "', " +
                     "Fecha_de_Nacimiento = '" + alum.getFechaNac() + "', " +
                     "Telefono = '" + alum.getTelef() + "', " +
                     "Direccion = '" + alum.getDireccion() + "', " +
                     "Sexo = '" + alum.getSexo() + "' " +
                     "WHERE Dni = '" + alum.getDni() + "'";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void modificarDocente(SqlDatos datos, Docente docen){
        String url = sqlUrl(datos);

        String sql = "UPDATE Docentes SET " +
                     "Nombre_Completo = '" + docen.getApeNom() + "', " +
                     "Fecha_de_Nacimiento = '" + docen.getFechaNac() + "', " +
                     "Telefono = '" + docen.getTelef() + "', " +
                     "Direccion = '" + docen.getDireccion() + "', " +
                     "Sexo = '" + docen.getSexo() + "' " +
                     "WHERE Dni = '" + docen.getDni() + "'";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void eliminarAlumno(SqlDatos datos, String dni) {
        String url = sqlUrl(datos);

        String sql = "DELETE FROM Alumnos WHERE Dni = '" + dni + "'";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void eliminarDocente(SqlDatos datos, String dni) {
        String url = sqlUrl(datos);

        String sql = "DELETE FROM Docentes WHERE Dni = '" + dni + "'";

        try (
            Connection conn = DriverManager.getConnection(url, datos.usuario, datos.contra);
            Statement stmt = conn.createStatement()
        ) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}