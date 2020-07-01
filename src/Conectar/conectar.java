
package Conectar;

import static Conectar.ConexionBase.servidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectar {
    Connection conectar=null;
    static String servidor = "";
    static String url = "";
    static String usuario = "";
    static String clave = "";

    
    public Connection conexion(){
//        try {
////            Class.forName("com.mysql.jdbc.Driver");
////              conectar=DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","");
//            Class.forName("org.postgresql.Driver");
//            conectar=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema","postgres","1062313119");
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.print(e.getMessage());
//        }
//        return conectar;

         File archivo = new File ("./Conexion.txt");
        if(archivo.exists() && archivo.isFile()){
            try{
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = "";
                    if(leer.ready()){
                        linea = leer.readLine();
                    }
                    if (linea != null){
                        try{
                            String [] desglose = linea.split(",");
                            servidor = desglose[0];
                            url = desglose[1];
                            usuario = desglose[2];
                            clave = desglose[3];
                            
                            Class.forName("org.postgresql.Driver");
//                          String url = "jdbc:postgresql://"+servidor+":5432/"+nombreBD;
//                          String [] ar = archivo.split
                            conectar = DriverManager.getConnection(servidor+":"+url,usuario,clave);
                            
//                            cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema","postgres","1062313119");
//                          cn = DriverManager.getConnection(url, usuario, clave);
                            
                            }catch(ClassNotFoundException ex){ex.printStackTrace();}        
                             catch(SQLException ex){
                                ex.printStackTrace();
                                System.out.println("los datos de conexion no estan"+ex);
                                 String msg = "";
                                    if(ex.getErrorCode() == 1049)
                                    {
                                        msg = "La base de datos: "+url+" no existe.";
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
                                    return conectar;                   
                            }
                        if(conectar != null)
                            {
                                //System.out.println("Conexion Exitosa.... XD");
                                return conectar;
                            }
                            return conectar;
                    }
                    if(clave == null){
                        clave = "";
                    }
                    
            }catch(Exception ex){
                    ex.printStackTrace();
            }
        }else{
            System.out.println("Conexion de archivo no existe");
            System.out.println(archivo);
        }
        return conectar;
    }
  
    
}
