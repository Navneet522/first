package Client;

import Server.GUI.brandSwingUI;
import Server.mySqlConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class signUpConfirmed {
    Connection con;
    PreparedStatement pst;
    signUpConfirmed(String name, String password) {
        try {
            con = mySqlConnection.getConnection();
            
            String syntax = "insert into userinfo(UserName, password) Values(?, ?)";
            pst = (PreparedStatement) con.prepareStatement(syntax);
            
            pst.setString(1, name);
            pst.setString(2, password);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Succussfully created the Account and logged in");
            brandSwingUI ui = new brandSwingUI();
            ui.hide();
            ui.setVisible(true);
            System.out.println("Called the brandSwingUI");
            
        } catch (SQLException ex) {
            Logger.getLogger(signUpConfirmed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
