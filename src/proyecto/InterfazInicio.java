/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.*;
import Clases.CustomImageIcon;
import Conectar.conectar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Francisco
 */
public class InterfazInicio extends javax.swing.JFrame {
    int tipoUsuario = 0;
    int clave = 0;
    int tipoDocente = 0;
    int claveDocente =0;
    
    
    public int getClave() {
        return clave;
    }
    public int getClaveDocente(){
        return claveDocente;
    }

    public PanelAjustesEstudiante getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(PanelAjustesEstudiante configuracion) {
        this.configuracion = configuracion;
    }
    PanelAjustesEstudiante configuracion = null;

    
    public PanelAjustesDocente getConfiguracionDocente() {
        return configuracionDocente;
    }

    public void setConfiguracion(PanelAjustesDocente configuracionDocente) {
        this.configuracionDocente = configuracionDocente;
    }
    PanelAjustesDocente configuracionDocente = null;

    
    /**
     * Creates new form InterfazInicio
     */
    public InterfazInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
//        this.setAlwaysOnTop(true);//siempre al frente 
        this.setDefaultCloseOperation( DO_NOTHING_ON_CLOSE  );//evita cerra jframe con ALT+C
      //nueva instancia de jBlocked pasando como parametros e este JFrame 
//        new jBlocked(this).block();
        configuracion = new PanelAjustesEstudiante(this);   
        configuracionDocente = new PanelAjustesDocente(this);
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/Usuario.png")));

