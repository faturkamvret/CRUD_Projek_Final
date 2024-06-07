/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import Model.Kegiatan;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IDAOKegiatan { 
    boolean insertKegiatan(Kegiatan kegiatan);
    void updateKegiatan(Kegiatan kegiatan);
    void deleteKegiatan(int id_kegiatan);
    Kegiatan getKegiatanById(int id_kegiatan);
    List<Kegiatan> getKegiatanByUserId(int id_user);
}