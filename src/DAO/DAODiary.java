package DAO;

import DAOInterface.IDAODiary;
import Model.Diary;
import Helper.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DAODiary implements IDAODiary{

    
    private Connection con;

    public DAODiary() {
        con = KoneksiDB.getConnection();
    }

    @Override
    public boolean insertDiary(Diary diary) {
        String sql = "INSERT INTO diary (judul, isi, id_user) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, diary.getJudul());
            ps.setString(2, diary.getIsi());
            ps.setInt(3, diary.getIdUser());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void updateDiary(Diary diary) {
        String sql = "UPDATE diary SET judul = ?, isi = ? WHERE id_diary = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, diary.getJudul());
            ps.setString(2, diary.getIsi());
            ps.setInt(3, diary.getIdDiary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDiary(int id_diary) {
        String sql = "DELETE FROM diary WHERE id_diary = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_diary);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Diary getDiaryById(int id_diary) {
        String sql = "SELECT * FROM diary WHERE id_diary = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_diary);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_diary");
                String judul = rs.getString("judul");
                String isi = rs.getString("isi");
                int id_user = rs.getInt("id_user");
                return new Diary(id, judul, isi, id_user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Diary> getDiariesByUserId(int id_user) {
        List<Diary> diaries = new ArrayList<>();
        String sql = "SELECT * FROM diary WHERE id_user = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_diary = rs.getInt("id_diary");
                String judul = rs.getString("judul");
                String isi = rs.getString("isi");
                diaries.add(new Diary(id_diary, judul, isi, id_user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diaries;
    }
    
}
