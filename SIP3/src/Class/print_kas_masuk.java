/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.text.SimpleDateFormat;

public class print_kas_masuk implements JRDataSource{
    private int index = -1;
    private DefaultTableModel _tmData;
    public print_kas_masuk(DefaultTableModel tmData)  {
        _tmData = tmData;
    }

    public boolean next() throws JRException {
        index++;
        return (index < _tmData.getRowCount());
    }

    public Object getFieldValue(JRField field) throws JRException{
        Object value ="";
       
        
        String fieldName = field.getName();
         
        if ("id".equals(fieldName)){ value = Integer.parseInt(_tmData.getValueAt(index,0).toString());}
        if ("tgl_masuk".equals(fieldName)){ value = (_tmData.getValueAt(index,1).toString());}
        if ("ket_masuk".equals(fieldName)){ value = _tmData.getValueAt(index,2).toString();}
        if ("jumlah_uang".equals(fieldName)){ value = Double.parseDouble(_tmData.getValueAt(index,3).toString());}
        return value;
    
    }
}

