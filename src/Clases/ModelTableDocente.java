package Clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Clases.Docente;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class ModelTableDocente extends AbstractTableModel{
    
    private String[] nombreColumnas = {"Documento Identidad","Nombres","Apellidos","Email","Genero","Tipo Usuario"};
    private ArrayList<Docente> cls;

    public ModelTableDocente(ArrayList<Docente> cls) {
        this.cls = cls;
    }

    public ModelTableDocente() {
    }

    public void setDocente(ArrayList<Docente> cls) {
        this.cls = cls;
    }
    
    @Override
    public int getRowCount() {
        return cls.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Docente getFila(int index)
    {
        return cls.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return cls.get(rowIndex).getDocumentoIdentidad();
            case 1: return cls.get(rowIndex).getNombres();    
            case 2: return cls.get(rowIndex).getApellidos();    
            case 3: return cls.get(rowIndex).getEmail();
            case 4: return cls.get(rowIndex).getGenero();
            case 5: return cls.get(rowIndex).getTipoUsuario();
            case 6: return cls.get(rowIndex).getPassword();
//            case 7: return cls.get(rowIndex).getFoto();
            default: return null;    
                
        }
    }
    
}
