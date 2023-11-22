/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class modeldatabase {
    Connection cn;
    Statement stu;
    ResultSet rsud;
    
    public modeldatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sppeval_raden","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public ResultSet ambildata(String sql) {
        try {
            stu = cn.createStatement();
            rsud = stu.executeQuery(sql);
            return rsud;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    public boolean rubahdata(String sql){
        try {
            stu =  cn.createStatement();
            stu.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
