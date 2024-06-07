/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Administrator
 */
public class User {

    public User(int idUser, String userUsername, String userPassword, String nama1, String email1) {
        this.id_user = idUser;
        this.username = userUsername;
        this.password = userPassword;
        this.nama = nama1;
        this.email = email1;
    }
    
    // Constructor without idUser (Untuk Register karena id_user otomatis auto_increment)
    public User(String username, String password, String nama, String email) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
    }

    public Integer getId() {
        return id_user;
    }
    
    //OPsional karna ID primary
    public void setId(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
/*    
    // Constructor
    public User(String username, String password, String nama, String email) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
    }
*/    
    private Integer id_user;
    private String username;
    private String password;
    private String nama;
    private String email;
}
