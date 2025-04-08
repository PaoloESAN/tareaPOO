/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareadepoo;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author USUARIO
 */
public class Listado extends javax.swing.JFrame {

    private Principal principal;
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    DefaultTableModel modeloAlum;
    DefaultTableModel modeloDoc;
            
    /**
     * Creates new form Listado
     */
    public Listado() {
        initComponents();
        modeloAlum = (DefaultTableModel) tablaAlum.getModel();
        modeloDoc = (DefaultTableModel) tablaDoc.getModel();
        jScrollPane2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlum = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDoc = new javax.swing.JTable();
        radAlum = new javax.swing.JRadioButton();
        radDocen = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Listado de personas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 223, -1));

        tablaAlum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Apellidos y nombres", "Fecha de nacimiento", "Telefono", "Direccion", "Sexo"
            }
        ));
        jScrollPane1.setViewportView(tablaAlum);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 810, 240));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, -1));

        tablaDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Apellidos y nombres", "Fecha de nacimiento", "Telefono", "Direccion", "Sexo", "Profesion"
            }
        ));
        jScrollPane2.setViewportView(tablaDoc);
        if (tablaDoc.getColumnModel().getColumnCount() > 0) {
            tablaDoc.getColumnModel().getColumn(6).setHeaderValue("Profesion");
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 810, 240));

        buttonGroup1.add(radAlum);
        radAlum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radAlum.setSelected(true);
        radAlum.setText("Alumno");
        radAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radAlumActionPerformed(evt);
            }
        });
        getContentPane().add(radAlum, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        buttonGroup1.add(radDocen);
        radDocen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radDocen.setText("Docente");
        radDocen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radDocenActionPerformed(evt);
            }
        });
        getContentPane().add(radDocen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void radAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radAlumActionPerformed
        if (radAlum.isSelected()) {
            jScrollPane2.setVisible(false);
            jScrollPane1.setVisible(true);
        }
    }//GEN-LAST:event_radAlumActionPerformed

    private void radDocenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radDocenActionPerformed
        if (radDocen.isSelected()) {
            jScrollPane1.setVisible(false);
            jScrollPane2.setVisible(true);
        }
    }//GEN-LAST:event_radDocenActionPerformed
    public void rellenarAmbas(){
        modeloAlum.setRowCount(0);
        modeloDoc.setRowCount(0);
        rellenarTabla("alumnos.json");
        rellenarTabla("docentes.json");
    }
    
    private void rellenarTabla(String ruta){
            
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            return;
        }
        
        try {
            String jsonStr = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(ruta)));

            JSONArray arreglo = new JSONArray(jsonStr);

            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject persona = arreglo.getJSONObject(i);
                String nombre = persona.getString("dni");
                String apellidosNombres = persona.getString("apellidosNombres");
                String ciudad = persona.getString("fechaNacimiento");
                String telefono = persona.getString("telefono");
                String direccion = persona.getString("direccion");
                String sexo = persona.getString("sexo");
                if(ruta.equals("docentes.json")){
                    String profesion = persona.getString("profesion");
                    modeloDoc.addRow(new Object[]{nombre, apellidosNombres, ciudad,telefono,direccion,sexo,profesion});
                }else{
                    modeloAlum.addRow(new Object[]{nombre, apellidosNombres, ciudad,telefono,direccion,sexo});
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el JSON");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radAlum;
    private javax.swing.JRadioButton radDocen;
    private javax.swing.JTable tablaAlum;
    private javax.swing.JTable tablaDoc;
    // End of variables declaration//GEN-END:variables
}
