package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteCom {

    DataInputStream din;

    public ClienteCom() {
        try {

            ServerSocket servsock = new ServerSocket(80);
            Socket sock = servsock.accept();

           din = new DataInputStream(sock.getInputStream());

        } catch (Exception e) {

        }
    }
    
    public String getRead() throws IOException {
         return din.readUTF();
    }

}
