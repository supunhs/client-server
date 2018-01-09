/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi;

/**
 *
 * @author supun_k
 */
import java.io.*;
import java.net.*;
import java.util.List;

public class TCPClient {
    public static List<String> myList;
    public void client(String x) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            
            String clientMessage = x;
            String serverMessage = "";
            while (!clientMessage.equals("bye")) {
//                System.out.println("Enter number :");
//                clientMessage = br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
                serverMessage = inStream.readUTF();
                System.out.println(serverMessage);
            }
            outStream.close();
            outStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        
        for(int i=0;i<3;i++){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String value = br.readLine();
            myList.add(value);
        }
        for(int x=0;x<3;x++){
            TCPClient tcp = new TCPClient();
            String y = myList.get(x);
            tcp.client(y);
        }
    }
}
