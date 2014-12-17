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

public class printSantri implements JRDataSource{
    private int index = -1;
    private DefaultTableModel _tmData;
    public printSantri(DefaultTableModel tmData)  {
        _tmData = tmData;
    }

    public boolean next() throws JRException {
        index++;
        return (index < _tmData.getRowCount());
    }

    public Object getFieldValue(JRField field) throws JRException{
        Object value ="";
        String fieldName = field.getName();
        if ("id_santri".equals(fieldName)){ value = Integer.parseInt(_tmData.getValueAt(index,0).toString());}
        if ("nama_santri".equals(fieldName)){ value = _tmData.getValueAt(index,1).toString();}
        if ("tpt_lahir".equals(fieldName)){ value = _tmData.getValueAt(index,2).toString();}
        if ("tgl_lahir".equals(fieldName)){ value = _tmData.getValueAt(index,3).toString();}
        if ("jenkel".equals(fieldName)){ value = _tmData.getValueAt(index,4).toString();}
        if ("nama_ibu".equals(fieldName)){ value = _tmData.getValueAt(index,5).toString();}
        if ("nama_bpk".equals(fieldName)){ value = _tmData.getValueAt(index,6).toString();}
        if ("no_telepon".equals(fieldName)){ value = _tmData.getValueAt(index,7).toString();}
        if ("alamat_tinggal".equals(fieldName)){ value = _tmData.getValueAt(index,8).toString();}
     
        return value;
    }
    
}