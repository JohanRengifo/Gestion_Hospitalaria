/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import funciones.DBManager;
import funciones.ReportService;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Analisis;

public class PacienteVentana extends javax.swing.JFrame {

    public PacienteVentana() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        consultarButton = new javax.swing.JButton();
        ExpAnalisisbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Paciente");

        consultarButton.setText("Ver mis Analizis");
        consultarButton.setActionCommand("Ver Analisis");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });

        ExpAnalisisbtn.setText("Exportar Analisis");
        ExpAnalisisbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpAnalisisbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consultarButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ExpAnalisisbtn)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarButton)
                    .addComponent(ExpAnalisisbtn))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        String idPacienteStr = JOptionPane.showInputDialog(this, "Ingrese su número de ID de paciente:");
        try {
            // Convertir el ID del paciente a entero
            int idPaciente = Integer.parseInt(idPacienteStr);

            // Consultar en la base de datos si existe el paciente con el ID proporcionado
            List<Analisis> analisisPaciente = DBManager.obtenerAnalisisPaciente(idPaciente);

            if (!analisisPaciente.isEmpty()) {
                // Mostrar los análisis en una nueva ventana
                ConsultaAnalisisPaciente consultaAnalisisPaciente = new ConsultaAnalisisPaciente(idPaciente);
                consultaAnalisisPaciente.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "El número de ID de paciente ingresado no tiene análisis asociados.", "No Hay Análisis", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para el ID de paciente.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void ExpAnalisisbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpAnalisisbtnActionPerformed
        // Solicitar al usuario el número de ID de paciente
        String idPacienteStr = JOptionPane.showInputDialog(this, "Ingrese su número de ID de paciente:");

        try {
            if (idPacienteStr != null && !idPacienteStr.isEmpty()) { // Validar que el campo no esté vacío
                // Convertir el ID del paciente a entero
                int idPaciente = Integer.parseInt(idPacienteStr);

                // Consultar en la base de datos si existe el paciente con el ID proporcionado
                List<Analisis> analisisPaciente = DBManager.obtenerAnalisisPaciente(idPaciente);

                if (!analisisPaciente.isEmpty()) {
                    // Solicitar la carpeta de salida para el informe PDF
                    JFileChooser chooser = new JFileChooser();
                    chooser.setDialogTitle("Seleccionar Carpeta de Salida");
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    int result = chooser.showOpenDialog(this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        // Obtener la carpeta seleccionada
                        File selectedFolder = chooser.getSelectedFile();
                        String carpetaSalida = selectedFolder.getAbsolutePath();

                        // Generar el informe PDF
                        ReportService.generarInformeAnalisis(analisisPaciente, carpetaSalida);
                        JOptionPane.showMessageDialog(this, "Informe de análisis generado correctamente.", "Informe Generado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El número de ID de paciente ingresado no tiene análisis asociados.", "No Hay Análisis", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un número de ID de paciente válido.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para el ID de paciente.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ExpAnalisisbtnActionPerformed

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
            java.util.logging.Logger.getLogger(PacienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacienteVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExpAnalisisbtn;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
