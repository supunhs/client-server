/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded;

import client.server.InsertData;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author supun_k
 */
class ServerClientThread extends Thread {
    public static String clientMessage = "", serverMessage = "";
    Socket serverClient;
    int clientNo;
    public static DataInputStream inStream;
    public static DataOutputStream outStream;

    ServerClientThread(Socket inSocket, int counter) {
        serverClient = inSocket;
        clientNo = counter;
    }
    @Override
    public void run() {
        try {
            inStream = new DataInputStream(serverClient.getInputStream());
            outStream = new DataOutputStream(serverClient.getOutputStream());
            
            while (true) {
                clientMessage = inStream.readUTF();
                if (clientMessage == "bye") {
                    
                    System.out.println("From Client-" + clientNo + ": Number is :" + clientMessage);
                    InsertData insertData = new InsertData();
                    insertData.save(clientMessage);
                    serverMessage = "From Server to Client-" + clientNo + " Done... ";
                    outStream.writeUTF(serverMessage);
                }
//                clientMessage = inStream.readUTF();
//                System.out.println("From Client-" + clientNo + ": Number is :" + clientMessage);
//                InsertData insertData = new InsertData();
//                insertData.save(clientMessage);
//                serverMessage = "From Server to Client-" + clientNo + " Done... ";
//                outStream.writeUTF(serverMessage);

            }
//            inStream.close();
//            outStream.close();
//            serverClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
//                System.out.println("Client -" + clientNo + " exit!! ");
                if (inStream != null) {
                    outStream.flush();
                    inStream.close();
                }
                if (outStream != null) {
                    outStream.flush();
                    outStream.close();
                }
                if (serverClient != null) {
                    serverClient.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
