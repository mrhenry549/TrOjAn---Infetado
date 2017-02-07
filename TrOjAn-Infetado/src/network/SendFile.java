package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendFile {
    
    int numero;
    DataInputStream din;

    public SendFile() throws IOException {

        try {

            ServerSocket servsock = new ServerSocket(80);
            File pasta = new File("D:/ftp/");
            File[] listaDeFicheiros = pasta.listFiles();

            while (true) {

                Socket sock = servsock.accept();
                //receber numero do ficheiro
                din = new DataInputStream(sock.getInputStream());
                numero = din.read();
                
                //enviar nome do ficheiro
                DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
                String msgout = listaDeFicheiros[numero].toString();
            
                dout.writeUTF(msgout);
                dout.flush();
                
                //enviar ficheiro
                FileInputStream fis = new FileInputStream(listaDeFicheiros[numero]);
                byte[] buffer = new byte[4096];

                while (fis.read(buffer) > 0) {
                    dout.write(buffer);
                }

            }

        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
