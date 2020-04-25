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
public class EstudianteTest {
    
    public EstudianteTest() {
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
     * Test of getPrimaryKey method, of class Estudiante.
     */
    @Test
    public void testGetPrimaryKey() {
        System.out.println("getPrimaryKey");
        Estudiante instance = new Estudiante();
        Integer expResult = null;
        Integer result = instance.getPrimaryKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setPrimaryKey method, of class Estudiante.
     */
    @Test
    public void testSetPrimaryKey() {
        System.out.println("setPrimaryKey");
        Integer primaryKey = null;
        Estudiante instance = new Estudiante();
        instance.setPrimaryKey(primaryKey);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCodigo method, of class Estudiante.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Estudiante.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String Codigo ="1610417";
        Estudiante instance = new Estudiante();
        instance.setCodigo(Codigo);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigoPlan method, of class Estudiante.
     */
    @Test
    public void testGetCodigoPlan() {
        System.out.println("getCodigoPlan");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getCodigoPlan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCodigoPlan method, of class Estudiante.
     */
    @Test
    public void testSetCodigoPlan() {
        System.out.println("setCodigoPlan");
        String CodigoPlan = "3743";
        Estudiante instance = new Estudiante();
        instance.setCodigoPlan(CodigoPlan);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getDocumentoIdentidad method, of class Estudiante.
     */
    @Test
    public void testGetDocumentoIdentidad() {
        System.out.println("getDocumentoIdentidad");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getDocumentoIdentidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setDocumentoIdentidad method, of class Estudiante.
     */
    @Test
    public void testSetDocumentoIdentidad() {
        System.out.println("setDocumentoIdentidad");
        String DocumentoIdentidad = "1062313119";
        Estudiante instance = new Estudiante();
        instance.setDocumentoIdentidad(DocumentoIdentidad);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombres method, of class Estudiante.
     */
    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getNombres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setNombres method, of class Estudiante.
     */
    @Test
    public void testSetNombres() {
        System.out.println("setNombres");
        String Nombres = "Francisco Javier";
        Estudiante instance = new Estudiante();
        instance.setNombres(Nombres);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getApellidos method, of class Estudiante.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setApellidos method, of class Estudiante.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String Apellidos = "Casas";
        Estudiante instance = new Estudiante();
        instance.setApellidos(Apellidos);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getEmail method, of class Estudiante.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setEmail method, of class Estudiante.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String Email = "javier.5807@hotmail.com";
        Estudiante instance = new Estudiante();
        instance.setEmail(Email);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getGenero method, of class Estudiante.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setGenero method, of class Estudiante.
     */
    @Test
    public void testSetGenero() {
        System.out.println("setGenero");
        String Genero = "Masculino";
        Estudiante instance = new Estudiante();
        instance.setGenero(Genero);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getTipoUsuario method, of class Estudiante.
     */
    @Test
    public void testGetTipoUsuario() {
        System.out.println("getTipoUsuario");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getTipoUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setTipoUsuario method, of class Estudiante.
     */
    @Test
    public void testSetTipoUsuario() {
        System.out.println("setTipoUsuario");
        String TipoUsuario = "Estudiante";
        Estudiante instance = new Estudiante();
        instance.setTipoUsuario(TipoUsuario);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getPassword method, of class Estudiante.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Estudiante instance = new Estudiante();
        String expResult = null;
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setPassword method, of class Estudiante.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String Password = "1062313119";
        Estudiante instance = new Estudiante();
        instance.setPassword(Password);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getFoto2 method, of class Estudiante.
     */
    @Test
    public void testGetFoto2() {
        System.out.println("getFoto2");
        Estudiante instance = new Estudiante();
        InputStream expResult = null;
        InputStream result = instance.getFoto2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setFoto2 method, of class Estudiante.
     */
    @Test
    public void testSetFoto2() {
        System.out.println("setFoto2");
        InputStream Foto = null;
        Estudiante instance = new Estudiante();
        instance.setFoto2(Foto);
        // TODO review the generated test code and remove the default call to fail.

    }
//
//    /**
//     * Test of toString method, of class Estudiante.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Estudiante instance = new Estudiante();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
// 
//    }
//
//    /**
//     * Test of hashCode method, of class Estudiante.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Estudiante instance = new Estudiante();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//
//    }
//
//    /**
//     * Test of equals method, of class Estudiante.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Estudiante instance = new Estudiante();
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//
//    }
//    
}
