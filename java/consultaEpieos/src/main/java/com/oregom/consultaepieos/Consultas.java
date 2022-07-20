package com.oregom.consultaepieos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Consultas extends javax.swing.JFrame implements Runnable {

    WebDriver driver = null;//creamos una variable tipo WebDriver para las conexiones
    Thread hilo; //para agregar los hios
    private boolean continuar = false; //para el bucle que realice la comprobacion

    public Consultas() {
        initComponents();
    }

    /**
     * metodo que permite detener al bucle
     */
    private void detenerHilo() {
        continuar = false;
    }

    /**
     * metodo que comprueba de que la pagina este cargada
     */
    private boolean cargado(WebDriver driver, By by) {
        try {
            driver.findElement(by);//busca el elemento
            detenerHilo(); //detiene el bucle de la comprobación
            return true; //retorna el true 
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * metodo para mostrar la información en el programa
     */
    private void mostrar() {
        File archivo = new File("InformacionObtenida\\Datos.doc"); //crea el archivo nuevo donde se guardará la info
        try {
            if (cargado(driver, By.xpath("//*[@id=\"__next\"]/div[4]/main/div[6]/div/div[2]"))) {
                //this.txtFoto.setText(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div[6]/div/div[2]/div[2]/div[4]/div[1]/div[2]/a")).getText());
                this.txtNombre.setText(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/main/div[6]/div/div[2]/div[2]/div[4]/div[6]/div[2]/div[2]/div[1]/p")).getText());
                this.txtIdentificacion.setText(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div[6]/div/div[2]/div[2]/div[4]/div[5]/div[2]/p")).getText());
                this.txtUltimaActualizacion.setText(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div[6]/div/div[2]/div[2]/div[4]/div[7]/div[2]/p")).getText());
                this.txtServicios.setText(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div[6]/div/div[2]/div[2]/div[4]/div[9]/div[2]")).getText());
                System.err.println("Si existe elemento");

                PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); //creamos el elemento de la clase PrintWriter y permitimos que cada informasion se agregue sin borrar la anterior

                //Datos a guardar en el doc
                String correoInvestigado = txtCorreo.getText();
                String foto = txtFoto.getText(); //guardamos los datos obtenidos de la foto
                String nombre = txtNombre.getText(); //guardamos los datos obtenidos de la foto
                String identificacion = txtIdentificacion.getText(); //guardamos los datos obtenidos de la foto
                String ultimaActualizacion = txtUltimaActualizacion.getText(); //guardamos los datos obtenidos de la foto
                String servicios = txtServicios.getText(); //guardamos los datos obtenidos de la foto
                
                salida.println("Correo Investigado: " + correoInvestigado);
                salida.println("");
                salida.println("");
                salida.println("El enlace a la foto del correo es: " + foto);
                salida.println("Nombre de Usuario: " + nombre);
                salida.println("Número de Identificación: " + identificacion);
                salida.println("Última Actualización: " + ultimaActualizacion);
                salida.println("Servicios utilizados con ese email: " + servicios);
                salida.println("");
                
                
            }
        } catch (Exception e) {
            System.err.println("No existe elemento");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFoto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        txtUltimaActualizacion = new javax.swing.JTextField();
        txtServicios = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultas Epieos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Dirección de Correo:");

        txtCorreo.setBackground(new java.awt.Color(204, 204, 204));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel2.setText("Foto:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Identificación:");

        jLabel5.setText("Última Actualización:");

        jLabel6.setText("Servicios:");

        txtFoto.setBackground(new java.awt.Color(204, 204, 204));

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));

        txtIdentificacion.setBackground(new java.awt.Color(204, 204, 204));

        txtUltimaActualizacion.setBackground(new java.awt.Color(204, 204, 204));

        txtServicios.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addComponent(txtFoto)
                            .addComponent(txtNombre)
                            .addComponent(txtIdentificacion)
                            .addComponent(txtUltimaActualizacion)
                            .addComponent(txtServicios, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUltimaActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        continuar = true;//colocamos el identificador para que inicie la comprobación 
        //Configuramos para utilizar chrome
        String path = "C:\\chromedriver\\chromedriver.exe"; //Ruta del webDriver
        System.setProperty("webdriver.chrome.driver", path);

        //creamos el navegador
        if (driver == null) {
            driver = new ChromeDriver();
        }

        //URL a direccionar
        String url = "https://epieos.com/";
        driver.get(url);

        //para rellenar la caja de busqueda automaticamente
        String correo = txtCorreo.getText().trim(); //obtenenmos el texto de la caja contenedora del correo
        WebElement webElement = driver.findElement(By.id("search-input"));//colocamos el nombre de id extraido de la pagina
        webElement.sendKeys(correo); //completa en la web el correo conforme lo extraido de la app

        WebElement aceptar = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/main/div[8]/form/div[1]/button[2]")); //esto permite precionar el boton buscar
        aceptar.click();//hacer click al boton

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //duerme la busqueda por 3 segundos

        hilo = new Thread(this);
        hilo.start();//inicia el hilo
    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Consultas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtServicios;
    private javax.swing.JTextField txtUltimaActualizacion;
    // End of variables declaration//GEN-END:variables

    /**
     * crea el metodo abstracto de run para realizar las comprobaciones
     */
    @Override
    public void run() {
        System.err.println("Inicio Hilo");
        int contador = 0;
        while (continuar) {
            mostrar();//llamamos al metodo mostrar
            contador++;//aumentamos el contador

            try {
                Thread.sleep(10000); //duermo la comprobacion cada 3 segundos
            } catch (InterruptedException e) {
                if (contador == 5) {
                    this.detenerHilo(); //si luegi de las comprobaciones no lo encuentra se detiene
                }
                System.err.println("Hilo terminado");
            }
        }
    }
}