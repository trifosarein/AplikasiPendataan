/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testaplikasiform;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Trifosa Reinhard
 */
public class Koneksi {
    Connection con;
    Statement stat;
    
    public void config(){
        String server="";
        String namadb="";
        String username="";
        String password="";
        java.io.File file = new java.io.File("database.txt");
        try {
            Scanner input = new Scanner(file);
            server = input.nextLine();
            namadb = input.nextLine();
            username = input.nextLine();
            password = input.nextLine();
            
        } catch(Exception e){
            System.out.println(e);
        }
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://"+server+"/"+namadb, username, password);
           //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kp", "root", "");
           stat=con.createStatement();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
