package utilidades;

public class Validar {

    public Validar() {
    }
    
    public String validarDni(String textoVal){
        if (!ValidacionOK(textoVal,"DNI",8,8,"0123456789")) {
            return "Error en el DNI\n";
        }
        return "";
    }
    public String validarApeNom(String textoVal){
        if (!ValidacionOK(textoVal,"Apellidos/Nombres",3,30,"ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz" + (char)164 + (char)165)) {
            return "Error en Nombres y Apellidos\n";
        }
        return "";
    }
    public String validarFecha(String textoVal){
        if (!FechaOK(textoVal,1900,2025)) {
            return "Error en la fecha de nacimiento\n";
        }
        return "";
    }
    public String validarTelefono(String textoVal){
        if (!ValidacionOK(textoVal,"Telefono",9,9,"0123456789")) {
            return "Error en el telefono\n";
        }
        return "";
    }
    public String validarDireccion(String textoVal){
        if (!ValidacionOK(textoVal,"Direccion",5,30,"ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz.0123456789")) {
            return "Error en la direccion\n";
        }
        return "";
    }
    
    //---------------------------------------------------
    //EXTRAIDO DEL ARCHIVO DE EJEMPLO
    //---------------------------------------------------
    
    private boolean ValidacionOK(String CADENA, String HKGZ,int SIZE1, int SIZE2, String RANGO) {
        int L;
        boolean Sw;
        Sw = false;
        L = CADENA.length();
        if(L>0) {
           if((SIZE1<=L)&&(L<=SIZE2)) {
              if(InRange(CADENA,RANGO)==true) {
                  Sw = true;
              }
              else {
                  if(HKGZ.length()>0) {

                  }
              }
           }
           else {
              if(HKGZ.length()>0) {

              }
           }
        }
        else {
           if(HKGZ.length()>0) {

           }
        }
        return Sw;
    }
    private boolean FechaOK(String FECHA, int MinYear, int MaxYear) {
        boolean Sw;
        String DD,MM,YYYY;
        int P,T,L,YEAR,MONTH,DAY,TOTAL=0;
        L = FECHA.length();
        Sw = false;
        if((8<=L)&&(L<=10)) {
           T = TotalOcurrencias(FECHA,'/');
           P = PosicionIzquierda(FECHA,'/');
           if((T==2)&&(0<P)&&(P<L-6)&&(FECHA.charAt(L-5)=='/')) {
               DD   = FECHA.substring(0,P);
               MM   = FECHA.substring(P+1,L-5);
               YYYY = FECHA.substring(L-4,L);
               if((EsCadenaNumerica(DD)==true)&&
                     (EsCadenaNumerica(MM)==true)&&
                     (EsCadenaNumerica(YYYY)==true)) {
                   YEAR = Integer.parseInt(YYYY);
                   if((MinYear<=YEAR)&&(YEAR<=MaxYear)) {
                       MONTH = Integer.parseInt(MM);
                       if((1<=MONTH)&&(MONTH<=12)) {
                          DAY = Integer.parseInt(DD);
                          if((MONTH==1)||(MONTH==3)||(MONTH==5)||(MONTH==7)||(MONTH==8)||(MONTH==10)||(MONTH==12)) {
                              TOTAL = 31;
                          }
                          else {
                             if((MONTH==4)||(MONTH==6)||(MONTH==9)||(MONTH==11)) {
                                   TOTAL = 30;
                             }
                             else {
                                TOTAL =(((YEAR%4==0)&&(YEAR%100!=0))||((YEAR%400==0)&&(YEAR%100==0))?29:28);
                             }
                          }
                          Sw = ((1<=DAY)&&(DAY<=TOTAL));
                          if(!Sw) {

                          }
                       }

                   }

               }

           }

        }

        return Sw;
    }
    
    private boolean InRange(String CADENA, String RANGO){
        int L,N,k,i;
        char E;
        boolean Sw,Hk;
        L = CADENA.length();
        N = RANGO.length();
        Sw = true;
        k = 0;
        while((k<=L-1)&&(Sw==true)){
            E = CADENA.charAt(k);
            Hk = false;
            i = 0;
            while((i<=N-1)&&(Hk==false)){
                if(RANGO.charAt(i)==E){
                    Hk = true;
                }
                i++;
            }
            Sw = Hk;
            k++;
        }
        return Sw;
    }
    
    private boolean EsCadenaNumerica(String CAD) {
        return InRange(CAD,"0123456789");
    }
    private int TotalOcurrencias(String CADENA, char E) {
        int C,L;
        L = CADENA.length();
        C = 0;
        for(int i=0;i<=L-1;i++) {
            if(CADENA.charAt(i)==E) {
               C = C + 1;
            }
        }
        return C;
    }
    private int PosicionIzquierda(String CADENA, char E) {
        int i,P,L;
        L = CADENA.length();
        P = -1;
        i = 0;
        while((i<=L-1)&&(P==-1)) {
           if(CADENA.charAt(i)==E) {
              P = i;
           }
           i++;
        }
        return P;
    }
}
