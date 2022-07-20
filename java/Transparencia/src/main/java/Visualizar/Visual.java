/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizar;

import Clases.Resul;
import Clases.Ver_Pagina;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;
import org.jsoup.*;
import org.jsoup.nodes.Document;



/**
 *
 * Creamos un nuevo formulario Visual
 */
public class Visual extends javax.swing.JFrame {

    /**
     * creamos un arrayList que guardará todos los datos de las consultas
     */
    String valor = null;
    ArrayList<Resul> ar = new ArrayList<Resul>();
    
    public Visual() {
        initComponents();
        recargaCaptcha();
    }
    
    /**
     * Funcion recargaCaptcha
     * permite integrar al programa un captcha para verificar 
     * que no se utilizará por bots
     */
    public void recargaCaptcha(){
        try{//conectamos con la pagina //http://www.sanciones.gob.pe:8081/transparencia/securimage/securimage_show.php (enlace original de la pagina)
            Connection.Response res = Jsoup.connect("https://www.hscripts.com/es/scripts/php/HMCI/captcha.php") //Response solo obtiene la info de la imagen
                    .ignoreContentType(true) //ignora el contenido y va directo a la imagen y a la cookie
                    .method(Connection.Method.GET) //obtenemos el metodo tiene que ser el mismo que el de la pagina 
                    .execute(); //lo ejecutamos
            valor = res.cookie("PHPSESSID"); //acá guardamos la informacion obtenida de la cooki (entre las comillas va el nombre de la cookie)
            ImageIcon imagen = new ImageIcon(ImageIO.read(new ByteArrayInputStream(res.bodyAsBytes())));
            lblimagen.setIcon(imagen);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Función Consulta
     * Creamos una función que se activa cuando precionamos el botón consultar
     * y extrae la información de la consulta
     */
    public void consulta(){
     ar.clear();//borra los datos del arraylist
        String dni = txtdni.getText().trim(); //lee los cuagros de texto y almacena su información 
        String captcha = txtdni.getText().trim(); //trim borra los espacios vacios   
    
    try{//realizamos la conexion
        Document document = Jsoup.connect("http://www.sanciones.gob.pe:8081/transparencia/grilla_trabajadores.php?tipoc=190&numc="+dni+"&opc=b&brujos="+captcha) //Document permite leer el documento jml (head body table foot)
            .cookie("PHPSESSID",valor).get(); //obtenemos la misma cookie del captcha para utilizarlo
        
        for(org.jsoup.nodes.Element input: document.getElementsByTag("td")){ //recoremos toda la tabla y obtenemos la info de cada columna
            Resul r = new Resul();//creamos un objeto de la clase Resul que es donde se guardará el contenido.
            r.setTexto(input.text()); //agrega el texto
            ar.add(r);//agregamos al array
        } 
        Ver_Pagina vp = new Ver_Pagina(); //creamos el opjeto de la clase Ver_Pagina
        vp.visualizar(tabla, ar);

    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    }

    //Metodos utilitarios
    public void limpiar_tabla() {
        try {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                tb.removeRow(tb.getRowCount() - 1);//borra todos los datos de la tabla
            }
            //cargaTicket();
        } catch (Exception ex) {
            System.out.println("TablaBorrar " + ex.getMessage());
        }
    }

    /**
     * Esta función permite borrar todo el contenido del formulario
     */
    public void limpiar_caja() {
        txtdni.setText("");
        txtcapcha.setText("");
    }

    /**
     * Este método se llama desde dentro del constructor para inicializar el formulario. 
     * ADVERTENCIA: NO modifique este código. El contenido de este método siempre 
     * es regenerado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcapcha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblimagen = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Nacional de Sanciones contra Servidores Civiles");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "A. Paterno", "A. Materno", "Institución", "T. Sanción", "Categoría", "Estado"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jLabel3.setText("* Hacer clic en cada fila para leer el texto");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Nombre: ");

        txtdni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setText("Apellido");

        txtcapcha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblimagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcapcha, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 120, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtcapcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        limpiar_tabla(); //para borrar todo el contenido
        consulta(); //para extraer los datos
        recargaCaptcha();//para volver a consultar
        limpiar_caja();
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

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
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtcapcha;
    private javax.swing.JTextField txtdni;
    // End of variables declaration//GEN-END:variables
}
