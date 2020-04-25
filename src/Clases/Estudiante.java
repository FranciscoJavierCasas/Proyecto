/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("unchecked")
public class Estudiante {
    public static String SELECT_ALL = "SELECT * FROM registro";
    
    /**
     *  Consutla sql que seleccionado todos los campos de la tabla excepto el campo foto
     */
    public static String SELECT_ALL_NO_FOTO = "SELECT IdEstudiante, Codigo, CodigoPlan, DocumentoIdentidad, Nombres, Apellidos, Email, Genero, TipoUsuario, Password, Foto FROM registro";
    
    public static String UPDATE_CON_FOTO = "UPDATE registro SET "+
        "Codigo = ?,"+        
        "CodigoPlan = ?,"+        
        "DocumentoIdentidad = ?,"+    
	"Nombres = ? ,"+
	"Apellidos = ?, "+
	"Email = ?, "+
        "Genero = ?, "+
        "TipoUsuario = ?, "+
	"Password = ?, "+
	"Foto = ? WHERE IdEstudiante = ?";
    
     public static String UPDATE_SIN_FOTO = "UPDATE  registro SET "+
        "Codigo = ?,"+        
        "CodigoPlan = ?,"+       
	"DocumentoIdentidad = ?,"+    
	"Nombres = ? ,"+
	"Apellidos = ?, "+
	"Email = ?, "+
        "Genero = ?, "+
        "TipoUsuario = ?, "+
	"Password = ?  WHERE IdEstudiante = ?";
     
     public static String INSERT_CON_FOTO = "INSERT INTO registro"
             + "(Codigo, CodigoPlan, DocumentoIdentidad, Nombres, Apellidos, Email, Genero, TipoUsuario, Password, Foto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
     public static String INSERT_SIN_FOTO = "INSERT INTO registro"
             + "(Codigo, CodigoPlan, DocumentoIdentidad, Nombres, Apellidos, Email, Genero, TipoUsuario, Password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
     
     public static String DELETE = "DELETE FROM registro where IdEstudiante = ?";
     
    private Integer primaryKey;
    private String Codigo;
    private String CodigoPlan;
    private String DocumentoIdentidad;
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String Genero;
    private String TipoUsuario;
    private String Password;
    private InputStream Foto;
@SuppressWarnings("unchecked")
    public Estudiante(Integer primaryKey, String Codigo, String CodigoPlan, String DocumentoIdentidad, String Nombres, String Apellidos, String Email, String Genero, String TipoUsuario, String Password, FileInputStream Foto) {
        
        this.primaryKey = primaryKey;
        this.Codigo = Codigo;
        this.CodigoPlan = CodigoPlan;
        this.DocumentoIdentidad = DocumentoIdentidad;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Genero = Genero;
        this.TipoUsuario = TipoUsuario;
        this.Password = Password;
        this.Foto = Foto;
    }
    @SuppressWarnings("unchecked")
      public Estudiante(String Codigo, String CodigoPlan, String DocumentoIdentidad, String Nombres, String Apellidos, String Email, String Genero, String TipoUsuario, String Password, FileInputStream Foto) {
        this.Codigo = Codigo;
        this.CodigoPlan = CodigoPlan;
        this.DocumentoIdentidad = DocumentoIdentidad;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Genero = Genero;
        this.TipoUsuario = TipoUsuario;
        this.Password = Password;
        this.Foto = Foto;
    }

    public Estudiante() {
    }
    
      

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    public String getCodigo(){
        return Codigo;
    }
    public void setCodigo(String Codigo){
        this.Codigo = Codigo;
    }
    
    public String getCodigoPlan(){
        return CodigoPlan;
    }
    public void setCodigoPlan(String CodigoPlan){
        this.CodigoPlan = CodigoPlan;
    }
    
    public String getDocumentoIdentidad(){
        return DocumentoIdentidad;
    }
    public void setDocumentoIdentidad(String DocumentoIdentidad){
        this.DocumentoIdentidad = DocumentoIdentidad;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }
    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public InputStream getFoto2() {
        return Foto;
    }

    public void setFoto2(InputStream Foto) {
        this.Foto = Foto;
    }
    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        return Nombres + Apellidos;
    }
    @SuppressWarnings("unchecked")
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.primaryKey != null ? this.primaryKey.hashCode() : 0);
        return hash;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.primaryKey != other.primaryKey && (this.primaryKey == null || !this.primaryKey.equals(other.primaryKey))) {
            return false;
        }
        return true;
    }

 
    
}
