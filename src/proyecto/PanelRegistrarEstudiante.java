/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import Clases.ControllerEstudiante;
import Clases.CustomImageIcon;
import Clases.Estudiante;
import Clases.ModelTableEstudiante;
import Conectar.conectar;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import static proyecto.InterfazInicio.PanelPrincipal;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Francisco
 */
public class PanelRegistrarEstudiante extends javax.swing.JPanel{
    DefaultTableModel modelo;
    InterfazInicio inicio;
    PanelOpcionesRegistro p1 =  null;
    boolean a = true;
    boolean b = true;


    
    public String id;
    private FileInputStream fis;
    private int longitudBytes;
    private ControllerEstudiante cc;
    private Estudiante cl;
    
    
    
    

    /**
     * Creates new form PanelRegistrar
     */

    public PanelRegistrarEstudiante(InterfazInicio n) {
        initComponents();
        inicio = n;
//        mostrarusuarios("");
        bloquear();
        
        cc = new ControllerEstudiante();
        
        JTableRegistro.setModel(new ModelTableEstudiante(cc.getEstudiante()));
        
        JTableRegistro.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        JTableRegistro.getTableHeader().setOpaque(false);
        JTableRegistro.getTableHeader().setBackground(new Color(32, 136, 203));
        JTableRegistro.getTableHeader().setForeground(new Color(255,255,255));
        JTableRegistro.setRowHeight(25);
        JTableRegistro.setAlignmentX(SwingConstants.CENTER);
        JTableRegistro.getColumn("Codigo").setPreferredWidth(40);
        JTableRegistro.getColumn("Codigo Plan").setPreferredWidth(45);
        JTableRegistro.getColumn("Documento Identidad").setPreferredWidth(110);
        JTableRegistro.getColumn("Email").setPreferredWidth(110);
        
        jPassword.setVisible(false);
        JPassword.setVisible(false);
        RevelarContraseña.setVisible(false);

    }

    void bloquear(){
    TxtCodigo.setEnabled(false);
    TxtCodigoPlan.setEnabled(false);
    TxtDocumIdentidad.setEnabled(false);
    TxtNombres.setEnabled(false);
    TxtApellidos.setEnabled(false);
    TxtEmail.setEnabled(false);
    JComboBoxGenero.setEnabled(false);
    JComboBoxTipoUsuario.setEnabled(false);

    
    BtnRegistrar.setEnabled(false);
    BtnNuevo.setEnabled(true);
    BtnActualizar.setEnabled(false);
    BtnCancelar.setEnabled(false);
    BtnEliminar.setEnabled(false);
    BtnConfiguracion.setEnabled (false);

    }
    void desbloquear(){
    TxtCodigo.setEnabled(true);
    TxtCodigoPlan.setEnabled(true);
    TxtDocumIdentidad.setEnabled(true);
    TxtNombres.setEnabled(true);
    TxtApellidos.setEnabled(true);
    TxtEmail.setEnabled(true);
    JComboBoxGenero.setEnabled(true);
    JComboBoxTipoUsuario.setEnabled(true);
//    JPassword.setEnabled(true);
    
    BtnRegistrar.setEnabled(true);
    BtnNuevo.setEnabled(false);
    BtnActualizar.setEnabled(true);
    BtnEliminar.setEnabled(true);
    BtnCancelar.setEnabled(true);
    BtnConfiguracion.setEnabled (true);
   
    }
    void limpiar(){
        this.TxtCodigo.setText("");
        this.TxtCodigoPlan.setText("");
        this.TxtDocumIdentidad.setText("");
        this.TxtNombres.setText("");
        this.TxtApellidos.setText("");
        this.TxtEmail.setText("");
        this.JComboBoxGenero.setSelectedItem(0);
        this.JComboBoxTipoUsuario.setSelectedItem(0);
        this.JPassword.setText("");
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png")));
        this.fis = null;
        this.longitudBytes = 0;
        
        this.BtnRegistrar.setEnabled(true);
        BtnNuevo.setEnabled(false);
        this.BtnActualizar.setEnabled(false);
        this.BtnEliminar.setEnabled(false);
        this.BtnConfiguracion.setEnabled(false);
        cl = null;
        
        this.JTableRegistro.clearSelection();
        
    }
   
