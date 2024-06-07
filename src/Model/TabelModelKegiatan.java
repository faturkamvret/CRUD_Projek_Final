package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelModelKegiatan extends AbstractTableModel {
    public TabelModelKegiatan(List<Kegiatan> listKegiatan){
        this.listKegiatan = listKegiatan;
    }
    List<Kegiatan> listKegiatan;

    @Override
    public int getRowCount() {
        return this.listKegiatan.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }
    
    
    @Override
    public String getColumnName(int column){
        switch(column) {
            case 0:
                return "Saran Kegiatan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return listKegiatan.get(rowIndex).getNamaKegiatan();
            default:
                return null;
        }
    }
    
    
}