        //jPanel1.setVisible(false);
        TxtUsuario.requestFocus();
        JLCerrarSesion.setVisible(false);
    }

    void Limpiar(){
        TxtUsuario.setText("");
        JpContra.setText("");
    }
    void Bloquear (){
        TxtUsuario.setEnabled(false);
        JpContra.setEnabled(false);
    }
    void Desbloquear(){
        TxtUsuario.setEnabled(true);
        JpContra.setEnabled(true);
    }
    void BotonBloquear(){
        BtnEntrar.setEnabled(false);
        BtnCancelar.setEnabled(false);
    }
    void BotonDesbloquear(){
        BtnEntrar.setEnabled(true);
        BtnCancelar.setEnabled(true);
    }
    void CerrarSesionFoto(){
        JLCerrarSesion.setVisible(false);
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/Usuario.png")));

    }
    void ocultar(String usuario, String plan, String pass){
        String cap = "";
        String sql = "SELECT * FROM registro WHERE Codigo = '"+usuario+"' and "+"CodigoPlan = '"+plan+"' "
                + "and Password = '"+pass+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("TipoUsuario");
//                clave = rs.getInt("IdEstudiante");
            }
        
                    if(cap.equals("Monitor"))
                     {
                     jLabel1.setVisible(false);
                     jLabel4.setVisible(false);
                     TxtUsuario.setVisible(false);
                     jSeparator2.setVisible(false);
                     jLabel2.setVisible(false);
                     jLabel5.setVisible(false);
                     JpContra.setVisible(false);
                     jSeparator1.setVisible(false);
                     JLCerrarSesion.setVisible(false);
                     BtnEntrar.setVisible(false);
                     BtnCancelar.setVisible(false);
//                     tipoUsuario = 1;
                    }
                     if(cap.equals("Estudiante"))
                    {
                     jLabel1.setVisible(false);
                     jLabel4.setVisible(false);
                     TxtUsuario.setVisible(false);
                     jSeparator2.setVisible(false);
                     jLabel2.setVisible(false);
                     jLabel5.setVisible(false);
                     JpContra.setVisible(false);
                     jSeparator1.setVisible(false);
                     JLCerrarSesion.setVisible(false);
                     BtnEntrar.setVisible(false);
                     BtnCancelar.setVisible(false);
//                     tipoUsuario = 0;
                    }
                if((!cap.equals("Monitor"))&& (!cap.equals("Estudiante")))
                    {
                    //alerta de mensaje  
//                    JOptionPane.showMessageDialog(null, "Error");

                   //inicia el panel monitor  
                    Limpiar();

                    }
                } catch (SQLException ex) {
            Logger.getLogger(InterfazInicio.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    void ocultarDocente(String usuario2, String pass2){
        String cap = "";
        String sql="SELECT * FROM docente WHERE Nombres='"+usuario2+"' and Password='"+pass2+"'";
        try{
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("TipoUsuario");
//                clave = rs.getInt("IdEstudiante");
            }
        
                    if(cap.equals("Docente"))
                     {
                     jLabel1.setVisible(false);
                     jLabel4.setVisible(false);
                     TxtUsuario.setVisible(false);
                     jSeparator2.setVisible(false);
                     jLabel2.setVisible(false);
                     jLabel5.setVisible(false);
                     JpContra.setVisible(false);
                     jSeparator1.setVisible(false);
                     JLCerrarSesion.setVisible(false);
                     BtnEntrar.setVisible(false);
                     BtnCancelar.setVisible(false);
//                     tipoUsuario = 1;
                    }
                     if(cap.equals("Invitado"))
                    {
                     jLabel1.setVisible(false);
                     jLabel4.setVisible(false);
                     TxtUsuario.setVisible(false);
                     jSeparator2.setVisible(false);
                     jLabel2.setVisible(false);
                     jLabel5.setVisible(false);
                     JpContra.setVisible(false);
                     jSeparator1.setVisible(false);
                     JLCerrarSesion.setVisible(false);
                     BtnEntrar.setVisible(false);
                     BtnCancelar.setVisible(false);
//                     tipoUsuario = 0;
                    }
                if((!cap.equals("Docente"))&& (!cap.equals("Invitado")))
                    {
                    //alerta de mensaje
//                        JOptionPane.showMessageDialog(null, "Error");

//                   //inicia el panel monitor  
                    Limpiar();

                    }
                } catch (SQLException ex) {
            Logger.getLogger(InterfazInicio.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    void desocultar(){
         jLabel1.setVisible(true);
         jLabel4.setVisible(true);
         TxtUsuario.setVisible(true);
         jSeparator2.setVisible(true);
         jLabel2.setVisible(true);
         jLabel5.setVisible(true);
         JpContra.setVisible(true);
         jSeparator1.setVisible(true);
         BtnEntrar.setVisible(true);
         BtnCancelar.setVisible(true);
    }
    
    
    
    
    void acceder(String usuario, String plan, String pass)
    {
       String cap = "";
       String sql = "SELECT * FROM registro WHERE Codigo = '"+usuario+"' and "+"CodigoPlan = '"+plan+"' "
               + "and Password = '"+pass+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("TipoUsuario");
                clave = rs.getInt("IdEstudiante");
            }
            
            if(cap.equals("Monitor"))
            {
                      new rojerusan.RSNotifyAnimated("ACCESO", "Bienvenido", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                  // inicia el panel monitor  
                    PanelMonitor p1 = new PanelMonitor(this);
                    p1.setSize(1090, 1000);//tamaño del Jpanel
                    p1.setLocation(5, 5); // posicion del panel principal
                    PanelPrincipal.removeAll();
                    PanelPrincipal.add(p1, BorderLayout.CENTER);
                    PanelPrincipal.revalidate();
                    PanelPrincipal.repaint();
                    JLCerrarSesion.setVisible(true);
                    BotonBloquear();
                    Bloquear();
                    tipoUsuario = 1;
                    // p1.lblusu.setText(usuario);
 
            }
            if(cap.equals("Estudiante"))
            {                  
                // alerta de mensaje  

                      new rojerusan.RSNotifyAnimated("CORRECTO", "Bienvenido a la plataforma", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                  // inicia el panel monitor  
                    PanelEstudiante p1 = new PanelEstudiante(this);
                    p1.setSize(1090, 1000);//tamaño del Jpanel
                    p1.setLocation(5, 5); // posicion del panel principal
                    PanelPrincipal.removeAll();
                    PanelPrincipal.add(p1, BorderLayout.CENTER);
                    PanelPrincipal.revalidate();
                    PanelPrincipal.repaint();
                    JLCerrarSesion.setVisible(true);
                    BtnEntrar.setEnabled(false);
                    BotonDesbloquear();
                    Bloquear();
                    tipoUsuario = 0;
                    
                     //ventanacliente.lblconectado.setText(usuario);
            }
            if((!cap.equals("Monitor"))&& (!cap.equals("Estudiante")))
            {

                      new rojerusan.RSNotifyAnimated("ERROR", "Acceso Denegado", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                   //inicia el panel monitor  
                Limpiar();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazInicio.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }
    public void acceder2(String usuario2, String pass2){
       String cap="";
       String sql="SELECT * FROM docente WHERE Nombres='"+usuario2+"' and Password='"+pass2+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("TipoUsuario");
                claveDocente = rs.getInt("IdDocente");
            }
            if(cap.equals("Docente"))
            {

                      new rojerusan.RSNotifyAnimated("ACCESO", "Bienvenido", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                  // inicia el panel monitor  
                    PanelDocente p1 = new PanelDocente(this);
                    p1.setSize(1090, 1000);//tamaño del Jpanel
                    p1.setLocation(5, 5); // posicion del panel principal
                    PanelPrincipal.removeAll();
                    PanelPrincipal.add(p1, BorderLayout.CENTER);
                    PanelPrincipal.revalidate();
                    PanelPrincipal.repaint();
                    JLCerrarSesion.setVisible(true);
                    BotonBloquear();
                    Bloquear();
                    tipoDocente = 1;
                    // p1.lblusu.setText(usuario);   
            }
            if(cap.equals("Invitado"))
            {

                      new rojerusan.RSNotifyAnimated("ACCESO", "Bienvenido", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                  // inicia el panel monitor  
                    PanelEstudiante p1 = new PanelEstudiante(this);
                    p1.setSize(1090, 1000);//tamaño del Jpanel
                    p1.setLocation(5, 5); // posicion del panel principal
                    PanelPrincipal.removeAll();
                    PanelPrincipal.add(p1, BorderLayout.CENTER);
                    PanelPrincipal.revalidate();
                    PanelPrincipal.repaint();
                    JLCerrarSesion.setVisible(true);
                    BtnEntrar.setEnabled(false);
                    BotonDesbloquear();
                    Bloquear();
                    tipoDocente = 0;
                     //ventanacliente.lblconectado.setText(usuario);
            }
            if((!cap.equals("Docente"))&& (!cap.equals("Invitado")))
            {

                    new rojerusan.RSNotifyAnimated("ERROR", "Acceso Denegado", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                  // inicia el panel monitor  
                Limpiar();         
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazInicio.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void CargarFoto(String usuario, String plan, String pass){
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
            
            ps =  cn.prepareStatement("SELECT * FROM registro WHERE Codigo = '"+usuario+"' "
                    + "and CodigoPlan = '"+plan+"'and Password = '"+pass+"'");

            rs = ps.executeQuery();
            byte[] image = null;
            if(rs.next()){
                           
                ouput = new ByteArrayOutputStream();
                isdatos = rs.getBinaryStream("Foto");
                
                if (isdatos != null){
                temp=isdatos.read();
                
//                System.out.print(temp);

                while(temp>=0){
                   ouput.write((char)temp);
                   temp=isdatos.read();
                  }
                foto=Toolkit.getDefaultToolkit().createImage(ouput.toByteArray()).getScaledInstance
                (JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT);
                
                JLFoto.setIcon(new ImageIcon(foto));
                }
                else{
                    JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/Usuario.png")));
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
            } catch (SQLException ex) {
                Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public void CargarFotoDocente(String usuario, String pass){
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
            
            ps = (PreparedStatement) cn.prepareStatement("SELECT * FROM docente WHERE Nombres = '"+usuario+"' "
                    + "and Password='"+pass+"'");

            rs = ps.executeQuery();
            byte[] image = null;
            if(rs.next()){
                           
                ouput = new ByteArrayOutputStream();
                
                
                isdatos = rs.getBinaryStream("Foto");
                
                if(isdatos != null){
                temp=isdatos.read();
//                System.out.print(temp);
                while(temp>=0){
                   ouput.write((char)temp);
                   temp=isdatos.read();
                  }
                foto=Toolkit.getDefaultToolkit().createImage(ouput.toByteArray()).getScaledInstance
                (JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT);
                
                JLFoto.setIcon(new ImageIcon(foto));
                }
                else{
                    JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/Usuario.png")));
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
            } catch (SQLException ex) {
                Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PanelAjustesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        JpIngreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLFoto = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        JpContra = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnEntrar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        JLCerrarSesion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JpIngreso.setBackground(new java.awt.Color(255, 255, 255));
        JpIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        JpIngreso.setForeground(new java.awt.Color(255, 255, 255));
        JpIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User:");
        JpIngreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password:");
        JpIngreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        JLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png"))); // NOI18N
        JpIngreso.add(JLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 133, 153));

        TxtUsuario.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });
        TxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtUsuarioKeyTyped(evt);
            }
        });
        JpIngreso.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 150, 30));
        JpIngreso.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 260, 10));
        JpIngreso.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 260, 10));

        JpContra.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        JpIngreso.add(JpContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 150, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-50.png"))); // NOI18N
        JpIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-llave-48.png"))); // NOI18N
        JpIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 50, 40));

        BtnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_aceptar.png"))); // NOI18N
        BtnEntrar.setBorderPainted(false);
        BtnEntrar.setContentAreaFilled(false);
        BtnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_aceptar_on.png"))); // NOI18N
        BtnEntrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_aceptar_on.png"))); // NOI18N
        BtnEntrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_aceptar_on.png"))); // NOI18N
        BtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrarActionPerformed(evt);
            }
        });
        BtnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEntrarKeyPressed(evt);
            }
        });
        JpIngreso.add(BtnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 170, 50));

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cancelar.png"))); // NOI18N
        BtnCancelar.setBorderPainted(false);
        BtnCancelar.setContentAreaFilled(false);
        BtnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cancelar_On.png"))); // NOI18N
        BtnCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cancelar_On.png"))); // NOI18N
        BtnCancelar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cancelar_On.png"))); // NOI18N
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        JpIngreso.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 170, 50));

        JLCerrarSesion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        JLCerrarSesion.setText("Cerrar Sesion");
        JLCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLCerrarSesionMouseClicked(evt);
            }
        });
        JpIngreso.add(JLCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 80, 20));

        getContentPane().add(JpIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 1000));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );

        jPanel1.add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 1000));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1090, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrarActionPerformed
        // TODO add your handling code here:
  
