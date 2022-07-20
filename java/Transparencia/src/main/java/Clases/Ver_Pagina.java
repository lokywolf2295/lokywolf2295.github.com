/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Resul;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dpacheco
 */
public class Ver_Pagina {
    
    public void visualizar(JTable tabla, ArrayList<Resul> ar){
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("Nombres");
        dt.addColumn("A. Paterno");
        dt.addColumn("A. Materno");
        dt.addColumn("Institución");
        dt.addColumn("T. Sanción");
        dt.addColumn("Categioria");
        dt.addColumn("Estado");
        ArrayList<String>list = new ArrayList<String>();
        list = (ArrayList)ar.clone();
        Object fila[] = new Object[7];
            try{
                if(list.size() > 0){
                fila[0] = list.get(5);
                fila[1] = list.get(6);
                fila[2] = list.get(7);
                fila[3] = list.get(8);
                fila[4] = list.get(9);
                fila[5] = list.get(10);
                fila[6] = list.get(11);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, list.get(4));
                System.out.println(ex.getMessage());
            }
            dt.addRow(fila);
            tabla.setModel(dt);
    }
    
}
