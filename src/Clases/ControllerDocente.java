package Clases;


import Conectar.ConexionBase;
import java.util.ArrayList;


/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
@SuppressWarnings("unchecked")
public class ControllerDocente {
    
     public ArrayList<Docente> getDocente()
     {
         return ConexionBase.getDocente(Docente.SELECT_ALL_NO_FOTO);
     }
     
     public int insertDocente(Docente cl)
     {
        return ConexionBase.grabarDocente(cl);
     }
     
     public int actualzartDocente(Docente cl)
     {
        return ConexionBase.actualizarDocente(cl);
     }
     
     public int eliminarDocente(Integer pk)
     {
        return ConexionBase.eliminarDocente(pk) ;
     }
     
}
