
package tareadepoo;

import com.formdev.flatlaf.FlatDarculaLaf;
import ejercicioavanzado.GESTION_PERSONAL;
import javax.swing.UIManager;

public class TareaDePOO {

    public static void main(String[] args) {
        gestion();
    }
    
    public static void gestion(){
        GESTION_PERSONAL hola= new GESTION_PERSONAL();
    }
     public static void ventana(){
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        }catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        UIManager.put( "Button.arc", 17 );
        UIManager.put( "Component.arc", 17 );
        UIManager.put( "ProgressBar.arc", 17 );
        UIManager.put( "TextComponent.arc", 17 );
        Principal princ = new Principal();
        princ.setVisible(true);
    }
}
