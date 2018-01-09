/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.server;

/**
 *
 * @author supun_k
 */
import java.io.*;  
import java.net.*;  
import java.sql.Connection;
import java.sql.PreparedStatement;
public class MyServer {
    public static ServerSocket ss;
    public static DataOutputStream dout;
        public static DataInputStream dis;
    public void getServer(){
        while(true){
            try{
                ss = new ServerSocket(6666);
                Socket s = ss.accept();
                dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message= " + str);
                
                //create the DB class for save the data
                InsertData insertdata = new InsertData();
                insertdata.save(str);
                
                dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF("Done...");
                
               
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
                //ss.close();
                try{
                    if(ss != null){
                        ss.close();
                    }
                    if(dout != null){
                        dout.close();
                    }
                    if(dis != null){
                        dis.close();
                    }
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        
        MyServer myserver = new MyServer();
        myserver.getServer();
//        while (true) {            
//            try {
//            ServerSocket ss = new ServerSocket(6666);
//            Socket s = ss.accept();//establishes connection   
//            DataInputStream dis = new DataInputStream(s.getInputStream());
//            String str = (String) dis.readUTF();
//            System.out.println("message= " + str);
//            
//            Connection con = DB.getCon();
//            
//            try{
//                String sql = "INSERT INTO client (data) VALUES (?)";
//                
//                PreparedStatement ps = con.prepareStatement(sql);
//                ps.setString(1, str);
//                ps.executeUpdate();
//                
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//            finally{
//                con.close();
//            }
//            
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//            dout.writeUTF("Done...");
//            
//            ss.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        }
//        try {
//            ServerSocket ss = new ServerSocket(6666);
//            Socket s = ss.accept();//establishes connection   
//            DataInputStream dis = new DataInputStream(s.getInputStream());
//            String str = (String) dis.readUTF();
//            System.out.println("message= " + str);
//            
//            String sql = "INSERT INTO client (data) VALUES (?)";
//            Connection con = DB.getCon();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, str);
//            ps.executeUpdate();
//            con.close();
//            
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//            dout.writeUTF("Done...");
//            
//            ss.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
} 
