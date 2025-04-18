
package tareadepoo;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.UIManager;



/*  Adaptar la solución anterior para el caso de una Universidad que admite dos tipos de entidades o clases: 
    TAlumno y TDocente.
    Implementar una solución visual usando controles SWING*/


public class TareaDePOO {

    public static void main(String[] args) {
        ventana();
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
