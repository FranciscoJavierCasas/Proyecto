/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Clases.ControllerEstudiante;
import Clases.Estudiante;
import Conectar.conectar;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static proyecto.InterfazInicio.PanelPrincipal;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Francisco
 */
public class PanelAjustesEstudiante extends javax.swing.JPanel {

    InterfazInicio inicio;
    PanelMonitor p1 = null;
    PanelEstudiante p2 = null;
    PanelRegistrarEstudiante tabla;
    boolean a = true;
    
    public String id;
    private Estudiante cl;
    PreparedStatement ps;
    ResultSet rs;
    
    
    private FileInputStream fis;
    private int longitudBytes;
    private ControllerEstudiante cc;
    private Estudiante c2;
    
    int tipoUsuario = 0;
    private String usuario;
    private String plan;
    private String pass;
    BufferedImage fotoCamara;


    public BufferedImage getFotoCamara() {
        return fotoCamara;
    }

    public void setFotoCamara(BufferedImage fotoCamara) {
        this.fotoCamara = fotoCamara;
    }
    /**
     * Creates new form PanelAjustesEstudiante
     */

    public JLabel getJLFoto() {
        return JLFoto;  
    }

    public void setJLFoto(JLabel JLFoto) {
        this.JLFoto = JLFoto;
    }
    @SuppressWarnings("unchecked")
    public PanelAjustesEstudiante(InterfazInicio n) {
        initComponents();
        inicio = n;
        
//        System.out.println(JLFoto.getWidth());
//        System.out.println(JLFoto.getHeight());


cc = new ControllerEstudiante();
    }
    @SuppressWarnings("unchecked")
    public void configuracion(String usuario, String plan, String pass, int tipoUsuario){
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.plan = plan;
        this. pass = pass;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Image foto = null;
        ImageIcon icon = null;
        java.sql.Connection con = null;
        Blob blob = null;
        ByteArrayOutputStream ouput = null;
        InputStream isdatos = null;
        int temp = 0;

        try{
            
            ps = (PreparedStatement) cn.prepareStatement("SELECT * FROM registro WHERE Codigo = '"+usuario+"' and CodigoPlan = '"+plan+"' and Password ='"+pass+"'");

            rs = ps.executeQuery();
            byte[] image = null;
            if(rs.next()){
               
                JPassword.setText(rs.getString("Password"));
                
                    ouput = new ByteArrayOutputStream();
                    isdatos = rs.getBinaryStream("Foto");
                    if (isdatos != null){
                    temp=isdatos.read();
//                System.out.print(temp);
                    while(temp>=0){
                    ouput.write((char)temp);
                    temp=isdatos.read();
                    }
                
                    foto=Toolkit.getDefaultToolkit().createImage(ouput.toByteArray()).getScaledInstance(133,153, Image.SCALE_DEFAULT);
                    JLFoto.setIcon(new ImageIcon(foto));
                    }
                    else{
                        
                        JLFoto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Usuario.png")));
                    }
        
        } else {
//                JOptionPane.showMessageDialog(null, "No existe una persona con la clave");
            }
            
         } catch (SQLException ex) {
            System.err.println(ex.toString());
        } catch (IOException ex) {
            Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if(con!=null){
                    con.close();
                }
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(ouput!=null){
                    ouput.close();
                }
                if(isdatos!=null){
                    isdatos.close();
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
///////////////////////////////////////////////////////////////////////////////       
    }
    @SuppressWarnings({"unchecked", "empty-statement"})
      public void actualizar(String usuario, String plan, String pass, int tipoUsuario) throws SQLException, IOException{
        this.tipoUsuario = tipoUsuario;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String SQL ="UPDATE registro SET Password = ?, Foto = ? WHERE Codigo = '"+usuario+"' and CodigoPlan = '"+plan+"' and Password = '"+pass+"'" ;

            byte[] imgByte = null;
            ByteArrayOutputStream img = new ByteArrayOutputStream();
             BufferedImage m1 = new BufferedImage(JLFoto.getWidth(),JLFoto.getHeight(),BufferedImage.TYPE_INT_RGB);
             Graphics g = m1.createGraphics();
             JLFoto.getIcon().paintIcon(null, g, 0, 0);
             g.dispose();
            
             ImageIO.write( m1, "png", img);
             img.flush();
             imgByte = img.toByteArray();

            ps = (PreparedStatement) cn.prepareStatement(SQL);
            
            ps.setString(1, String.valueOf(JPassword.getPassword()));
            ps.setBytes(2, imgByte);

            int res = ps.executeUpdate();
            
            if(res > 0){
//                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                            // alerta de mensaje  
                   new rojerusan.RSNotifyAnimated("CORRECTO", "Datos Actualizado", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                  // inicia el panel monitor 

            } else {
//                 JOptionPane.showMessageDialog(null, "Error al actualizar datos");
                   new rojerusan.RSNotifyAnimated("ERROR", "Error al actualizar datos", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);;

            }

        }catch (IOException | SQLException e){
//            System.out.print(fis+" error");
                System.out.print(e.getMessage());
        }
        finally{
            if (fis != null){
                fis.close();
                fis = null;
            }
        }
      }
            
//       
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JLFoto = new javax.swing.JLabel();
        BtnCargarFoto = new javax.swing.JButton();
        BtnCamara = new javax.swing.JButton();
        BtnActualizar2 = new javax.swing.JButton();
        JPassword = new javax.swing.JPasswordField();
        RevelarContraseña = new javax.swing.JButton();
        BtnAtras1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuracion"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Password:");

        JLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cargar-foto.png"))); // NOI18N
        BtnCargarFoto.setBorderPainted(false);
        BtnCargarFoto.setContentAreaFilled(false);
        BtnCargarFoto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cargar-foto_On.png"))); // NOI18N
        BtnCargarFoto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cargar-foto_On.png"))); // NOI18N
        BtnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarFotoActionPerformed(evt);
            }
        });

        BtnCamara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_tomar-foto.png"))); // NOI18N
        BtnCamara.setBorderPainted(false);
        BtnCamara.setContentAreaFilled(false);
        BtnCamara.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_tomar-foto_On.png"))); // NOI18N
        BtnCamara.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_tomar-foto_On.png"))); // NOI18N
        BtnCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCamaraActionPerformed(evt);
            }
        });

        BtnActualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_actualizar.png"))); // NOI18N
        BtnActualizar2.setBorderPainted(false);
        BtnActualizar2.setContentAreaFilled(false);
        BtnActualizar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_actualizar_on.png"))); // NOI18N
        BtnActualizar2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_actualizar_on.png"))); // NOI18N
        BtnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar2ActionPerformed(evt);
            }
        });

        RevelarContraseña.setText("jButton1");
        RevelarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevelarContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RevelarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(BtnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCargarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RevelarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 350, 380));

        BtnAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_atras.png"))); // NOI18N
        BtnAtras1.setBorderPainted(false);
        BtnAtras1.setContentAreaFilled(false);
        BtnAtras1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_atras_on.png"))); // NOI18N
        BtnAtras1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_atras_on.png"))); // NOI18N
        BtnAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtras1ActionPerformed(evt);
            }
        });
        add(BtnAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 160, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtras1ActionPerformed
        if(tipoUsuario ==1){
            p1 = new PanelMonitor(inicio);
            p1.setSize(1090, 1000);//tamaño del Jpanel
            p1.setLocation(5, 5); // posicion del panel principal
            PanelPrincipal.removeAll();
            PanelPrincipal.add(p1, BorderLayout.CENTER);
            PanelPrincipal.revalidate();
            PanelPrincipal.repaint();
        } else{
            p2 = new PanelEstudiante(inicio);
            p2.setSize(1090, 1000);//tamaño del Jpanel
            p2.setLocation(5, 5); // posicion del panel principal
            PanelPrincipal.removeAll();
            PanelPrincipal.add(p2, BorderLayout.CENTER);
            PanelPrincipal.revalidate();
            PanelPrincipal.repaint();
        }
    }//GEN-LAST:event_BtnAtras1ActionPerformed
    @SuppressWarnings("unchecked")
    private void BtnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar2ActionPerformed
        try {

actualizar(usuario, plan, pass, tipoUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicio.CargarFoto(usuario, plan, pass);


    }//GEN-LAST:event_BtnActualizar2ActionPerformed
    @SuppressWarnings("unchecked")
    private void BtnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);       
        int estado = se.showOpenDialog(null);
        if(estado == JFileChooser.APPROVE_OPTION)
        {
            try {
                
                
                
                fis =  new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int)se.getSelectedFile().length();
                
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(JLFoto.getWidth(), 
                        JLFoto.getHeight(), Image.SCALE_DEFAULT);
                
                JLFoto.setIcon(new ImageIcon(icono));
                JLFoto.updateUI(); 
                
            } catch (FileNotFoundException ex) {ex.printStackTrace();}
            catch (IOException ex){ex.printStackTrace();}
        }
       
    }//GEN-LAST:event_BtnCargarFotoActionPerformed
    @SuppressWarnings("unchecked")
    private void RevelarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevelarContraseñaActionPerformed
        // TODO add your handling code here:

        if(a){
            JPassword.setEchoChar((char)0);
            a = false;
        }
        else{
            a = true;
            JPassword.setEchoChar(('*'));
        }
    }//GEN-LAST:event_RevelarContraseñaActionPerformed
    @SuppressWarnings("unchecked")
    private void BtnCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCamaraActionPerformed
        // TODO add your handling code here:
        InterfazWebCam interfazwebcam = new InterfazWebCam(this);
        interfazwebcam.setVisible(true);
        
    }//GEN-LAST:event_BtnCamaraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar2;
    private javax.swing.JButton BtnAtras1;
    private javax.swing.JButton BtnCamara;
    private javax.swing.JButton BtnCargarFoto;
    private javax.swing.JLabel JLFoto;
    private javax.swing.JPasswordField JPassword;
    private javax.swing.JButton RevelarContraseña;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
conectar cc2= new conectar();
java.sql.Connection cn= cc2.conexion();


}