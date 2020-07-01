/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


import Conectar.conectar;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Francisco
 */

public final class InterfazSesion extends javax.swing.JFrame {
     private boolean minimiza;
     public static String HoraInicio;
     public static String Codigo;
     public static String CodigoPlan;
     public static String Nombre;
     public static String Apellido;
     public static String Tipo;
     
     InterfazInicio inicio;
     String tiempo = "";
     int x, y;
    /**
     * Creates new form InterfazSesion
     * @param n
     */
  
    public InterfazSesion(InterfazInicio n) {
        initComponents();
        this.setResizable(false);
//        iniciar(n);
        inicio = n;
        // Capturo el valor de TxtUsuario, de la InterfazInicio
        LblNombres.setText(Nombre+" "+Apellido);
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
        
        pc();
        sala();
       
    }
    
//    private void iniciar(InterfazInicio n){
//
//        
//    }

   @SuppressWarnings("unchecked")
    class horas implements ActionListener{
        @SuppressWarnings("unchecked")
        @Override
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
    private final ActionListener acciones = new ActionListener(){
        @SuppressWarnings("unchecked")
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
@SuppressWarnings("unchecked")    
@Override
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
@SuppressWarnings("unchecked")
void guardar(){
            String ins=("INSERT INTO reportes (codigo, plan, nombre, apellido, horainicio, horafinal, "
                    + "fecha, tiempo, sala, pc, tipousuario) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        try {
            PreparedStatement pst = cn.prepareStatement(ins);
            pst.setString(1, Codigo);
            pst.setString(2, CodigoPlan);
            pst.setString(3, Nombre);
            pst.setString(4, Apellido);
            pst.setString(5, HoraInicio);
            pst.setString(6, hora.getText());
            pst.setString(7, fecha.getText());
            pst.setString(8, EtiquetaTiempo.getText());
            pst.setString(9, LblSala.getText());
            pst.setString(10, LblComputador.getText());
            pst.setString(11, Tipo);
            pst.executeUpdate();
            
           
        } catch (SQLException e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(this,"No se encuentra ningun dato");
        }
    
}
    @SuppressWarnings("unchecked")  
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
     public void pc() {
        File archivo = new File (".\\NumeroPC.txt");
        try{
        
        BufferedReader leer = new BufferedReader(new FileReader(archivo));
        String linea = leer.readLine();
        
        while (linea != null){           
            LblComputador.setText(linea);
            linea = leer.readLine();
            
        }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void sala(){
         
        File archivo = new File (".\\NumeroSala.txt");
        try{
        BufferedReader leer = new BufferedReader(new FileReader(archivo));
        String linea = leer.readLine();
        
        while (linea != null){           
            LblSala.setText(linea);
            linea = leer.readLine();
            
        }
        } catch (Exception ex){
            ex.printStackTrace();
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

        rSPanelShadow1 = new necesario.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        LblNombres = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EtiquetaTiempo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LblSala = new javax.swing.JLabel();
        LblComputador = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BtnMinimizar = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelShadow1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                rSPanelShadow1MouseDragged(evt);
            }
        });
        rSPanelShadow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rSPanelShadow1MousePressed(evt);
            }
        });
        rSPanelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LblNombres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(LblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bienvenido");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        hora.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 59, 100, 21));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 47, 21));

        fecha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, 100, 21));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tiempo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 111, 47, -1));

        EtiquetaTiempo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        EtiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtiquetaTiempo.setText("00:00:00");
        jPanel1.add(EtiquetaTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 111, 100, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("N° de Sala:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 80, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("N° de computador:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 85, -1, -1));

        LblSala.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LblSala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSala.setText("1");
        jPanel1.add(LblSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 20, -1));

        LblComputador.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LblComputador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblComputador.setText("1");
        jPanel1.add(LblComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 85, 20, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Hora:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 40, -1));

        BtnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/minimizar_ventana.png"))); // NOI18N
        BtnMinimizar.setBorderPainted(false);
        BtnMinimizar.setContentAreaFilled(false);
        BtnMinimizar.setFocusable(false);
        BtnMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/minimizar_ventana_on.png"))); // NOI18N
        BtnMinimizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/minimizar_ventana_on.png"))); // NOI18N
        BtnMinimizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/minimizar_ventana_on.png"))); // NOI18N
        BtnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 0, 27, 27));

        BtnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cerrar_sesion.png"))); // NOI18N
        BtnCerrarSesion.setBorderPainted(false);
        BtnCerrarSesion.setContentAreaFilled(false);
        BtnCerrarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cerrar_sesion_on.png"))); // NOI18N
        BtnCerrarSesion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cerrar_sesion_on.png"))); // NOI18N
        BtnCerrarSesion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cerrar_sesion_on.png"))); // NOI18N
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 160, 40));

        rSPanelShadow1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 7, 313, 200));
        jPanel1.getAccessibleContext().setAccessibleName("");

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSPanelShadow1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelShadow1MouseDragged
        // TODO add your handling code here:
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_rSPanelShadow1MouseDragged

    private void rSPanelShadow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelShadow1MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_rSPanelShadow1MousePressed

    private void BtnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMinimizarActionPerformed
        // TODO add your handling code here:
                this.setExtendedState(ICONIFIED);
        if (!minimiza) {
            minimiza = false;
        } else {
            minimiza = true;
        }
    }//GEN-LAST:event_BtnMinimizarActionPerformed

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
    private javax.swing.JButton BtnMinimizar;
    private javax.swing.JLabel EtiquetaTiempo;
    private javax.swing.JLabel LblComputador;
    private javax.swing.JLabel LblNombres;
    private javax.swing.JLabel LblSala;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private necesario.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
Connection cn = cc.conexion();
}

