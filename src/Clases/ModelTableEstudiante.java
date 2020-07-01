/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("unchecked")
public class ModelTableEstudiante extends AbstractTableModel {
  
    private String[] nombreColumnas = {"Codigo","Codigo Plan","DI","Nombres","Apellidos","Email","Genero","Tipo Usuario"};
    private ArrayList<Estudiante> cls;
    
    public void actulizarDatos(ArrayList<Estudiante>cls){
        this.cls = cls;
    }
    
    public ModelTableEstudiante(ArrayList<Estudiante> cls) {
        this.cls = cls;
    }

    public ModelTableEstudiante() {
    }

    public void setEstudiante(ArrayList<Estudiante> cls) {
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
    
    public Estudiante getFila(int index)
    {
        return cls.get(index);
    }
    @SuppressWarnings("unchecked")
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return cls.get(rowIndex).getCodigo();
            case 1: return cls.get(rowIndex).getCodigoPlan();
            case 2: return cls.get(rowIndex).getDocumentoIdentidad();
            case 3: return cls.get(rowIndex).getNombres();    
            case 4: return cls.get(rowIndex).getApellidos();    
            case 5: return cls.get(rowIndex).getEmail();
            case 6: return cls.get(rowIndex).getGenero();
            case 7: return cls.get(rowIndex).getTipoUsuario();
            case 8: return cls.get(rowIndex).getPassword();
            default: return null;    
                
        }
    }
    
}
