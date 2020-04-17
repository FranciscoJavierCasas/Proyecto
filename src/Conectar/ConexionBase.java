package Conectar;
import Clases.CustomImageIcon;
import Clases.Docente;
import Clases.Estudiante;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class ConexionBase { 
    
    public static Connection cn = null;
    private static Statement st = null;
    private static PreparedStatement ps = null;    
    private static ResultSet rs = null;
    
    private static String servidor = "localhost";
    private static String nombreBD = "sistema";
    private static String usuario = "postgres";
    private static String clave = "1062313119";

    public static String getNombreBD() {
        return nombreBD;
    }

    public static void setNombreBD(String nombreBD) {
        ConexionBase.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConexionBase.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        ConexionBase.clave = clave;
    }
    
    
    
    public static boolean conectar()
    { 
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+servidor+":5432/"+nombreBD;

            
            cn = DriverManager.getConnection(url, usuario, clave);
            
        }catch(ClassNotFoundException ex){ex.printStackTrace();}        
        catch(SQLException ex){
            String msg = "";
            if(ex.getErrorCode() == 1049)
            {
                msg = "La base de datos: "+nombreBD+" no existe.";
            }else if(ex.getErrorCode() == 1044)
            {
                msg = "El usuario: "+usuario+" no existe.";
            }else if(ex.getErrorCode() == 1045)
            {
                msg = "Contraseña incorrecta.";
            }else if(ex.getErrorCode() == 0)
            {
                msg = "La conexion con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        if(cn != null)
        {
             System.out.println("Conexion Exitosa.... XD");
             return true;
        }
        return false;
           
    }
/////////////////////////Docente////////////////////////////////    
   public static ArrayList<Docente> getDocente(String consulta)
    {
        ArrayList<Docente> Docente = new ArrayList<Docente>();
        Docente cl = null;
        if(cn == null)
            conectar();
        try{
            st = cn.createStatement();
            rs = st.executeQuery(consulta);            
            while(rs.next())
            {
                cl = new Docente();
                cl.setPrimaryKey(rs.getInt(1));
                cl.setDocumentoIdentidad(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setApellidos(rs.getString(4));
                cl.setEmail(rs.getString(5));
                cl.setGenero(rs.getString(6));
                cl.setTipoUsuario(rs.getString(7));
                cl.setPassword(rs.getString(8));
                cl.setFoto(rs.getBinaryStream("Foto"));
                
                Docente.add(cl);
            }
            st.close();
            rs.close();
        }catch(SQLException ex){}
        
        return Docente;
    }
   
   public static int grabarDocente(Docente cl)
    {
        int rsu = 0;
        String sql = Docente.INSERT_CON_FOTO;
        if(cl.getFoto() == null)
        {
            sql = Docente.INSERT_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getDocumentoIdentidad());
            ps.setString(2, cl.getNombres());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getEmail());
            ps.setString(5, cl.getGenero());
            ps.setString(6, cl.getTipoUsuario());
            ps.setString(7, cl.getPassword());
            if(cl.getFoto() != null)
            {
                ps.setBinaryStream(8, cl.getFoto());
            }
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
   public static int actualizarDocente(Docente cl)
    {
        int rsu = 0;
        String sql = Docente.UPDATE_CON_FOTO;
        if(cl.getFoto() == null)
        {            
            sql = Docente.UPDATE_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getDocumentoIdentidad());
            ps.setString(2, cl.getNombres());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getEmail());
            ps.setString(5, cl.getGenero());
            ps.setString(6, cl.getTipoUsuario());
            ps.setString(7, cl.getPassword());
            if(cl.getFoto() != null)
            {
                ps.setBinaryStream(8, cl.getFoto());
                ps.setInt(9, cl.getPrimaryKey());
            }else{
                ps.setInt(8, cl.getPrimaryKey());
            }
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
   public static int eliminarDocente(Integer pk)
    {
        int rsu = 0;
        String sql = Docente.DELETE;
      
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, pk);  
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
     public static CustomImageIcon getFoto(int id)
    {
        String sql = "select Foto from docente where IdDocente = "+id;
        CustomImageIcon ii = null;
        InputStream is = null;
         if(cn == null)
            conectar();
       try{
           
           st = cn.createStatement();
           rs = st.executeQuery(sql); 
           if(rs.next()){
               is = rs.getBinaryStream(1);
               if(is != null)
               {
                   
                   BufferedImage bi = ImageIO.read(is);
                   ii = new CustomImageIcon(bi);
               }
               
           }
           
           
       }catch(SQLException ex){ex.printStackTrace();}
       catch(IOException ex){ex.printStackTrace();}
        
        return ii;
    }

//     public static boolean existeEmail(String email)
//    {        
//        String sql = "select email from tbl_cliente where email like ? ";  
//        boolean emailEncontrado = false;
//        if(cn == null)
//            conectar();
//        try{
//            ps = cn.prepareStatement(sql);
//            ps.setString(1, email);            
//            rs = ps.executeQuery();
//            if(rs.next())
//            {
//               emailEncontrado = true; 
//            }
//        }catch(SQLException ex){ex.printStackTrace();} 
//        System.out.println(sql);
//        return emailEncontrado;
//        
//    }
     
   public static ArrayList<Estudiante> getEstudiante(String consulta)
    {
        ArrayList<Estudiante> Estudiante = new ArrayList<Estudiante>();
        Estudiante cl = null;
        if(cn == null)
            conectar();
        try{
            st = cn.createStatement();
            rs = st.executeQuery(consulta);            
            while(rs.next())
            {
                cl = new Estudiante();
                cl.setPrimaryKey(rs.getInt(1));
                cl.setCodigo(rs.getString(2));
                cl.setCodigoPlan(rs.getString(3));
                cl.setDocumentoIdentidad(rs.getString(4));
                cl.setNombres(rs.getString(5));
                cl.setApellidos(rs.getString(6));
                cl.setEmail(rs.getString(7));
                cl.setGenero(rs.getString(8));
                cl.setTipoUsuario(rs.getString(9));
                cl.setPassword(rs.getString(10));
                cl.setFoto2(rs.getBinaryStream("Foto"));
                Estudiante.add(cl);
            }
            st.close();
            rs.close();
        }catch(SQLException ex){}
        
        return Estudiante;
    }
    public static int grabarEstudiante(Estudiante cl)
    {
        int rsu = 0;
        String sql = Estudiante.INSERT_CON_FOTO;
        if(cl.getFoto2() == null)
        {
            sql = Estudiante.INSERT_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getCodigo());
            ps.setString(2, cl.getCodigoPlan());
            ps.setString(3, cl.getDocumentoIdentidad());
            ps.setString(4, cl.getNombres());
            ps.setString(5, cl.getApellidos());
            ps.setString(6, cl.getEmail());
            ps.setString(7, cl.getGenero());
            ps.setString(8, cl.getTipoUsuario());
            ps.setString(9, cl.getPassword());
            if(cl.getFoto2() != null)
            {
                ps.setBinaryStream(10, cl.getFoto2());
            }
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
    
      public static int actualizarEstudiante(Estudiante cl)
    {
        int rsu = 0;
        String sql = Estudiante.UPDATE_CON_FOTO;
        if(cl.getFoto2() == null)
        {            
            sql = Estudiante.UPDATE_SIN_FOTO;
        }
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getCodigo());
            ps.setString(2, cl.getCodigoPlan());
            ps.setString(3, cl.getDocumentoIdentidad());
            ps.setString(4, cl.getNombres());
            ps.setString(5, cl.getApellidos());
            ps.setString(6, cl.getEmail());
            ps.setString(7, cl.getGenero());
            ps.setString(8, cl.getTipoUsuario());
            ps.setString(9, cl.getPassword());
            if(cl.getFoto2() != null)
            {
                ps.setBinaryStream(10, cl.getFoto2());
                ps.setInt(11, cl.getPrimaryKey());
            }else{
                ps.setInt(10, cl.getPrimaryKey());
            }
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
     public static int eliminarEstudiante(Integer pk)
    {
        int rsu = 0;
        String sql = Estudiante.DELETE;
      
        if(cn == null)
            conectar();
        try{
            ps = cn.prepareStatement(sql);
            ps.setInt(1, pk);  
            rsu=ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();} 
        System.out.println(sql);
        return rsu;
        
    }
   
     public static CustomImageIcon getFoto2(int id)
    {
        String sql = "select Foto from registro where IdEstudiante = "+id;
        CustomImageIcon ii = null;
        InputStream is = null;
         if(cn == null)
            conectar();
       try{
           
           st = cn.createStatement();
           rs = st.executeQuery(sql); 
           if(rs.next()){
               is = rs.getBinaryStream(1);
               if(is != null)
               {
                   
                   BufferedImage bi = ImageIO.read(is);
                   ii = new CustomImageIcon(bi);
               }
               
           }
           
           
       }catch(SQLException ex){ex.printStackTrace();}
       catch(IOException ex){ex.printStackTrace();}
        
        return ii;
    }  
   
     
     
}