try {
    String [] usu=TxtUsuario.getText().split("-");
    switch(usu.length){
        case 1: 
            //////////////////// Acceso Docente e Invitado /////////////////////////
                 String usu2=TxtUsuario.getText();
                 String pas2=new String(JpContra.getPassword());
                 acceder2(usu2, pas2);
                 CargarFotoDocente(usu2, pas2);
                 configuracionDocente.configuracionDocente(usu2, pas2,tipoDocente);
                 ocultarDocente(usu2, pas2);
                 

                 break;
        case 2:
            //////////////////////Acceso Estudiante e Monitor//////////////////////
             String pas=new String(JpContra.getPassword());
             acceder(usu[0], usu[1], pas);
             CargarFoto(usu[0], usu[1], pas);
             configuracion.configuracion(usu[0], usu[1], pas, tipoUsuario);
             ocultar(usu[0], usu[1], pas);
             break;
        default:
             JOptionPane.showMessageDialog(this,"los datos no existen");
    }
  
}catch(Exception e){
    e.printStackTrace();
    JOptionPane.showMessageDialog(this,"Ingrese los datos");
}


    }//GEN-LAST:event_BtnEntrarActionPerformed

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
        TxtUsuario.requestFocus();
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed

        Limpiar();

    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void JLCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLCerrarSesionMouseClicked
        // TODO add your handling code here:

        //vuelve el panel principal
        PanelPrincipal.removeAll();
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
        //limpia la caja de texto
        Limpiar();
        //desbloquea la caja de texto
        Desbloquear();
        //el jLabel de cerrar sesion se oculta
        JLCerrarSesion.setVisible(false);
        //
        BtnEntrar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        //foto por defecto
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/Usuario.png")));

    }//GEN-LAST:event_JLCerrarSesionMouseClicked

    private void TxtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUsuarioKeyReleased
        // TODO add your handling code here:
        // esto se hace para obtener el valor en otro jframe
        String info = TxtUsuario.getText();
        InterfazSesion.Usuario = info;
