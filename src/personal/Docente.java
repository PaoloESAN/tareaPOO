package personal;

public class Docente extends Persona{
    
    private String profesion;
    
    public Docente(String dni, String apeNom, String fechaNac, String telef, String direccion, String sexo, String profesion) {
        this.dni =dni;
        this.apeNom = apeNom;
        this.fechaNac =fechaNac;
        this.telef =telef;
        this.direccion =direccion;
        this.sexo =sexo;
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

}
