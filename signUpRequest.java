package Client;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class signUpRequest {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    boolean flag = false;
    public signUpRequest(String name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/databaseinventory", "root", "password");
            
            String syntax = "SELECT * FROM userinfo WHERE userName = ?";
            pst = (PreparedStatement) con.prepareStatement(syntax);
            pst.setString(1, name);
            rs = pst.executeQuery();
            
            if(rs.next()) {
                //i.e. user already exist 
                String warning = "Already one User exist with same user name";
                JOptionPane.showMessageDialog(null, warning, "Inane warning", JOptionPane.WARNING_MESSAGE);
                flag = true;
            }
            else {
                //create a user in the database
                new signUpConfirmed(name, password);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(signUpRequest.class.getName()).log(Level.SEVERE, null, ex);
        }  
    } 

    boolean getMessage() {
        return flag;
    }
}