//////////////////////////////////////////////////////////////////////////

    }//GEN-LAST:event_TxtUsuarioKeyReleased

    private void BtnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEntrarKeyPressed
        // TODO add your handling code here:
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            evt.consume();
            
              try {
    String [] usu=TxtUsuario.getText().split("-");
    switch(usu.length){
        case 1: 
            //////////////////// Acceso Docente e Invitado /////////////////////////
                 String usu2=TxtUsuario.getText();
                 String pas2=new String(JpContra.getPassword());
                 acceder2(usu2, pas2);
                 CargarFotoDocente(usu2, pas2);
                 configuracionDocente.configuracionDocente(usu2, pas2,tipoDocente);
                 ocultarDocente(usu2, pas2);
                 

                 break;
        case 2:
            //////////////////////Acceso Estudiante e Monitor//////////////////////
             String pas=new String(JpContra.getPassword());
             acceder(usu[0], usu[1], pas);
             CargarFoto(usu[0], usu[1], pas);
             configuracion.configuracion(usu[0], usu[1], pas, tipoUsuario);
             ocultar(usu[0], usu[1], pas);
             break;
        default:
             JOptionPane.showMessageDialog(this,"los datos no existen");
    }
  
        }catch(Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,"Ingrese los datos");
                }
            }
   
    }//GEN-LAST:event_BtnEntrarKeyPressed

    private void TxtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUsuarioKeyTyped
        // TODO add your handling code here:
        String nuestroTexto = TxtUsuario.getText();
        if (nuestroTexto.length()>0){
            char primeraLetra = nuestroTexto.charAt(0);
            nuestroTexto = Character.toUpperCase(primeraLetra)+nuestroTexto.substring(1,nuestroTexto.length());
            TxtUsuario.setText(nuestroTexto);
        }
    }//GEN-LAST:event_TxtUsuarioKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazInicio().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEntrar;
    private javax.swing.JLabel JLCerrarSesion;
    private javax.swing.JLabel JLFoto;
    private javax.swing.JPasswordField JpContra;
    private javax.swing.JPanel JpIngreso;
    public static javax.swing.JPanel PanelPrincipal;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();
}
