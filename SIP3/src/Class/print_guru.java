/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class print_guru implements JRDataSource{
    private int index = -1;
    private DefaultTableModel _tmData;
    public print_guru(DefaultTableModel tmData)  {
        _tmData = tmData;
    }

    public boolean next() throws JRException {
        index++;
        return (index < _tmData.getRowCount());
    }

    public Object getFieldValue(JRField field) throws JRException{
        Object value ="";
        String fieldName = field.getName();
        if ("id_guru".equals(fieldName)){ value = Integer.parseInt(_tmData.getValueAt(index,0).toString());}
        if ("nama_guru".equals(fieldName)){ value = _tmData.getValueAt(index,1).toString();}
        if ("jenkel".equals(fieldName)){ value = _tmData.getValueAt(index,2).toString();}
        if ("no_telepon".equals(fieldName)){ value = _tmData.getValueAt(index,3).toString();}
        if ("alamat".equals(fieldName)){ value = _tmData.getValueAt(index,4).toString();}
        return value;
    }
    
}
