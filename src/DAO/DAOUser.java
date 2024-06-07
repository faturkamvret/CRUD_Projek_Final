package DAO;

import DAOInterface.IDAOUser;
import Helper.KoneksiDB;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOUser implements IDAOUser {
    private Connection con;

    public DAOUser() {
        con = KoneksiDB.getConnection();
    }

    @Override
    public User getUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int idUser = rs.getInt("id_user");
                    String userUsername = rs.getString("username");
                    String userPassword = rs.getString("password");
                    String nama = rs.getString("nama");
                    String email = rs.getString("email");

                    // Logging
                    Logger.getLogger(DAOUser.class.getName()).log(Level.INFO, nama);

                    return new User(idUser, userUsername, userPassword, nama, email);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password salah");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean registerUser(User user) {
        String sql = "INSERT INTO user (username, password, nama, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNama());
            ps.setString(4, user.getEmail());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void update(User u) throws SQLException {
        String sql = "update user set nama=?, username=?, password=?, email=? where id_user=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNama());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setInt(5, u.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idUser = rs.getInt("id_user");
                String userUsername = rs.getString("username");
                String userPassword = rs.getString("password");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                userList.add(new User(idUser, userUsername, userPassword, nama, email));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, e);
        }
        return userList;
    }

    @Override
    public boolean register(User u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
