package Controller;

import DAO.DAOKegiatan;
import DAOInterface.IDAOKegiatan;
import Model.Kegiatan;
import Model.TabelModelKegiatan;
import View.FormKegiatan;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerKegiatan {
    private IDAOKegiatan daoKegiatan;
    private FormKegiatan formKegiatan;
    private List<Kegiatan> listKegiatan;

    public ControllerKegiatan(IDAOKegiatan daoKegiatan, FormKegiatan formKegiatan) {
        this.daoKegiatan = daoKegiatan;
        this.formKegiatan = formKegiatan;
    }

    public void saveKegiatan(int id_login) {
        // Implementasi metode saveKegiatan
    }

    public void updateKegiatan(int id_kegiatan) {
        // Implementasi metode updateKegiatan
    }

    public void deleteKegiatan(int id_kegiatan) {
        // Implementasi metode deleteKegiatan
    }

    public List<Kegiatan> getKegiatanByUserId(int id_user) {
        // Implementasi metode getKegiatanByUserId
        return daoKegiatan.getKegiatanByUserId(id_user);
    }

    public void tabelKegiatan(int idUser) {
        listKegiatan = getKegiatanByUserId(idUser);
        TabelModelKegiatan tableModelKegiatan = new TabelModelKegiatan(listKegiatan);
        formKegiatan.getTableKegiatan().setModel(tableModelKegiatan);
    }

    public int isiField(int row) {
        // Implementasi metode isiField
        return 0;
    }
}