package DAO;

import DAOInterface.IDAOKegiatan;
import Helper.KoneksiDB;
import Model.Kegiatan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOKegiatan implements IDAOKegiatan {
    private Connection con;
    
    public DAOKegiatan() {
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<Kegiatan> getKegiatanByUserId(int userId) {
        List<Kegiatan> kegiatanList = new ArrayList<>();
        String query = "SELECT k.id_kegiatan, k.nama, k.jenis " +
                       "FROM kegiatan_user ku " +
                       "JOIN kegiatan k ON ku.id_kegiatan = k.id_kegiatan " +
                       "WHERE ku.id_user = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Kegiatan kegiatan = new Kegiatan();
                kegiatan.setIdkegiatan(resultSet.getInt("id_kegiatan"));
                kegiatan.setNamaKegiatan(resultSet.getString("nama"));
                kegiatan.setJenisKegiatan(resultSet.getString("jenis"));
                kegiatanList.add(kegiatan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kegiatanList;
    }

    @Override
    public boolean insertKegiatan(Kegiatan kegiatan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateKegiatan(Kegiatan kegiatan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteKegiatan(int id_kegiatan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Kegiatan getKegiatanById(int id_kegiatan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}