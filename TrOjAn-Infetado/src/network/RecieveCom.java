package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RecieveCom {

    DataInputStream din;
    
    public String com;

    public RecieveCom() {
        try {

            ServerSocket servsock = new ServerSocket(80);
            Socket sock = servsock.accept();

           din = new DataInputStream(sock.getInputStream());
           
           com = din.readUTF();

        } catch (Exception e) {

        }
    }

}
