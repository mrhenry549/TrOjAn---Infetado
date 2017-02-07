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

        String result = "";
        int i = 0;

        if (listaDeFicheiros.length > 0) {
            StringBuilder sb = new StringBuilder();

            for (File file : listaDeFicheiros) {
                if (file.isFile()) {
                    sb.append(i).append(". ").append(file).append(",");
                    i++;
                }
            }

            result = sb.deleteCharAt(sb.length() - 1).toString();
        }
        
        try {
            ServerSocket ssoc = new ServerSocket(PORTO);
            Socket sock = ssoc.accept();

            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            dout.writeUTF(result);
            dout.flush();

        } catch (Exception e) {

        }

    }
}
