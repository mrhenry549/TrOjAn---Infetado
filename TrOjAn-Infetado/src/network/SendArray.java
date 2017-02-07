package network;

import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class SendArray {

    private final int PORTO = 80;

    public SendArray() {

        File pasta = new File("C:/ftp/");
        File[] listaDeFicheiros = pasta.listFiles();
        
        try {
            ServerSocket ssoc = new ServerSocket(PORTO);
            Socket sock = ssoc.accept();
            
            int i = 0;

            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            for (File file : listaDeFicheiros) {
                if (file.isFile()) {
                    dout.writeUTF(i+". "+file);
                    i++;
                }
            }

        } catch (Exception e) {

        }

    }
}
