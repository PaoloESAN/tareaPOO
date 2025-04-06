package ejercicioavanzado;
import java.util.Scanner;

public class TPERSONA {
//----------------------------------
//PROPIEDADES
//----------------------------------
private String DNI;
private String APENOM;
private String FECNAC;
private String TELEFONO;
private String DIRECCION;
private char SEXO;
private double SALARIO;
//----------------------------------
//METODO CONSTRUCTOR
//----------------------------------
public TPERSONA() {
}
//----------------------------------
//METODOS SET
//----------------------------------
public void Establecer_DNI(String dni) {
    this.DNI = dni;
}
public void Establecer_APENOM(String apenom) {
    this.APENOM = apenom;
}
public void Establecer_FECNAC(String fecnac) {
    this.FECNAC = fecnac;
}
public void Establecer_TELEFONO(String telefono) {
    this.TELEFONO = telefono;
}
public void Establecer_DIRECCION(String direccion) {
    this.DIRECCION = direccion;
}
public void Establecer_SEXO(String CAD) {  //char sexo
    this.SEXO = CAD.charAt(0);
}
public void Establecer_SALARIO(String CAD) {  //double salario
    this.SALARIO = Double.parseDouble(CAD);
}
//----------------------------------
//METODOS GET
//----------------------------------
public String Obtener_DNI() {
    return this.DNI;
}
public String Obtener_APENOM() {
    return this.APENOM;
}
public String Obtener_FECNAC() {
    return this.FECNAC;
}
public String Obtener_TELEFONO() {
    return this.TELEFONO;
}
public String Obtener_DIRECCION() {
    return this.DIRECCION;
}
public char Obtener_SEXO() {
    return this.SEXO;
}
public double Obtener_SALARIO() {
    return this.SALARIO;
}
//----------------------------------
//----------------------------------
//----------------------------------
public String Registro_DatosGenerales() {
Scanner OBJ = new Scanner(System.in);
TLib    LIB = new TLib();
String CAD;

   do {
      System.out.print(" - DNI                : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"DNI",8,8,"0123456789"));
   Establecer_DNI(CAD);
   
   do {
      System.out.print(" - Apellidos y Nombres: ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Apellidos/Nombres",3,30,"ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz" + (char)164 + (char)165));
   Establecer_APENOM(CAD);

   do {
      System.out.print(" - Fecha de Nacimiento: ");
      CAD = OBJ.nextLine();
   } while(!LIB.FechaOK(CAD,1960,2006));
   Establecer_FECNAC(CAD);

   do {
      System.out.print(" - Telefono           : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Telefono",9,9,"0123456789"));
   Establecer_TELEFONO(CAD);

   do {
      System.out.print(" - Direccion          : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Direccion",5,30,"ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz.0123456789"));
   Establecer_DIRECCION(CAD);

   do {
      System.out.print(" - Sexo               : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Sexo",1,1,"MF"));
   Establecer_SEXO(CAD);

   do {
      System.out.print(" - Salario            : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Salario",3,10,"0.123456789"));
   Establecer_SALARIO(CAD);

   System.out.println("--------------------------------------------");

   String TMP = "" + SALARIO;
   return   DNI + 
            APENOM + LIB.Replicate(' ',30 - APENOM.length()) + 
            FECNAC + 
            TELEFONO + 
            DIRECCION + LIB.Replicate(' ',30 - DIRECCION.length()) + 
            SEXO + 
            LIB.Replicate(' ',10 - TMP.length()) + TMP;


}
//----------------------------------
} //class
