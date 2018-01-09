/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.server;

import static client.server.DB.con;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author supun_k
 */
public class InsertData {
    public static PreparedStatement ps;
    public void save(String str){
        try{
            Connection con = DB.getCon();
            String sql = "INSERT INTO client (data) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, str);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
        finally{
            try{
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
