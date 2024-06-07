/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;
import Model.User;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public interface IDAOUser {
    public boolean register(User u)throws SQLException;
    public void update(User u) throws SQLException;
    User getUser(String username, String password);
    boolean registerUser(User user);
    // Read Data
    public List<User> getAll() throws SQLException;
//    public List<Diary> getAll() throws SQLException;
    
}
