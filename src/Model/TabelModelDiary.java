package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelModelDiary extends AbstractTableModel {
    public TabelModelDiary(List<Diary> listDiary){
        this.listDiary = listDiary;
    }
    List<Diary> listDiary;

    @Override
    public int getRowCount() {
        return this.listDiary.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    
    @Override
    public String getColumnName(int column){
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Isi";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return listDiary.get(rowIndex).getIdDiary();
            case 1:
                return listDiary.get(rowIndex).getJudul();
            case 2:
                return listDiary.get(rowIndex).getIsi();
            default:
                return null;
        }
    }
    
    
}
