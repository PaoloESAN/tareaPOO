package ejercicioavanzado;
import java.util.Scanner;

public class TADMINISTRATIVO extends TPERSONA {
//----------------------------------
//PROPIEDADES
//----------------------------------
private String OFICINA;
//----------------------------------
//METODO CONSTRUCTOR
//----------------------------------
public TADMINISTRATIVO() {
    super();
}
//----------------------------------
//METODOS SET
//----------------------------------
public void Establecer_OFICINA(String oficina) {
    this.OFICINA = oficina;
}
//----------------------------------
//METODOS GET
//----------------------------------
public String Obtener_OFICINA() {
    return this.OFICINA;
}
//----------------------------------
//----------------------------------
public String Registro_PersonalAdministrativo() {
Scanner OBJ = new Scanner(System.in);
TLib    LIB = new TLib();
String CAD,LINEA;
   LINEA = Registro_DatosGenerales();
   do {
      System.out.print(" - Oficina            : ");
      CAD = OBJ.nextLine();
   } while(!LIB.ValidacionOK(CAD,"Oficina",5,20,"ABCDEFGHIJKLMNOPQRSTUVWXYZ. abcdefghijklmnopqrstuvwxyz"));
   Establecer_OFICINA(CAD);
   return LINEA +  
          OFICINA + LIB.Replicate(' ',20 - OFICINA.length());
}
//----------------------------------
} //class
