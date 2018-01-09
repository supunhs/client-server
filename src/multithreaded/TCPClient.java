/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded;

/**
 *
 * @author supun_k
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TCPClient {

    public static Socket socket;
    public static DataInputStream inStream;
    public static DataOutputStream outStream;
    public static BufferedReader br;
    public static List<String> myList = new ArrayList<String>();

    public void Client() {
        
        
//        while (i < 3) {
            try {
                socket = new Socket("127.0.0.1", 8888);
                inStream = new DataInputStream(socket.getInputStream());
                outStream = new DataOutputStream(socket.getOutputStream());
                br = new BufferedReader(new InputStreamReader(System.in));
                String clientMessage = "", serverMessage = "";
                while (!clientMessage.equals("bye")) {
                    System.out.println("Enter number :");
                    clientMessage = br.readLine();
                    myList.add(clientMessage);
//                    outStream.writeUTF(clientMessage);
//                    outStream.flush();
//                    serverMessage = inStream.readUTF();
//                    System.out.println(serverMessage);
//                    TCPClient tcpClient = new TCPClient();
//                    tcpClient.Client();
                    
                }
                for(int i=0;i < myList.size();i++){
                    TCPClient tcpClient = new TCPClient();
                    tcpClient.Client();
                }
//                break;

            } catch (Exception e) {
                //System.out.println(e);
//                System.out.println("Attempt:= " + (i + 1));
//                i++;
            } finally {
                try {
                    if (inStream != null) {
                        inStream.close();
                    }
                    if (outStream != null) {
                        outStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
//        }
//        try {
//            socket = new Socket("127.0.0.1", 8888);
//            inStream = new DataInputStream(socket.getInputStream());
//            outStream = new DataOutputStream(socket.getOutputStream());
//            br = new BufferedReader(new InputStreamReader(System.in));
//            String clientMessage = "", serverMessage = "";
//            while (!clientMessage.equals("bye")) {
//                System.out.println("Enter number :");
//                clientMessage = br.readLine();
//                outStream.writeUTF(clientMessage);
//                outStream.flush();
//                serverMessage = inStream.readUTF();
//                System.out.println(serverMessage);
//            }
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        finally{
//            try{
//                if (inStream != null) {
//                    inStream.close();
//                }
//                if(outStream!=null){
//                    outStream.close();
//                }
//                if(socket!=null){
//                    socket.close();
//                }
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//            
//        }
    }

    public static void main(String[] args) throws Exception {
        TCPClient tcpClient = new TCPClient();
        tcpClient.Client();
        
    }
}
