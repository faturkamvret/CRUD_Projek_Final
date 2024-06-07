    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAOInterface.IDAOUser;
import Model.User;
import View.FormDaftar;
import View.FormLogin;
import View.ViewHome;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerUser {
    private IDAOUser daoUser;
    private FormLogin loginView;
    private FormDaftar registerView;

    public ControllerUser(IDAOUser daoUser, FormLogin loginView, FormDaftar registerView) {
        this.daoUser = daoUser;
        this.loginView = loginView;
        this.registerView = registerView;
    }

    public void loginUser() {
        String username = loginView.getLoginUsername().getText();
        String password = loginView.getLoginPassword().getText();

        User user = daoUser.getUser(username, password);
        if (user != null) {
            String namaUser = user.getNama();
            JOptionPane.showMessageDialog(null, "Berhasil Login");

            // Membuat instance dari ViewHome dan mengirim data berupa nama untuk ditampilkan pada Home
            ViewHome viewHome = new ViewHome(user.getId());
            viewHome.setUserNama(user.getNama());
            viewHome.setVisible(true);
            loginView.dispose(); // Menutup form login
            
        }
    }
    
    public void openLoginView() {
        loginView.setVisible(true);
        registerView.dispose(); // Menutup form register
    }
    

    public void openRegisterView() {
        registerView.setVisible(true);
        loginView.dispose(); // Menutup form login
    }

    public void registerUser() {
        String frmUsername = registerView.getDaftarUsername().getText();
        String frmPassword = registerView.getDaftarPassword().getText();
        String frmNama = registerView.getDaftarNama().getText();
        String frmEmail = registerView.getDaftarEmail().getText();
        User user = new User(frmUsername, frmPassword, frmNama, frmEmail);
        boolean isRegistered = daoUser.registerUser(user);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Registration successful");
            registerView.dispose();
            loginView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed");
        }
    }

}

