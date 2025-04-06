package ejercicioavanzado;

import java.io.IOException;  
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GESTION_PERSONAL {
//-----------------------------------------------
private static TLib LIB = new TLib();
private static String FILENAME = "PERSONAL.DAT";
private static int W = 129;
//-----------------------------------------------

    public GESTION_PERSONAL(){
    try {
        main(new String[]{});
    } catch (IOException | InterruptedException ex) {
        Logger.getLogger(GESTION_PERSONAL.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

public static void IngresoPersonal() throws IOException, InterruptedException {
int nn;
char TIPO,OPCION='?';
Scanner TECLADO = new Scanner(System.in);
TADMINISTRATIVO OBJ1 = new TADMINISTRATIVO();
TSALUD          OBJ2 = new TSALUD();
String CAD,LINEA="";
   nn = 0;
   do {
      LIB.ClearScreen();
      System.out.println("============================================");
      System.out.println(" MODULO DE INGRESO DE REGISTROS DE PERSONAL ");
      System.out.println("============================================");
      nn++;
      System.out.println("Registro Nro. " + nn);
      do {
         System.out.print(" - Tipo de Personal   : ");
         CAD = TECLADO.nextLine();
      } while(!LIB.ValidacionOK(CAD,"Tipo de Personal",1,1,"12"));
      TIPO = CAD.charAt(0);
      if(TIPO=='1') {
         LINEA = TIPO + OBJ1.Registro_PersonalAdministrativo();
      }
      else {
         LINEA = TIPO + OBJ2.Registro_PersonalSalud();
      }
      LIB.WriteDataFile(FILENAME, LINEA + LIB.Replicate(' ',W - LINEA.length()));
      System.out.println("--------------------------------------------");
      System.out.println();
      do {
         System.out.print("Desea Continuar? [S/N]: ");
         CAD = TECLADO.nextLine();
      } while(!LIB.ValidacionOK(CAD,"",1,1,"NnSs"));
      OPCION = CAD.charAt(0);
   } while((OPCION!='N')&&(OPCION!='n'));
}
//-----------------------------------------------
public static void ModificacionPersonal() throws IOException, InterruptedException {
Scanner TECLADO = new Scanner(System.in);
   LIB.ClearScreen();
   System.out.print("ModificacionPersonal");
   System.out.print("Pulse una Tecla!!!..."); TECLADO.nextLine();
}
//-----------------------------------------------
public static void EliminacionPersonal() throws IOException, InterruptedException {
Scanner TECLADO = new Scanner(System.in);
   LIB.ClearScreen();
   System.out.print("EliminacionPersonal");
   System.out.print("Pulse una Tecla!!!..."); TECLADO.nextLine();
}
//-----------------------------------------------
public static void BusquedaPorDNI() throws IOException, InterruptedException {
Scanner TECLADO = new Scanner(System.in);
   LIB.ClearScreen();
   System.out.print("BusquedaPorDNI");
   System.out.print("Pulse una Tecla!!!..."); TECLADO.nextLine();
}
//-----------------------------------------------
public static void BusquedaPorApeNom() throws IOException, InterruptedException {
Scanner TECLADO = new Scanner(System.in);
   LIB.ClearScreen();
   System.out.print("BusquedaPorApeNom");
   System.out.print("Pulse una Tecla!!!..."); TECLADO.nextLine();
}
//-----------------------------------------------
public static void ListadoPersonal() throws IOException, InterruptedException {
Scanner TECLADO = new Scanner(System.in);
   LIB.ClearScreen();
   System.out.println("============================================================");
   System.out.println(" LISTADO DE REGISTROS DE PERSONAL           ");
   System.out.println("============================================================");
   LIB.ListDataFile(FILENAME,'1',"PERSONAL ADMINISTRATIVO");
   LIB.ListDataFile(FILENAME,'2',"PERSONAL DE SALUD");
   System.out.print("\nPulse una Tecla!!!..."); TECLADO.nextLine();
}
//-----------------------------------------------
public static char MenuPrincipal() throws IOException, InterruptedException {
Scanner TECLADO = new Scanner(System.in);
String CAD;
      LIB.ClearScreen();
      //System.out.println("=================================================");
      System.out.println("         HOSPITAL NACIONAL UNIVERSITARIO         ");
      System.out.println("          MODULO DE REGISTRO DE PERSONAL         ");
      System.out.println("=================================================");
      System.out.println();
      System.out.println("       -----------------------------------");
      System.out.println("                MENU PRINCIPAL                ");
      System.out.println("       -----------------------------------");
      System.out.println("          1. Ingreso de Personal");
      System.out.println("          2. Modificacion de Personal");
      System.out.println("          3. Eliminacion de Personal");
      System.out.println("          4. Busqueda por DNI");
      System.out.println("          5. Busqueda por Apellido/Nombre");
      System.out.println("          6. Listado de Personal");
      System.out.println("          7. Finalizar Ejecucion");
      System.out.println("       -----------------------------------");
      do {
         System.out.print  ("           SELECCIONE OPCION: ");
         CAD = TECLADO.nextLine();
      } while(!LIB.ValidacionOK(CAD,"",1,1,"1234567"));
      return CAD.charAt(0);
}
//-----------------------------------------------
public static void main(String[] args) throws IOException, InterruptedException {
int nn;
char OPCION='?';
String CAD;
   do {
      OPCION = MenuPrincipal();
      switch(OPCION) {
         case '1': IngresoPersonal(); break;
         case '2': ModificacionPersonal(); break;
         case '3': EliminacionPersonal(); break;
         case '4': BusquedaPorDNI(); break;
         case '5': BusquedaPorApeNom(); break;
         case '6': ListadoPersonal(); break;
          default: LIB.ClearScreen(); System.exit(0);
      }
   } while(OPCION!='7');
}
//-----------------------------------------------
} //class
