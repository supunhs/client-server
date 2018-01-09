/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multithreaded;
import java.net.*;
import java.io.*;
/**
 *
 * @author supun_k
 */
public class MultithreadedSocketServer {
    public static ServerSocket server;
    public void socketServer(){
        try {
            server = new ServerSocket(8888);
            int counter = 0;
            System.out.println("Server Started ....");
            while (true) {
                counter++;
                Socket serverClient = server.accept();  //server accept the client connection request
                //System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient, counter); //send  the request to a separate thread
                sct.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                if(server!=null){
                    server.close();
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        MultithreadedSocketServer mss = new MultithreadedSocketServer();
        mss.socketServer();
    }
}
