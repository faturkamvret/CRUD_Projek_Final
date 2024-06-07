package Controller;

import DAO.DAODiary;
import DAOInterface.IDAODiary;
import DAOInterface.IDAOUser;   
import Model.Diary;
import Model.TabelModelDiary;
import View.FormDaftar;
import View.FormDiary;
import View.FormLogin;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerDiary {
    
    public int id_login;
    
    private IDAODiary daoDiary;
    public FormDiary formDiary;
    List<Diary> lstDiary;

    public ControllerDiary(FormDiary formDiary) {
        this.formDiary = formDiary;
        daoDiary = new DAODiary();
        lstDiary = new ArrayList<>();
    }
    
    public ControllerDiary(IDAODiary daoDiary) {
        this.formDiary = formDiary;
        //this.daoDiary = daoDiary;
    }
    
    public ControllerDiary(IDAODiary daoDiary, FormDiary formDiary) {
        this.formDiary = formDiary;
        this.daoDiary = daoDiary;
    }
   

    public void saveDiary(int id_login) {
        String judul = formDiary.getDiaryJudul().getText();
        String isi = formDiary.getDiaryIsi().getText();
        Diary diary = new Diary(judul, isi, id_login);
        boolean isRegistered = daoDiary.insertDiary(diary);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Diary Sukses Ditambahkan");
            resetDiary();
            tabelDiary(id_login);
            // refreshDaftarDiary();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal Menambahkan");
        }
        
    }

    public void updateDiary(int id_diary) {
        Diary diary = daoDiary.getDiaryById(id_diary);
        String judul = formDiary.getDiaryJudul().getText();
        String isi = formDiary.getDiaryIsi().getText();
        if (diary != null) {
            diary.setJudul(judul);
            diary.setIsi(isi);
            daoDiary.updateDiary(diary);
            
        }
        JOptionPane.showMessageDialog(null, "Sukses Update");
    }

    public void deleteDiary(int id_diary) {
        daoDiary.deleteDiary(id_diary); 
        JOptionPane.showMessageDialog(null, "Sukses Hapus");
    }

    public List<Diary> getDiariesByUserId(int id_user) {
        return daoDiary.getDiariesByUserId(id_user);
    }
    
   

    public void showDiaryForm() {
        formDiary.setVisible(true);
    }
    
    public void resetDiary(){
        formDiary.getDiaryJudul().setText("");
        formDiary.getDiaryIsi().setText("");
    }
    
    public void tabelDiary(int idUser){
        lstDiary = daoDiary.getDiariesByUserId(idUser);
        TabelModelDiary tabelDiary = new TabelModelDiary(lstDiary);
        formDiary.getTableDiary().setModel(tabelDiary);
        
    }
    
    public int isiField(int row){
        formDiary.getDiaryJudul().setText(lstDiary.get(row).getJudul());
        formDiary.getDiaryIsi().setText(lstDiary.get(row).getIsi());
        return lstDiary.get(row).getIdDiary();
        
    }
    
    
    public int getUserAktif(){
        return this.id_login;
    }
    
    
}