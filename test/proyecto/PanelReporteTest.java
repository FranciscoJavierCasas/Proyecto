/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

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
public class PanelReporteTest {
    
    public PanelReporteTest() {
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
     * Test of GenerarReporte method, of class PanelReporte.
     */
    @Test
    public void testGenerarReporte() {
        System.out.println("GenerarReporte");
        PanelReporte instance = new PanelReporte();
        instance.GenerarReporte();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of GenerarReporteUsoBusqueda method, of class PanelReporte.
     */
    @Test
    public void testGenerarReporteUsoBusqueda() {
        System.out.println("GenerarReporteUsoBusqueda");
        PanelReporte instance = new PanelReporte();
        instance.GenerarReporteUsoBusqueda();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of GenerarReporteEstudiante method, of class PanelReporte.
     */
    @Test
    public void testGenerarReporteEstudiante() {
        System.out.println("GenerarReporteEstudiante");
        PanelReporte instance = new PanelReporte();
        instance.GenerarReporteEstudiante();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of GenerarReporteEstudianteBusqueda method, of class PanelReporte.
     */
    @Test
    public void testGenerarReporteEstudianteBusqueda() {
        System.out.println("GenerarReporteEstudianteBusqueda");
        PanelReporte instance = new PanelReporte();
        instance.GenerarReporteEstudianteBusqueda();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of GenerarReporteDocente method, of class PanelReporte.
     */
    @Test
    public void testGenerarReporteDocente() {
        System.out.println("GenerarReporteDocente");
        PanelReporte instance = new PanelReporte();
        instance.GenerarReporteDocente();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of GenerarReporteDocenteBusqueda method, of class PanelReporte.
     */
    @Test
    public void testGenerarReporteDocenteBusqueda() {
        System.out.println("GenerarReporteDocenteBusqueda");
        PanelReporte instance = new PanelReporte();
        instance.GenerarReporteDocenteBusqueda();
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
