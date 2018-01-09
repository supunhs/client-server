/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.server;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author supun_k
 */
public class DB {
    static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/dbemp?zeroDateTimeBehavior=convertToNull";
    static String un = "root";
    static String pw = "";
    
    
    public static Connection getCon() throws Exception{
        if(con==null){
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(url, un, pw);
        }
        return con;
    }
}
