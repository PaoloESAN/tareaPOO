package ejercicioavanzado;
import java.util.Scanner;

public class TSALUD extends TPERSONA {
//----------------------------------
//PROPIEDADES
//----------------------------------
private String SERVICIO;
private String PROCEDENCIA;
//----------------------------------
//METODO CONSTRUCTOR
//----------------------------------
public TSALUD() {
   super();
}
//----------------------------------
//METODOS SET
//----------------------------------
public void Establecer_SERVICIO(String servicio) {
    this.SERVICIO = servicio;
}
public void Establecer_PROCEDENCIA(String procedencia) {
    this.PROCEDENCIA = procedencia;
}
//----------------------------------
//METODOS GET
//----------------------------------
public String Obtener_SERVICIO() {
    return this.SERVICIO;
}
public String Obtener_PROCEDENCIA() {
    return this.PROCEDENCIA;
}
//----------------------------------
public String Registro_PersonalSalud() {
Scanner OBJ = new Scanner(System.in);
TLib    LIB = new TLib();
String CAD,LINEA;
   LINEA = Registro_DatosGenerales();

   do {
      System.out.print(" - Servicio           : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Servicio",5,20,"ABCDEFGHIJKLMNOPQRSTUVWXYZ. abcdefghijklmnopqrstuvwxyz"));
   Establecer_SERVICIO(CAD);

   do {
      System.out.print(" - Procedencia        : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Procedencia",3,10,"ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
   Establecer_PROCEDENCIA(CAD);

   return LINEA +  
          SERVICIO + LIB.Replicate(' ',20 - SERVICIO.length()) + 
          PROCEDENCIA + LIB.Replicate(' ',10 - PROCEDENCIA.length());
}
//----------------------------------
} //class
