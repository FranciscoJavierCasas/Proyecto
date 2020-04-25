/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conectar.ConexionBase;
import java.util.ArrayList;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("unchecked")
public class ControllerEstudiante {
       public ArrayList<Estudiante> getEstudiante()
     {
         return ConexionBase.getEstudiante(Estudiante.SELECT_ALL_NO_FOTO);
     }
     
     public int insertEstudiante(Estudiante cl)
     {
        return ConexionBase.grabarEstudiante(cl);
     }
     
     public int actualzartEstudiante(Estudiante cl)
     {
        return ConexionBase.actualizarEstudiante(cl);
     }
     
     public int eliminarEstudiante(Integer pk)
     {
        return ConexionBase.eliminarEstudiante(pk) ;
     }
}
