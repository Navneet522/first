package Client;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class signIn {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    boolean flag = false;
    public signIn(String name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/databaseinventory", "root", "password");
            
            String sytax = "SELECT * FROM userinfo WHERE userName = ? and password = ?";
            pst = (PreparedStatement) con.prepareStatement(sytax);
            pst.setString(1, name);
            pst.setString(2, password);
            rs = pst.executeQuery();
            
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Succussfull logged in");
            }
            else {
                String warning = "Either User Name or Password is wrong";
                JOptionPane.showMessageDialog(null, warning, "Inane warning", JOptionPane.WARNING_MESSAGE);
                flag = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public boolean getMessage() {
        return flag;
    }
}
