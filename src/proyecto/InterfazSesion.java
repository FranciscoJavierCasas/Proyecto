/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


import Conectar.conectar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Francisco
 */
public class InterfazSesion extends javax.swing.JFrame {
     public static String Usuario;
     InterfazInicio inicio;
     String tiempo = "";

    /**
     * Creates new form InterfazSesion
     * @param n
     */
  
    public InterfazSesion(InterfazInicio n) {
        initComponents();
        this.setResizable(false);
        iniciar(n);
       
    }

    private void iniciar(InterfazInicio n){
        inicio = n;
        // Capturo el valor de TxtUsuario, de la InterfazInicio
        LblUsuario.setText(Usuario);
        //CRONOMETRO
        t = new Timer(1000, acciones);
        t.start();
        
         //FECHA DEL SISTEMA
        Date sistFecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));
       
        //HORA DEL SISTEMA
        Timer tiempo=new Timer(100, new InterfazSesion.horas());
        tiempo.start();
    }

   
    class horas implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
            Date sistHora=new Date();
            String pmAm="hh:mm:ss a";
            SimpleDateFormat format=new SimpleDateFormat(pmAm);
            Calendar hoy=Calendar.getInstance();
            hora.setText(String.format(format.format(sistHora),hoy));
            
                  
        }
    }
    //VARIABLES DE CRONOMETRO
    private Timer t;
    private int h, m, s, cs;
    private ActionListener acciones = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {
            ++s;
            if(s==60) 
            {
                s = 0;
                ++m;
            }
            if(m==60)
            {
                m = 0;
                ++h;
            }

            actualizarLabel();   
        }
    };
    
class hiloEspera extends Thread{
public void run(){
int segundosRestantes= 10;

while(segundosRestantes> 0){
    JOptionPane.showMessageDialog(null,"Le quedan faltando 15 minutos");
    try {
        //codigo para mostrar los segundos restantes
        Thread.sleep(1000);//esperamos segundo
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
   
//        Logger.getLogger(Dialogo.class.getName()).log(Level.SEVERE, null, ex);
    }
 
}
}
void guardar(){
            String ins=("INSERT INTO reportes (Usuario, HoraInicio, Fecha, Tiempo) VALUES(?,?,?,?)");
        try {
            PreparedStatement pst = cn.prepareStatement(ins);
            pst.setString(1, LblUsuario.getText());
            pst.setString(2, hora.getText());
            pst.setString(3, fecha.getText());
            pst.setString(4, EtiquetaTiempo.getText());
            pst.executeUpdate();
            
           
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this,"No se encuentra ningun dato");
        }
    
}
   
    private void actualizarLabel() {
        try{
        tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s;
        switch(tiempo){
            case "00:45:00": 
                new rojerusan.RSNotifyAnimated("WARNING", "Le quedan 15 minutos", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);

                break;
            case "00:50:00":
                  new rojerusan.RSNotifyAnimated("WARNING", "Le quedan 10 minutos", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                                
            break;
            case "00:55:00":
                new rojerusan.RSNotifyAnimated("WARNING", "Le quedan 5 minutos", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                
            break;
            case "00:60:00":
            guardar();
            dispose();
            inicio.setVisible(true);
            new rojerusan.RSNotifyAnimated("", "Sesion Cerrada", 
                    5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
             
             break;
        }
        EtiquetaTiempo.setText(tiempo);
        }catch(Exception e){
            
             String t =(h<=9?"0":"")+h+":"+(m<=9?"1":"")+m+":"+(s<=9?"0":"")+s;
             JOptionPane.showMessageDialog(null,"te hace falta"+e);
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
        jLabel2 = new javax.swing.JLabel();
        BtnCerrarSesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        EtiquetaTiempo = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hora de Inicio:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Tiempo:");

        BtnCerrarSesion.setText("Cerrar Sesion");
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        LblUsuario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        EtiquetaTiempo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        EtiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtiquetaTiempo.setText("00:00:00");

        hora.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Fecha:");

        fecha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EtiquetaTiempo))
                .addGap(18, 18, 18)
                .addComponent(BtnCerrarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        // TODO add your handling code here:
       guardar(); 
       inicio.setVisible(true);
       dispose();
       
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InterfazSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InterfazSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InterfazSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InterfazSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InterfazSesion().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JLabel EtiquetaTiempo;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
Connection cn = cc.conexion();
}

