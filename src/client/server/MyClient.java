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
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClient {

    public static Socket s = null;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static List<String> myList;
    String str;

    public void sendData() {
        for (int x = 0; x < 3; x++) {
            System.out.println("Enter Value");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            myList.add(input);
        }

        int i = 0;
        while (i < 3) {

            try {
                //Thread.sleep(3000);
                
                s = new Socket("localhost", 6666);
                dout = new DataOutputStream(s.getOutputStream());
                //dout.writeUTF(input);

                dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();

                System.out.println("message= " + str);
                break;

            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Attempt:= " + (i + 1));
                i++;

            } finally {
                if (i == 3) {
                    System.out.println("Server Down");
                }
                try {

                    if (s != null) {

                        s.close();
                    }

                    if (dout != null) {
                        dout.close();
                    }
                    if (dis != null) {
                        dis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {

        MyClient myclient = new MyClient();
        myclient.sendData();

//        Socket s = null;
//        for (int i = 0; i < 3; i++) {
//            
//            try {
//                Scanner scanner = new Scanner(System.in);
//                String input = scanner.nextLine();
//                Thread.sleep(3000);
//                s = new Socket("localhost", 6666);
//                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//                dout.writeUTF(input);
//                
//                
//                
//                
//                DataInputStream dis = new DataInputStream(s.getInputStream());
//                String str = (String) dis.readUTF();
//                
//                System.out.println("message= " + str);
//                if(str != null){
//                    System.out.println("Response:= " + i);
////                    dout.flush();
////                    dout.close();
//                    s.close();
//                    break;
//                }
//                
//                
//                
//                
//                
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            finally{
//                
//                try {
//                    
//                    s.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                
//               
//            }
//            try{
//                s = new Socket("localhost", 6666);
//                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//                dout.writeUTF(input);
//            }
//            catch(Exception e){
//                
//            }
    }
//        try {
//            Socket s = new Socket("localhost", 6666);
//            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//            dout.writeUTF("Hello Server");
//            
//            
//            
//            DataInputStream dis = new DataInputStream(s.getInputStream());
//            String str = (String) dis.readUTF();
//            System.out.println("message= " + str);
//            
//            dout.flush();
//            dout.close();
//            s.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

}
