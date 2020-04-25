/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francisco
 */
public class DocenteTest {
    
    public DocenteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrimaryKey method, of class Docente.
     */
    @Test
    public void testGetPrimaryKey() {
        System.out.println("getPrimaryKey");
        Docente instance = new Docente();
        Integer expResult = null;
        Integer result = instance.getPrimaryKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPrimaryKey method, of class Docente.
     */
    @Test
    public void testSetPrimaryKey() {
        System.out.println("setPrimaryKey");
        Integer primaryKey = null;
        Docente instance = new Docente();
        instance.setPrimaryKey(primaryKey);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getDocumentoIdentidad method, of class Docente.
     */
    @Test
    public void testGetDocumentoIdentidad() {
        System.out.println("getDocumentoIdentidad");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getDocumentoIdentidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setDocumentoIdentidad method, of class Docente.
     */
    @Test
    public void testSetDocumentoIdentidad() {
        System.out.println("setDocumentoIdentidad");
        String DocumentoIdentidad = "1062313119";
        Docente instance = new Docente();
        instance.setDocumentoIdentidad(DocumentoIdentidad);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombres method, of class Docente.
     */
    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getNombres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setNombres method, of class Docente.
     */
    @Test
    public void testSetNombres() {
        System.out.println("setNombres");
        String Nombres = "Francisco";
        Docente instance = new Docente();
        instance.setNombres(Nombres);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getApellidos method, of class Docente.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setApellidos method, of class Docente.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String Apellidos = "Casas";
        Docente instance = new Docente();
        instance.setApellidos(Apellidos);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class Docente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setEmail method, of class Docente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String Email = "francisco.casas@correounivalle.edu.co";
        Docente instance = new Docente();
        instance.setEmail(Email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getGenero method, of class Docente.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setGenero method, of class Docente.
     */
    @Test
    public void testSetGenero() {
        System.out.println("setGenero");
        String Genero = "Masculino";
        Docente instance = new Docente();
        instance.setGenero(Genero);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getTipoUsuario method, of class Docente.
     */
    @Test
    public void testGetTipoUsuario() {
        System.out.println("getTipoUsuario");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getTipoUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setTipoUsuario method, of class Docente.
     */
    @Test
    public void testSetTipoUsuario() {
        System.out.println("setTipoUsuario");
        String TipoUsuario = "Docente";
        Docente instance = new Docente();
        instance.setTipoUsuario(TipoUsuario);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPassword method, of class Docente.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Docente instance = new Docente();
        String expResult = null;
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setPassword method, of class Docente.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String Password = "1062313119";
        Docente instance = new Docente();
        instance.setPassword(Password);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getFoto method, of class Docente.
     */
    @Test
    public void testGetFoto() {
        System.out.println("getFoto");
        Docente instance = new Docente();
        InputStream expResult = null;
        InputStream result = instance.getFoto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setFoto method, of class Docente.
     */
    @Test
    public void testSetFoto() {
        System.out.println("setFoto");
        InputStream Foto = null;
        Docente instance = new Docente();
        instance.setFoto(Foto);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Docente.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Docente instance = new Docente();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class Docente.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Docente instance = new Docente();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class Docente.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Docente instance = new Docente();
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
