package Clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 
 */
@SuppressWarnings("unchecked")
public class ModelTableDocente extends AbstractTableModel{
    
    private String[] nombreColumnas = {"Documento Identidad","Nombres","Apellidos","Email","Genero","Tipo Usuario"};
    private ArrayList<Docente> cls;

    public void actualizarDatos(ArrayList<Docente> cls) {
        this.cls = cls;
    }
    public ModelTableDocente(ArrayList<Docente> cls) {
        this.cls = cls;
    }

    public ModelTableDocente() {
    }

    public void setDocente(ArrayList<Docente> cls) {
        this.cls = cls;
    }
    @SuppressWarnings("unchecked")
    @Override
    public int getRowCount() {
        return cls.size();
    }
    @SuppressWarnings("unchecked")
    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }
    @SuppressWarnings("unchecked")
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Docente getFila(int index)
    {
        return cls.get(index);
    }
    @SuppressWarnings("unchecked")
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
