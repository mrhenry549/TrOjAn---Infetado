package network;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendFile {
    public SendFile() throws IOException {

        try {

            ServerSocket servsock = new ServerSocket(80);
            File pasta = new File("C:/ftp/");
            File[] listaDeFicheiros = pasta.listFiles();
            
            RecieveCom cc = new RecieveCom();

            /*while (true) {

                Socket sock = servsock.accept();
                byte[] mybytearray = new byte[(int) listaDeFicheiros[cc.msgin].length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(listaDeFicheiros[cc.msgin]));
                bis.read(mybytearray, 0, mybytearray.length);
                OutputStream os = sock.getOutputStream();
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
                
            }*/

        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
