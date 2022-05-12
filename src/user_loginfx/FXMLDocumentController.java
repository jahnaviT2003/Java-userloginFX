/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_loginfx;

import static java.lang.System.out;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Jahnavi Thondepu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField userid;
    
    @FXML
    private TextField pwd;

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    void login(ActionEvent event) {
        String s1 = userid.getText();
        String s2 = pwd.getText();
        try {
            Class.forName ("org.apache.derby.jdbc.ClientDriver");
        } 
        catch (ClassNotFoundException ex) {
            out.println("class not found exception");
        }
        try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/student","root","root");
            
            Statement stmt = con.createStatement();
            System.out.println("Connected");
            ResultSet rs = stmt.executeQuery("select * from root.login where username='"+s1+"' and password='"+s2+"'");

            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Valid User... ");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "InValid User...");
            }
        } 
        catch (SQLException ex) {
            out.println("sqlexception");
        }
 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}