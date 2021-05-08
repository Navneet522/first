package Client;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class signUpConfirmed {
    Connection con;
    PreparedStatement pst;
    signUpConfirmed(String name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/databaseinventory", "root", "password");
            
            String syntax = "insert into userinfo(UserName, password) Values(?, ?)";
            pst = (PreparedStatement) con.prepareStatement(syntax);
            
            pst.setString(1, name);
            pst.setString(2, password);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Succussfully created the Account and logged in");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(signUpConfirmed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