   void mostrarusuarios(String valor){
   String mostrar="SELECT * FROM registro WHERE CONCAT(Codigo,CodigoPlan,DocumentoIdentidad,Nombres,Apellidos,Email,Genero,TipoUsuario,Password,Foto) LIKE '%"+valor+"%'";    
   String [] titulos= {"Codigo","Codigo Plan","Documento Identidad","Nombres","Apellidos","Email","Genero","Tipo Usuario"};
   modelo=new  DefaultTableModel(null,titulos);   
   String datos []= new String[10];
   String sql="SELECT * FROM  registro"; 
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while(rs.next())
            {
                datos[0] = rs.getString("Codigo");
                datos[1] = rs.getString("CodigoPlan");
                datos[2] = rs.getString("DocumentoIdentidad");
                datos[3] = rs.getString("Nombres");
                datos[4] = rs.getString("Apellidos");
                datos[5] = rs.getString("Email");
                datos[6] = rs.getString("Genero");
                datos[7] = rs.getString("TipoUsuario");
                datos[8] = rs.getString("Password");
                datos[9] = rs.getBlob("Foto").toString();
                
                        
                modelo.addRow(datos);
            }
            JTableRegistro.setModel(modelo);
       } catch (Exception e) {
             JOptionPane.showMessageDialog(this,e);

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
        TxtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtCodigoPlan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtDocumIdentidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JComboBoxGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        JComboBoxTipoUsuario = new javax.swing.JComboBox<>();
        jPassword = new javax.swing.JLabel();
        JPassword = new javax.swing.JPasswordField();
        RevelarContraseña = new javax.swing.JButton();
        JLFoto = new javax.swing.JLabel();
        BtnNuevo = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        BtnMostrarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRegistro = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnConfiguracion = new javax.swing.JButton();

        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Estudiante"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        TxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(TxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 37, 152, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Codigo Plan:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        TxtCodigoPlan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodigoPlanKeyTyped(evt);
            }
        });
        jPanel1.add(TxtCodigoPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 77, 152, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Documento Identidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        TxtDocumIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDocumIdentidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDocumIdentidadKeyTyped(evt);
            }
        });
        jPanel1.add(TxtDocumIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 117, 152, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 217, -1, -1));

        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombresKeyTyped(evt);
            }
        });
        jPanel1.add(TxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 217, 152, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 257, -1, -1));

        TxtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidosKeyTyped(evt);
            }
        });
        jPanel1.add(TxtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 257, 152, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("E-mail:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 297, -1, -1));
        jPanel1.add(TxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 297, 152, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Genero:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 337, -1, -1));

        JComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Masculino", "Femenino" }));
        jPanel1.add(JComboBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 341, 152, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tipo de Usuario:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 379, -1, -1));

        JComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Monitor", "Estudiante" }));
        jPanel1.add(JComboBoxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 383, 152, -1));

        jPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPassword.setText("Password:");
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 421, -1, -1));
        jPanel1.add(JPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 425, 152, -1));

        RevelarContraseña.setText("jButton1");
        RevelarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevelarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(RevelarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 30, 30));

        JLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JLFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLFotoMouseClicked(evt);
            }
        });
        jPanel1.add(JLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 133, 153));

        add(jPanel1);
        jPanel1.setBounds(30, 30, 640, 460);

        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_nuevo.png"))); // NOI18N
        BtnNuevo.setBorderPainted(false);
        BtnNuevo.setContentAreaFilled(false);
        BtnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_nuevo_on.png"))); // NOI18N
        BtnNuevo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_nuevo_on.png"))); // NOI18N
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        add(BtnNuevo);
        BtnNuevo.setBounds(760, 40, 160, 50);

        BtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_registrar.png"))); // NOI18N
        BtnRegistrar.setBorderPainted(false);
        BtnRegistrar.setContentAreaFilled(false);
        BtnRegistrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_registrar_on.png"))); // NOI18N
        BtnRegistrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_registrar_on.png"))); // NOI18N
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        add(BtnRegistrar);
        BtnRegistrar.setBounds(760, 90, 160, 50);

        BtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_actualizar.png"))); // NOI18N
        BtnActualizar.setBorderPainted(false);
        BtnActualizar.setContentAreaFilled(false);
        BtnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_actualizar_on.png"))); // NOI18N
        BtnActualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_actualizar_on.png"))); // NOI18N
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        add(BtnActualizar);
        BtnActualizar.setBounds(760, 140, 160, 50);

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_eliminar.png"))); // NOI18N
        BtnEliminar.setBorderPainted(false);
        BtnEliminar.setContentAreaFilled(false);
        BtnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_eliminar_on.png"))); // NOI18N
        BtnEliminar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_eliminar_on.png"))); // NOI18N
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        add(BtnEliminar);
        BtnEliminar.setBounds(760, 240, 160, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Base de Datos"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Busqueda: ");

        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        BtnMostrarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_mostrar-todo.png"))); // NOI18N
        BtnMostrarTodos.setBorderPainted(false);
        BtnMostrarTodos.setContentAreaFilled(false);
        BtnMostrarTodos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_mostrar-todo_on.png"))); // NOI18N
        BtnMostrarTodos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_mostrar-todo_on.png"))); // NOI18N
        BtnMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarTodosActionPerformed(evt);
            }
        });

        JTableRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableRegistro.setRowHeight(25);
        JTableRegistro.setSelectionBackground(new java.awt.Color(232, 57, 95));
        JTableRegistro.setShowVerticalLines(false);
        JTableRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRegistroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableRegistro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnMostrarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(587, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BtnMostrarTodos)
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(54, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        add(jPanel2);
        jPanel2.setBounds(30, 510, 1010, 250);

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cancelar.png"))); // NOI18N
        BtnCancelar.setBorderPainted(false);
        BtnCancelar.setContentAreaFilled(false);
        BtnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cancelar_On.png"))); // NOI18N
        BtnCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_cancelar_On.png"))); // NOI18N
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        add(BtnCancelar);
        BtnCancelar.setBounds(760, 190, 160, 50);

        BtnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_atras.png"))); // NOI18N
        BtnAtras.setBorderPainted(false);
        BtnAtras.setContentAreaFilled(false);
        BtnAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_atras_on.png"))); // NOI18N
        BtnAtras.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_atras_on.png"))); // NOI18N
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        add(BtnAtras);
        BtnAtras.setBounds(760, 340, 160, 50);

        BtnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_configurar.png"))); // NOI18N
        BtnConfiguracion.setBorderPainted(false);
        BtnConfiguracion.setContentAreaFilled(false);
        BtnConfiguracion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_configurar (1).png"))); // NOI18N
        BtnConfiguracion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/button_configurar (1).png"))); // NOI18N
        BtnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfiguracionActionPerformed(evt);
            }
        });
        add(BtnConfiguracion);
        BtnConfiguracion.setBounds(760, 290, 160, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed

          if(this.TxtCodigo.getText().isEmpty() 
           || this.TxtCodigoPlan.getText().isEmpty()        
           || this.TxtDocumIdentidad.getText().isEmpty() 
           || this.TxtNombres.getText().isEmpty()        
           || this.TxtApellidos.getText().isEmpty()
           || this.TxtEmail.getText().isEmpty()
           || this.JComboBoxGenero.getSelectedIndex() == -1
           || this.JComboBoxTipoUsuario.getSelectedIndex() == -1       
           || this.JPassword.getText().isEmpty()    )
        {
//            JOptionPane.showMessageDialog(this, "Todos los campos son "
//                    + "obligatorios, exepto la foto");
            new rojerusan.RSNotifyAnimated("INFORMACION", "Todos los campos son obligatorios, excepto la foto", 
                        5, RSNotifyAnimated.PositionNotify.TopLef, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.INFORMATION).setVisible(true);
            
 
            return;
        }
        Estudiante cl = new Estudiante();
        cl.setCodigo(TxtCodigo.getText());
        cl.setCodigoPlan(TxtCodigoPlan.getText());
        cl.setDocumentoIdentidad(TxtDocumIdentidad.getText());
        cl.setNombres(TxtNombres.getText());
        cl.setApellidos(TxtApellidos.getText());
        cl.setEmail(TxtEmail.getText());
        cl.setGenero(JComboBoxGenero.getSelectedItem().toString());
        cl.setTipoUsuario(JComboBoxTipoUsuario.getSelectedItem().toString());
        cl.setPassword(JPassword.getText());
        cl.setFoto2(fis);
        int opcion = cc.insertEstudiante(cl);
        
         if(opcion != 0)
         {
            try {
//                JOptionPane.showMessageDialog(this, "Registro " +cl+ " agregado");
             // alerta de mensaje  
                new rojerusan.RSNotifyAnimated("CORRECTO", "Registro Agregado", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                JTableRegistro.setModel(new ModelTableEstudiante(cc.getEstudiante()));
                BtnNuevo.setEnabled(true);
                 this.BtnRegistrar.setEnabled(false); 
                 this.BtnActualizar.setEnabled(false);
                 this.BtnCancelar.setEnabled(false);
                 this.BtnEliminar.setEnabled(false);
                 this.BtnConfiguracion.setEnabled(false);
                 /// se limpian los campos de texto
                 this.TxtCodigo.setText("");
                 this.TxtCodigoPlan.setText("");
                 this.TxtDocumIdentidad.setText("");
                 this.TxtNombres.setText("");
                 this.TxtApellidos.setText("");
                 this.TxtEmail.setText("");
                 this.JComboBoxGenero.setSelectedItem(0);
                 this.JComboBoxTipoUsuario.setSelectedItem(0);
                 this.JPassword.setText("");
                 
                 if(fis != null)
                    fis.close();
                 fis = null;
            } catch (Exception e) {
             JOptionPane.showMessageDialog(this,e);
        }
         }
         bloquear();
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        // TODO add your handling code here:
//        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png")));
        limpiar();        
        desbloquear();
        
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        // TODO add your handling code here:
           if(cl != null)
   {
    cl.setCodigo(TxtCodigo.getText());   
    cl.setCodigoPlan(TxtCodigoPlan.getText());  
    cl.setDocumentoIdentidad(TxtDocumIdentidad.getText());
    cl.setNombres(TxtNombres.getText());
    cl.setApellidos(TxtApellidos.getText());
    cl.setEmail(TxtEmail.getText());
    cl.setGenero(JComboBoxGenero.getSelectedItem().toString());
    cl.setTipoUsuario(JComboBoxTipoUsuario.getSelectedItem().toString());
    cl.setPassword(JPassword.getText());
    cl.setFoto2(fis);
    int opcion = cc.actualzartEstudiante(cl);
         if(opcion != 0)
         {
//              JOptionPane.showMessageDialog(this, "Registro Actualizado");
                new rojerusan.RSNotifyAnimated("CORRECTO", "Registro Actualizado", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
              JTableRegistro.setModel(new ModelTableEstudiante(cc.getEstudiante()));
               if(fis != null)
               {
                   try {
                        fis.close();
                      } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,e);

        }
               }
                 fis = null;
         }
   }else{
//       JOptionPane.showMessageDialog(this, "Primero seleccione uno de los datos que se encuentra en la tabla");
         new rojerusan.RSNotifyAnimated("INFORMACION", "Primero seleccione uno de los datos que se encuentra en la tabla", 
                        5, RSNotifyAnimated.PositionNotify.TopLef, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.INFORMATION).setVisible(true);
   }
        this.TxtCodigo.setText("");
        this.TxtCodigoPlan.setText("");
        this.TxtDocumIdentidad.setText("");
        this.TxtNombres.setText("");
        this.TxtApellidos.setText("");
        this.TxtEmail.setText("");
        this.JComboBoxGenero.setSelectedItem(0);
        this.JComboBoxTipoUsuario.setSelectedItem(0);
        this.JPassword.setText("");
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png")));
        this.fis = null;
        this.longitudBytes = 0;
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
    
             if(cl != null)
        {
            int eliminarEstudiante = cc.eliminarEstudiante(cl.getPrimaryKey());
            if(eliminarEstudiante != 0)
             {
//                  JOptionPane.showMessageDialog(this, "Registro Eliminado");
                    new rojerusan.RSNotifyAnimated("CORRECTO", "Registro Eliminado", 
                        5, RSNotifyAnimated.PositionNotify.TopRight, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                  JTableRegistro.setModel(new ModelTableEstudiante(cc.getEstudiante()));
             }
        }else
        {
//            JOptionPane.showMessageDialog(this, "Primero seleccione uno de los datos que se encuentra en la tabla");
              new rojerusan.RSNotifyAnimated("INFORMACION", "Primero seleccione uno de los datos que se encuentra en la tabla", 
                        5, RSNotifyAnimated.PositionNotify.TopLef, RSNotifyAnimated.AnimationNotify.UpBottom, 
                        RSNotifyAnimated.TypeNotify.INFORMATION).setVisible(true);
            
        }
             limpiar();
             bloquear();

    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        // TODO add your handling code here:
       mostrarusuarios(TxtBuscar.getText());
  
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarTodosActionPerformed
        // TODO add your handling code here:
//         mostrarusuarios("");
        TxtBuscar.setText("");
        cc = new ControllerEstudiante();
        
        JTableRegistro.setModel(new ModelTableEstudiante(cc.getEstudiante()));
               if(JTableRegistro.getSelectedRow() != -1)
            
               {
                   try {
                       InputStream algo;
                        int temp = 0;
                        ByteArrayOutputStream ouput = null;
                        Image foto = null;

                       int fila = JTableRegistro.getSelectedRow();
                       cl = ((ModelTableEstudiante)JTableRegistro.getModel()).getFila(fila);
                       id = JTableRegistro.getValueAt(fila, 0).toString();
                       TxtCodigo.setText(cl.getCodigo());
                       TxtCodigoPlan.setText(cl.getCodigoPlan());
                       TxtDocumIdentidad.setText(cl.getDocumentoIdentidad());
                       TxtNombres.setText(cl.getNombres());
                       TxtApellidos.setText(cl.getApellidos());
                       TxtEmail.setText(cl.getEmail());
                       JComboBoxGenero.setSelectedItem(cl.getGenero());
                       JComboBoxTipoUsuario.setSelectedItem(cl.getTipoUsuario());
                       JPassword.setText(cl.getPassword());
                       algo = cl.getFoto2();
                        temp=algo.read();            
                        if(temp>0)
                        {
                            ouput = new ByteArrayOutputStream();
                            while(temp>=0){
                                ouput.write((char)temp);
                                temp=algo.read();
                            }
                            foto=Toolkit.getDefaultToolkit().createImage(ouput.toByteArray()).getScaledInstance(JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT);
                            JLFoto.setIcon(new ImageIcon(foto));

                        }else{
                            JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png")));
                        }
                            JLFoto.updateUI();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }        
    }//GEN-LAST:event_BtnMostrarTodosActionPerformed

    private void TxtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(TxtCodigo.getText().length()>=8) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_TxtCodigoKeyTyped

    private void TxtCodigoPlanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoPlanKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(TxtCodigoPlan.getText().length()>=8) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_TxtCodigoPlanKeyTyped

    private void TxtDocumIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDocumIdentidadKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(TxtDocumIdentidad.getText().length()>=11) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_TxtDocumIdentidadKeyTyped

    private void TxtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombresKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
        {
        evt.consume();
        }
        String nuestroTexto = TxtNombres.getText();
        if (nuestroTexto.length()>0){
            char primeraLetra = nuestroTexto.charAt(0);
            nuestroTexto = Character.toUpperCase(primeraLetra)+nuestroTexto.substring(1,nuestroTexto.length());
            TxtNombres.setText(nuestroTexto);
        }
    }//GEN-LAST:event_TxtNombresKeyTyped

    private void TxtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidosKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
        {
        evt.consume();
        }
        String nuestroTexto = TxtApellidos.getText();
        if (nuestroTexto.length()>0){
            char primeraLetra = nuestroTexto.charAt(0);
            nuestroTexto = Character.toUpperCase(primeraLetra)+nuestroTexto.substring(1,nuestroTexto.length());
            TxtApellidos.setText(nuestroTexto);
        }
        
        
    }//GEN-LAST:event_TxtApellidosKeyTyped

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
        bloquear();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        // TODO add your handling code here:
                    p1 = new PanelOpcionesRegistro(inicio);
                    p1.setSize(1090, 1000);//tamaño del Jpanel
                    p1.setLocation(5, 5); // posicion del panel principal
                    PanelPrincipal.removeAll();
                    PanelPrincipal.add(p1, BorderLayout.CENTER);
                    PanelPrincipal.revalidate();
                    PanelPrincipal.repaint();
                

    }//GEN-LAST:event_BtnAtrasActionPerformed

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

    private void JLFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLFotoMouseClicked

  JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);       
        int estado = se.showOpenDialog(null);
        if(estado == JFileChooser.APPROVE_OPTION)
        {
            try {
                
                fis =  new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int)se.getSelectedFile().length();
                
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT);
                JLFoto.setIcon(new ImageIcon(icono));
                JLFoto.updateUI(); 
                
            } catch (FileNotFoundException ex) {ex.printStackTrace();}
            catch (IOException ex){ex.printStackTrace();}
        }
       
       
    }//GEN-LAST:event_JLFotoMouseClicked

    private void TxtDocumIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDocumIdentidadKeyReleased
        // TODO add your handling code here:
    String Dato;
    Dato = this.TxtDocumIdentidad.getText();
    this.JPassword.setText(Dato);
    }//GEN-LAST:event_TxtDocumIdentidadKeyReleased

    private void JTableRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRegistroMouseClicked
        // TODO add your handling code here:
        if(JTableRegistro.getSelectedRow() != -1)
            
               {
                   try {
                       InputStream algo;
                        int temp = 0;
                        ByteArrayOutputStream ouput = null;
                        Image foto = null;

                       int fila = JTableRegistro.getSelectedRow();
                       cl = ((ModelTableEstudiante)JTableRegistro.getModel()).getFila(fila);
                       id = JTableRegistro.getValueAt(fila, 0).toString();
                       TxtCodigo.setText(cl.getCodigo());
                       TxtCodigoPlan.setText(cl.getCodigoPlan());
                       TxtDocumIdentidad.setText(cl.getDocumentoIdentidad());
                       TxtNombres.setText(cl.getNombres());
                       TxtApellidos.setText(cl.getApellidos());
                       TxtEmail.setText(cl.getEmail());
                       JComboBoxGenero.setSelectedItem(cl.getGenero());
                       JComboBoxTipoUsuario.setSelectedItem(cl.getTipoUsuario());
                       JPassword.setText(cl.getPassword());
                       
                       algo = cl.getFoto2();
                       if (algo != null){
                        temp=algo.read();
                       }
                        if(temp>0)
                        {
                            ouput = new ByteArrayOutputStream();
                            while(temp>=0){
                                ouput.write((char)temp);
                                temp=algo.read();
                            }
                            foto=Toolkit.getDefaultToolkit().createImage(ouput.toByteArray()).getScaledInstance(JLFoto.getWidth(), JLFoto.getHeight(), Image.SCALE_DEFAULT);
                            JLFoto.setIcon(new ImageIcon(foto));
                          
                        }else{
                            JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png")));
                        }
                            JLFoto.updateUI();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                 

    }//GEN-LAST:event_JTableRegistroMouseClicked

    private void BtnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracionActionPerformed
        // TODO add your handling code here:
        if(b){
            jPassword.setVisible(true);
            JPassword.setVisible(true);
            RevelarContraseña.setVisible(true);
            b = false;
        }
        else{
            b = true;
            jPassword.setVisible(false);
            JPassword.setVisible(false);
            RevelarContraseña.setVisible(false);
        }
        
    }//GEN-LAST:event_BtnConfiguracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfiguracion;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnMostrarTodos;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JComboBox<String> JComboBoxGenero;
    private javax.swing.JComboBox<String> JComboBoxTipoUsuario;
    private javax.swing.JLabel JLFoto;
    private javax.swing.JPasswordField JPassword;
    private javax.swing.JTable JTableRegistro;
    private javax.swing.JButton RevelarContraseña;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtCodigoPlan;
    private javax.swing.JTextField TxtDocumIdentidad;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
conectar cc2 = new conectar();
Connection cn = cc2.conexion();

}

