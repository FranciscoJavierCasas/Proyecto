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
import java.util.ArrayList;
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
@SuppressWarnings("unchecked")
public class PanelRegistrarEstudiante extends javax.swing.JPanel{
    DefaultTableModel modelo;
    InterfazInicio inicio;
    PanelOpcionesRegistro p1 =  null;
    boolean a = true;
    boolean b = true;
    ModelTableEstudiante modelo2;

    
    public String id;
    private FileInputStream fis;
    private int longitudBytes;
    private ControllerEstudiante cc;
    private Estudiante cl;

    
    
    
    

    /**
     * Creates new form PanelRegistrar
     * @param n
     */
    @SuppressWarnings("unchecked")
    public PanelRegistrarEstudiante(InterfazInicio n) {
        initComponents();
        inicio = n;
//        mostrarusuarios("");
        bloquear();
        
        cc = new ControllerEstudiante();
        modelo2 = new ModelTableEstudiante(cc.getEstudiante());
        JTableRegistro.setModel(modelo2);
        
        JTableRegistro.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        JTableRegistro.getTableHeader().setOpaque(false);
        JTableRegistro.getTableHeader().setBackground(new Color(32, 136, 203));
        JTableRegistro.getTableHeader().setForeground(new Color(255,255,255));
        JTableRegistro.setRowHeight(25);
        JTableRegistro.setAlignmentX(SwingConstants.CENTER);
//        JTableRegistro.getColumn("Codigo").setPreferredWidth(40);
//        JTableRegistro.getColumn("Codigo Plan").setPreferredWidth(45);
//        JTableRegistro.getColumn("Documento Identidad").setPreferredWidth(110);
//        JTableRegistro.getColumn("Email").setPreferredWidth(110);
        
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
        this.JComboBoxGenero.setSelectedItem("");
        this.JComboBoxTipoUsuario.setSelectedItem("");
        this.JPassword.setText("");
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-genero-neutro-96.png")));
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
   @SuppressWarnings("unchecked")
   void mostrarusuarios(String valor){
   String mostrar="SELECT * FROM registro WHERE CONCAT(Codigo,CodigoPlan,DocumentoIdentidad,Nombres,Apellidos,"
                                + "Email,Genero,TipoUsuario,Password,Foto) LIKE '%"+valor+"%'";    
   String [] titulos= {"Codigo","Codigo Plan","DI","Nombres","Apellidos","Email","Genero","Tipo Usuario"};

   //modelo=new  DefaultTableModel(null,titulos);
//   cl = ((ModelTableEstudiante)JTableRegistro.getModel()).getFila(fila);
    ArrayList<Estudiante> estudiante = new ArrayList<>();
   String datos []= new String[10];
   String sql="SELECT * FROM  registro"; 
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while(rs.next())
            {
//                datos[0] = rs.getString("Codigo");
//                datos[1] = rs.getString("CodigoPlan");
//                datos[2] = rs.getString("DocumentoIdentidad");
//                datos[3] = rs.getString("Nombres");
//                datos[4] = rs.getString("Apellidos");
//                datos[5] = rs.getString("Email");
//                datos[6] = rs.getString("Genero");
//                datos[7] = rs.getString("TipoUsuario");
//                datos[8] = rs.getString("Password");
//                datos[9] = rs.getBlob("Foto").toString();
                cl = new Estudiante();
//                cl.setPrimaryKey(rs.getInt(1));
                cl.setCodigo(rs.getString("Codigo"));
                cl.setCodigoPlan(rs.getString("CodigoPlan"));
                cl.setDocumentoIdentidad(rs.getString("DocumentoIdentidad"));
                cl.setNombres(rs.getString("Nombres"));
                cl.setApellidos(rs.getString("Apellidos"));
                cl.setEmail(rs.getString("Email"));
                cl.setGenero(rs.getString("Genero"));
                cl.setTipoUsuario(rs.getString("TipoUsuario"));
                cl.setPassword(rs.getString("Password"));
                cl.setFoto2(rs.getBinaryStream("Foto"));
                estudiante.add(cl);
                
                        
                  //modelo.addRow(datos);
                  //modelo2.actulizarDatos(estudiante);
                  modelo2 = new ModelTableEstudiante(estudiante);
                  
            }
                 JTableRegistro.setModel(modelo2);
            
       } catch (SQLException e) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPassword = new javax.swing.JLabel();
        RevelarContraseña = new javax.swing.JButton();
        TxtCodigo = new rscomponentshade.RSTextFieldShade();
        TxtCodigoPlan = new rscomponentshade.RSTextFieldShade();
        TxtDocumIdentidad = new rscomponentshade.RSTextFieldShade();
        TxtNombres = new rscomponentshade.RSTextFieldShade();
        TxtApellidos = new rscomponentshade.RSTextFieldShade();
        TxtEmail = new rscomponentshade.RSTextFieldShade();
        JComboBoxGenero = new RSMaterialComponent.RSComboBoxMaterial();
        JComboBoxTipoUsuario = new RSMaterialComponent.RSComboBoxMaterial();
        JPassword = new rscomponentshade.RSPassFieldShade();
        JLFoto = new javax.swing.JLabel();
        BtnNuevo = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtnMostrarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRegistro = new javax.swing.JTable();
        TxtBuscar = new rscomponentshade.RSTextFieldShade();
        BtnCancelar = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnConfiguracion = new javax.swing.JButton();

        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Registro Estudiante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Codigo Plan:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Documento Identidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 217, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 257, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("E-mail:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 297, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Genero:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 337, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tipo de Usuario:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 379, -1, -1));

        jPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPassword.setText("Password:");
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 421, -1, -1));

        RevelarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eye_solid.png"))); // NOI18N
        RevelarContraseña.setBorderPainted(false);
        RevelarContraseña.setContentAreaFilled(false);
        RevelarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevelarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(RevelarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 425, 35, 30));

        TxtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtCodigo.setPlaceholder("");
        TxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(TxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 37, 160, 30));

        TxtCodigoPlan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtCodigoPlan.setPlaceholder("");
        TxtCodigoPlan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodigoPlanKeyTyped(evt);
            }
        });
        jPanel1.add(TxtCodigoPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 77, 160, 30));

        TxtDocumIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtDocumIdentidad.setPlaceholder("");
        TxtDocumIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDocumIdentidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDocumIdentidadKeyTyped(evt);
            }
        });
        jPanel1.add(TxtDocumIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 117, 160, 30));

        TxtNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtNombres.setPlaceholder("");
        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombresKeyTyped(evt);
            }
        });
        jPanel1.add(TxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 217, 160, 30));

        TxtApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtApellidos.setPlaceholder("");
        TxtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidosKeyTyped(evt);
            }
        });
        jPanel1.add(TxtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 257, 160, 30));

        TxtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtEmail.setPlaceholder("");
        jPanel1.add(TxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 297, 160, 30));

        JComboBoxGenero.setBackground(new java.awt.Color(240, 240, 240));
        JComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Masculino", "Femenino" }));
        JComboBoxGenero.setFont(new java.awt.Font("Roboto Bold", 0, 12)); // NOI18N
        jPanel1.add(JComboBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 341, 160, 30));

        JComboBoxTipoUsuario.setBackground(new java.awt.Color(240, 240, 240));
        JComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Monitor", "Estudiante" }));
        JComboBoxTipoUsuario.setFont(new java.awt.Font("Roboto Bold", 0, 12)); // NOI18N
        jPanel1.add(JComboBoxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 383, 160, 30));

        JPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JPassword.setPlaceholder("");
        jPanel1.add(JPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 425, 160, 30));

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Base de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(BtnMostrarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 156, -1));

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 920, 160));

        TxtBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtBuscar.setPlaceholder("Busqueda");
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });
        jPanel2.add(TxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 30));

        add(jPanel2);
        jPanel2.setBounds(30, 510, 970, 250);

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
           || this.JPassword.getPassword().toString().isEmpty()    )
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
        cl.setPassword(String.valueOf(JPassword.getPassword()));
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
            } catch (IOException e) {
             JOptionPane.showMessageDialog(this,e);
        }
         }
         bloquear();
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        // TODO add your handling code here:
//        JL.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-género-neutro-96.png")));
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
    cl.setPassword(String.valueOf(JPassword.getPassword()));
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
                      } catch (IOException e) {
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
        JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-genero-neutro-96.png")));
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
                            JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-genero-neutro-96.png")));
                        }
                            JLFoto.updateUI();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }        
    }//GEN-LAST:event_BtnMostrarTodosActionPerformed

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
                            JLFoto.setIcon(new CustomImageIcon(getClass().getResource("/Imagenes/icons8-usuario-de-genero-neutro-96.png")));
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

    private void TxtDocumIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDocumIdentidadKeyReleased
        // TODO add your handling code here:
        String Dato;
        Dato = this.TxtDocumIdentidad.getText();
        this.JPassword.setText(Dato);
    }//GEN-LAST:event_TxtDocumIdentidadKeyReleased

    private void TxtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombresKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombresKeyReleased

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

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        // TODO add your handling code here:
        mostrarusuarios(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfiguracion;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnMostrarTodos;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnRegistrar;
    private RSMaterialComponent.RSComboBoxMaterial JComboBoxGenero;
    private RSMaterialComponent.RSComboBoxMaterial JComboBoxTipoUsuario;
    private javax.swing.JLabel JLFoto;
    private rscomponentshade.RSPassFieldShade JPassword;
    private javax.swing.JTable JTableRegistro;
    private javax.swing.JButton RevelarContraseña;
    private rscomponentshade.RSTextFieldShade TxtApellidos;
    private rscomponentshade.RSTextFieldShade TxtBuscar;
    private rscomponentshade.RSTextFieldShade TxtCodigo;
    private rscomponentshade.RSTextFieldShade TxtCodigoPlan;
    private rscomponentshade.RSTextFieldShade TxtDocumIdentidad;
    private rscomponentshade.RSTextFieldShade TxtEmail;
    private rscomponentshade.RSTextFieldShade TxtNombres;
    private javax.swing.JLabel jLabel1;
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

