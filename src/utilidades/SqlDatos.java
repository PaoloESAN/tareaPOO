package utilidades;

public class SqlDatos {
    String servidor;
    String usuario;
    String contra;
    String baseDeDatos;

    public SqlDatos(String servidor, String usuario, String contra, String baseDeDatos) {
        this.servidor = servidor;
        this.usuario = usuario;
        this.contra = contra;
        this.baseDeDatos = baseDeDatos;
    }

    public String getServidor() {
        return servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }
    
    
}
