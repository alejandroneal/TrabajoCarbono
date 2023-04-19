/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daw;

import com.fasterxml.jackson.core.JsonProcessingException;
import conexion_http.ConexionHTTP;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelos.Carbono;
import serviciojson.JsonService;

/**
 *
 * Enlaces para probar:
 * -Normal: www.riverford.co.uk/
 * -Bueno: rights4children.org.uk/
 * -Mal: maralboran.eu
 */
public class Panel extends javax.swing.JFrame {

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        setResizable(false);
        setTitle("Medidor de huella de carbono");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        botonBusqueda = new javax.swing.JButton();
        textoRuta = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        labelGif = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 216, 211));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonBusqueda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonBusqueda.setText("Buscar");
        botonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBusquedaActionPerformed(evt);
            }
        });
        panelPrincipal.add(botonBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 87, 36));

        textoRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRutaActionPerformed(evt);
            }
        });
        panelPrincipal.add(textoRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 427, 36));

        labelTitulo.setFont(new java.awt.Font("Chilanka", 1, 28)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(102, 102, 102));
        labelTitulo.setText("MEDIDOR DE HUELLA DE CARBONO");
        panelPrincipal.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 520, 52));

        labelGif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/picasion.com_a0e15f751bcae3afd3bf6747bef17e1b.gif"))); // NOI18N
        panelPrincipal.add(labelGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 6, -1, 184));

        labelTexto.setFont(new java.awt.Font("Chilanka", 0, 22)); // NOI18N
        labelTexto.setForeground(new java.awt.Color(102, 102, 102));
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTexto.setText("<html> <p>Las busquedas en internet requieren de </p> <p>cierta energía y algunas de ellas consumen <p> mucha, lo que genera contaminación.</p> <p>Inserta el enlace de una página y te  </p> <p>mostraremos la huella de carbono que</p> <p>deja tu búsqueda.</p> </html> ");
        panelPrincipal.add(labelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 75, 695, 197));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        panelPrincipal.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBusquedaActionPerformed

        final String LINK = "https://api.websitecarbon.com/site?url=";
        final String LINK2 = "https://api.websitecarbon.com/site?url=www.";
        //El texto que introduce el usuario en el text field
        String ruta = this.textoRuta.getText();
        String ultimo;
        
        if (ruta.substring(0, 4).equals("www.")) {
            //Si el texto escrito en el text field empieza por www. utiliza el link que no tiene
            //www.
            ultimo = LINK + ruta;
        } else {
            //Si el texto introducido no empieza por www. se usa el link que si tiene www.
            ultimo = LINK2 + ruta;
        }

        String http = null;
        try {
            //Guarda en el string el contenido de la página web introducida que tiene 
            //formato json
            http = ConexionHTTP.peticionHttpGet(ultimo);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //json obtenido del enlace anterior
            Carbono carbono = (Carbono) JsonService.stringToPojo(http, Carbono.class);
            //Método que modifica el panel según el resultado del json
            modificarPanel(carbono, ruta);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonBusquedaActionPerformed

    private void modificarPanel(Carbono carbono, String ruta){
        
        // Variables de cada imagen 
        ImageIcon imagenMalo = new ImageIcon("src/main/resources/img/nubePrueba.png");
        ImageIcon fondoMalo = new ImageIcon("src/main/resources/img/fondoMalo.png");
        ImageIcon imagenNormal = new ImageIcon(".png");
        ImageIcon fondoNormal = new ImageIcon("src/main/resources/img/fondoNormal.png");
        ImageIcon imagenBueno = new ImageIcon(".png");
        ImageIcon fondoBueno = new ImageIcon("src/main/resources/img/fondoBueno.png");
        
        if (carbono.getCleanerThan() <= 0.33) {
                // Esto significa que es malo
                //Cambio del fondo y de la imagen del panel
                labelGif.setIcon(imagenMalo);
                labelFondo.setIcon(fondoMalo);
                
                //Redondeo de los gramos emitidos por la búsqueda
                double redondeo = (double)(Math.round(carbono.getStatistics().getCo2().getGrid().getGrams()*100))/100;
                // StringBuilder para cambiar el mensaje de texto del labelTexto
                StringBuilder sb = new StringBuilder();
                sb.append("<html><body>");
                sb.append(ruta);
                sb.append("<br>Está página contamina más que el ");
                sb.append(100 - carbono.getCleanerThan()*100);
                sb.append("% que el resto de páginas testeadas<br>");
                sb.append("En esta página se ha consumido: <br>");
                sb.append(redondeo);
                sb.append(" gramos de CO2<br>");
                sb.append("<span style='color: red;'>Esta página contamina más que el resto</span>");
                sb.append("</body></html>");
                
                labelTexto.setText(sb.toString());
                
            } else if (carbono.getCleanerThan() > 0.33 && carbono.getCleanerThan() <= 0.66) {
                // Esto significa que es normal
                //Cambio del fondo y de la imagen del panel
                labelFondo.setIcon(fondoNormal);
                
                //Redondeo de los gramos emitidos por la búsqueda
                double redondeo = (double)(Math.round(carbono.getStatistics().getCo2().getGrid().getGrams()*100))/100;
                // StringBuilder para cambiar el mensaje de texto del labelTexto
                StringBuilder sb = new StringBuilder();
                sb.append("<html><body>");
                sb.append(ruta);
                sb.append("<br>Está página contamina más que el ");
                sb.append(100 - carbono.getCleanerThan()*100);
                sb.append("% que el resto de páginas testeadas<br>");
                sb.append("En esta página se ha consumido: <br>");
                sb.append(redondeo);
                sb.append(" gramos de CO2<br>");
                sb.append("<span style='color: green;'>Esta página contamina igual que el resto</span>");
                sb.append("</body></html>");
                
                labelTexto.setText(sb.toString());
                
                
            } else {
                // Esto significa que está bueno
                labelFondo.setIcon(fondoBueno);
                
                 //Redondeo de los gramos emitidos por la búsqueda
                double redondeo = (double)(Math.round(carbono.getStatistics().getCo2().getGrid().getGrams()*100))/100;
                // StringBuilder para cambiar el mensaje de texto del labelTexto
                StringBuilder sb = new StringBuilder();
                sb.append("<html><body>");
                sb.append(ruta);
                sb.append("<br>Está página contamina más que el ");
                sb.append(100 - carbono.getCleanerThan()*100);
                sb.append("% que el resto de páginas testeadas<br>");
                sb.append("En esta página se ha consumido: <br>");
                sb.append(redondeo);
                sb.append(" gramos de CO2<br>");
                sb.append("<span style='color: green;'>Esta página contamina muy poco comparado con el restol</span>");
                sb.append("</body></html>");
                
                labelTexto.setText(sb.toString());
            }
    }
    
    private void textoRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRutaActionPerformed

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBusqueda;
    private javax.swing.JLabel labelFondo;
    public static javax.swing.JLabel labelGif;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField textoRuta;
    // End of variables declaration//GEN-END:variables
}
